package com.PruebaProtocolo.pruebaV1Escacionamiento.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PruebaProtocolo.pruebaV1Escacionamiento.models.LoginModel;
import com.PruebaProtocolo.pruebaV1Escacionamiento.repository.LoginRepository;

@Service
public class LoginServices {
    
    @Autowired
    public LoginRepository loginRepository;

    public void guardarUsuario(LoginModel model) {
        System.out.println("Guardando usuario: " + model);
        loginRepository.save(model);
    }
    
    public boolean iniciarSesion(String email, String password) {
        // Buscar el usuario en la base de datos por su nombre de usuario o correo electrónico
        LoginModel correo = loginRepository.findByCorreo(email);  // Cambié findByUsername a findByCorreo, asumiendo que buscas por correo
        
        // Verificar si el usuario existe
        if (correo != null) { // Verificar que el usuario no sea null
            return password.equals(correo.getContrasena()); // Comparar la contraseña proporcionada con la almacenada
        }
        
        // Si no se encuentra el usuario o las contraseñas no coinciden, el inicio de sesión falla
        return false;
    }
    
}
