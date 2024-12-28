// Este es un ejemplo básico de código JS dentro de app.js

// Esta función se ejecuta cuando la página se ha cargado completamente
window.onload = function() {
    console.log("La página se ha cargado completamente");

    // Puedes escribir aquí cualquier lógica que quieras ejecutar cuando se cargue la página
    const botonApartar = document.querySelector("#botonApartar");

    // Ejemplo: Evento al hacer clic en un botón
    if (botonApartar) {
        botonApartar.addEventListener("click", function() {
            alert("Formulario enviado con éxito");
        });
    }

    // Ejemplo de cómo mostrar un mensaje con el contenido de un campo de formulario
    const marcaVehiculo = document.querySelector("input[name='marca_vehiculo']");
    if (marcaVehiculo) {
        marcaVehiculo.addEventListener("blur", function() {
            console.log("Marca del vehículo: " + marcaVehiculo.value);
        });
    }
};