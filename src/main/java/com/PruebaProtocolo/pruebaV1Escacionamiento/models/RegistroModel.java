package com.PruebaProtocolo.pruebaV1Escacionamiento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estacionamiento")

public class RegistroModel {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca_vehiculo;
    private String modelo_vehiculo;
    private String anio_vehiculo;
    private String matricula_vehiculo;
    private String fecha_entrada;
    private String fecha_salida;
    private String zona;
    private String lugar_reservado;
    
}
