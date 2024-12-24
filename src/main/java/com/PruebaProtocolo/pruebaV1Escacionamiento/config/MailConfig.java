package com.PruebaProtocolo.pruebaV1Escacionamiento.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        
        // Configura las propiedades del servidor SMTP (por ejemplo, Gmail)
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        
        // Tu dirección de correo electrónico y credenciales
        mailSender.setUsername("salvador.fonseca@cua.uam.mx");
        mailSender.setPassword("Muerte626S");

        // Configura las propiedades adicionales necesarias para Gmail (o el servicio SMTP que uses)
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");  // Puedes habilitar el modo de depuración para ver más detalles

        return mailSender;
    }
}
