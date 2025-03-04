package com.PruebaProtocolo.pruebaV1Escacionamiento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.PruebaProtocolo.pruebaV1Escacionamiento.models.LoginModel;
import com.PruebaProtocolo.pruebaV1Escacionamiento.repository.LoginRepository;

@Service
public class LoginServices {

    @Autowired
    private LoginRepository loginRepository;


    public void guardarUsuario(LoginModel model) {
        try {
            // Intentamos guardar el usuario
            System.out.println("Guardando usuario: " + model);
            loginRepository.save(model);
        } catch (DataIntegrityViolationException e) {
            // Capturamos el error si el correo ya existe
            System.out.println("Error: Ya existe un usuario con ese correo electrónico.");
            // Puedes lanzar una excepción personalizada o manejar el error de otra manera
        }
    }


    public boolean iniciarSesion(String email, String password) {
        // Buscar el usuario en la base de datos por su correo electrónico
        LoginModel usuario = loginRepository.findByCorreo(email);

        // Si no se encuentra el usuario, la consulta devuelve null
        if (usuario != null) {
            // Comparar la contraseña proporcionada con la almacenada
            return password.equals(usuario.getContrasena());
        }

        // Si no se encuentra el usuario
        return false;
    }

}
