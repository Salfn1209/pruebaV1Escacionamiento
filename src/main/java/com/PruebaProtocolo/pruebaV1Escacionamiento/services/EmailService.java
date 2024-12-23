package com.PruebaProtocolo.pruebaV1Escacionamiento.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    // Método para enviar el correo de recuperación de contraseña
    public void sendPasswordResetEmail(String to, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tu-email@gmail.com");
        message.setTo(to);
        message.setSubject("Recuperación de Contraseña");
        message.setText("Haga clic en el siguiente enlace para recuperar su contraseña: " + resetLink);
        emailSender.send(message);
    }
}
