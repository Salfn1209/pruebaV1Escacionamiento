package com.PruebaProtocolo.pruebaV1Escacionamiento.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.PruebaProtocolo.pruebaV1Escacionamiento.models.RegistroModel;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository <RegistroModel, Long> {
    
}
