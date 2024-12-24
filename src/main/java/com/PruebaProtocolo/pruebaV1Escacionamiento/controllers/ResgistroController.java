package com.PruebaProtocolo.pruebaV1Escacionamiento.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.PruebaProtocolo.pruebaV1Escacionamiento.models.RegistroModel;
import com.PruebaProtocolo.pruebaV1Escacionamiento.services.RegistroService;

@Controller
public class ResgistroController {

@Autowired
public RegistroService registroService;

   @PostMapping("/registrar") // Maneja las solicitudes POST a /login
    public String registerUser(@ModelAttribute @Validated RegistroModel model) {
        registroService.guardarRegirstro(model);
        return "inicioRegistro"; // Respuesta exitosa
    }
}
