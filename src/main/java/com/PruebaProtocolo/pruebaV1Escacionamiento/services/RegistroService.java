package com.PruebaProtocolo.pruebaV1Escacionamiento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PruebaProtocolo.pruebaV1Escacionamiento.models.RegistroModel;
import com.PruebaProtocolo.pruebaV1Escacionamiento.repository.RegistroRepository;

@Service
public class RegistroService {

    @Autowired
    public RegistroRepository registroRepository;

    public void guardarRegirstro(RegistroModel model) {
        System.out.println("Guardando usuario: " + model);
        registroRepository.save(model);
    }
}
