document.addEventListener('DOMContentLoaded', function () {
    // Al hacer clic en el botón de cancelar
    document.getElementById("cancelarBtn").addEventListener("click", function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del botón
        
        // Muestra la alerta de SweetAlert
        Swal.fire({
            title: '¿Estás seguro?',
            text: 'Si cancelas, perderás los cambios no guardados.',
            icon: 'warning',
            showCancelButton: true, // Muestra el botón de "Cancelar"
            confirmButtonText: 'Cancelar Registro',
            cancelButtonText: 'Continuar Registro',
            customClass: {
                confirmButton: 'btn-cancelar',  // Clase para el botón de "Cancelar"
                cancelButton: 'btn-continuar'   // Clase para el botón de "Continuar"
            }
        }).then((result) => {
            if (result.isConfirmed) {
                // Si el usuario confirma, redirige a la página de inicio
                window.location.href = '/inicio'; // Ruta de la página de inicio
            } else {
                // Si el usuario cancela, no hace nada
                console.log("El usuario decidió no cancelar.");
            }
        });
    });
});
