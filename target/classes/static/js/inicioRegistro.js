document.getElementById('forgotPasswordLink').addEventListener('click', function(e) {
    e.preventDefault(); // Evitar que se siga el enlace

    Swal.fire({
        title: 'Recuperar Contraseña',
        text: 'Por favor, ingrese su correo electrónico para recuperar su contraseña.',
        input: 'email',
        inputLabel: 'Correo electrónico',
        inputPlaceholder: 'Correo electrónico',
        showCancelButton: true,
        confirmButtonText: 'Enviar',
        cancelButtonText: 'Cancelar',
        icon: 'info',
        inputValidator: (value) => {
            if (!value) {
                return '¡Por favor ingrese un correo electrónico!';
            }
        }
    }).then((result) => {
        if (result.isConfirmed) {
            const email = result.value;

            // Hacer una solicitud al servidor para enviar el correo de recuperación
            fetch('/recover-password?email=' + email, {
                method: 'POST'
            }).then(response => {
                // Primero, verificar el código de estado
                if (!response.ok) {
                    // Si la respuesta no es exitosa (por ejemplo, error 404)
                    return response.text().then(errorMessage => {
                        if (response.status === 404) {
                            // Mostrar el mensaje de error específico
                            Swal.fire('Error', errorMessage, 'error');
                        } else {
                            // Para otros errores (500, 400, etc.), mostrar un mensaje genérico
                            Swal.fire('Error', 'Hubo un problema al procesar la solicitud.', 'error');
                        }
                    });
                }
                // Si la respuesta es exitosa (código 200)
                return response.text().then(data => {
                    Swal.fire('¡Correo enviado!', data, 'success');
                });
            }).catch(error => {
                // Si hay un error en la solicitud
                Swal.fire('Error', 'Hubo un problema al enviar el correo.', 'error');
            });
        }
    });
});
