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
    
}
