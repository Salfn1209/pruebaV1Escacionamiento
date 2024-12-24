package com.PruebaProtocolo.pruebaV1Escacionamiento.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.PruebaProtocolo.pruebaV1Escacionamiento.models.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long> {
    LoginModel findByCorreo(String correo);
}
