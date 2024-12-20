package com.PruebaProtocolo.pruebaV1Escacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PruebaProtocolo.pruebaV1Escacionamiento.models.LoginModel;
import com.PruebaProtocolo.pruebaV1Escacionamiento.services.LoginServices;

@Controller
public class LoginControllers {

    @Autowired
    public LoginServices loginServices;

    @GetMapping("/inicio")
    public String login() {
        return "inicioRegistro"; // Esto devolverá el archivo index.html
    }

    @PostMapping("/inicio") // Maneja las solicitudes POST a /login
    public String registerUser(@ModelAttribute @Validated LoginModel model) {
        loginServices.guardarUsuario(model);
        return "mensaje1"; // Respuesta exitosa
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String email, @RequestParam String contrasena) {
        boolean loginExitoso = loginServices.iniciarSesion(email, contrasena);

        if (loginExitoso) {
            return "Registro"; // Respuesta exitosa, redirigir o mostrar mensaje adecuado
        } else {
            return "error"; // Redirigir o mostrar mensaje de error
        }
    }
}