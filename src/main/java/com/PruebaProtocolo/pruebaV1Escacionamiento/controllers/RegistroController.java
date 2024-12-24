package com.PruebaProtocolo.pruebaV1Escacionamiento.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PruebaProtocolo.pruebaV1Escacionamiento.models.RegistroModel;
import com.PruebaProtocolo.pruebaV1Escacionamiento.services.RegistroService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Controller
public class RegistroController {

    @Autowired
    public RegistroService registroService;

    @PostMapping("/registrar") // Maneja las solicitudes POST a /registrar
    public String registerUser(@ModelAttribute @Validated RegistroModel model, Model uiModel) {
        // Guardar el registro en la base de datos
        registroService.guardarRegirstro(model);

        // Crear un string con los datos del registro para el QR
        String qrData = "Marca: " + model.getMarca_vehiculo() + "\n" +
                        "Modelo: " + model.getModelo_vehiculo() + "\n" +
                        "Año: " + model.getAnio_vehiculo() + "\n" +
                        "Matrícula: " + model.getMatricula_vehiculo() + "\n" +
                        "Fecha de Entrada: " + model.getFecha_entrada() + "\n" +
                        "Fecha de Salida: " + model.getFecha_salida() + "\n" +
                        "Zona: " + model.getZona() + "\n" +
                        "Lugar Reservado: " + model.getLugar_reservado();

        // Generar el código QR
        String qrImageBase64 = generateQRCodeBase64(qrData);

        // Pasar la imagen QR a la vista en formato Base64
        uiModel.addAttribute("qrImage", qrImageBase64);


        return "QR"; // Redirige a la página de inicio del registro
    }

    // Método para generar el código QR y convertirlo en una cadena Base64
    private String generateQRCodeBase64(String data) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // Crear el BitMatrix para el código QR
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 300, 300);

            // Crear la imagen a partir del BitMatrix
            BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 300; j++) {
                    image.setRGB(i, j, bitMatrix.get(i, j) ? 0x000000 : 0xFFFFFF); // Color negro o blanco
                }
            }

            // Convertir la imagen QR a un string Base64
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "PNG", byteArrayOutputStream);
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes); // Convertir a Base64
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return null;
        }

        
    }


    @GetMapping("/inicioRegistro")
    public String iniciarRegistro() {
        return "inicioRegistro"; // nombre de la vista (por ejemplo, un archivo HTML)
    }
}
