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
                return response.text();
            }).then(data => {
                Swal.fire('¡Correo enviado!', data, 'success');
            }).catch(error => {
                Swal.fire('Error', 'Hubo un problema al enviar el correo.', 'error');
            });
        }
    });
});