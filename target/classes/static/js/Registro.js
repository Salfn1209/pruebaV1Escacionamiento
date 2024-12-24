document.addEventListener('DOMContentLoaded', function() {

  // Obtener el formulario de registro
  const formSignUp = document.querySelector('.sign-up');

  // Añadir un evento para el envío del formulario
  formSignUp.addEventListener('submit', function(event) {

    // Prevenir el envío del formulario para manejarlo con JavaScript
    event.preventDefault();

    // Obtener los valores de los campos del formulario
    const nombres = document.getElementById('nombres').value.trim();
    const apellidos = document.getElementById('apellidos').value.trim();
    const correo = document.getElementById('correo').value.trim();
    const contrasena = document.getElementById('contrasena').value.trim(); // Usar getElementById() para el campo de contraseña
    const telefono = document.getElementById('telefono').value.trim();

    // Depuración: Ver los valores de los campos
    console.log('Nombres:', nombres);
    console.log('Apellidos:', apellidos);
    console.log('Correo:', correo);
    console.log('Contraseña:', contrasena);  // Verificar si la contraseña se captura correctamente
    console.log('Teléfono:', telefono);

    // Verificar que todos los campos estén completos
    if (nombres && apellidos && correo && contrasena && telefono) {
      
      // Verificar si el correo ya está registrado (llamado al backend)
      fetch(`/verificarCorreo?correo=${correo}`)
        .then(response => response.json()) // Suponiendo que el backend devuelve un valor booleano
        .then(correoExiste => {
          if (correoExiste) {
            // Si el correo ya existe, mostrar una alerta de error
            Swal.fire({
              icon: 'error',
              title: 'Error',
              text: 'Este correo ya está registrado. Por favor, ingresa otro.',
              confirmButtonText: 'Aceptar'
            });
          } else {
            // Si el correo no está registrado, mostrar una alerta de éxito y enviar el formulario
            Swal.fire({
              icon: 'success',
              title: '¡Registro Exitoso!',
              text: 'Ahora puedes iniciar sesión con tu cuenta.',
              confirmButtonText: 'Aceptar'
            }).then(() => {
              formSignUp.submit();  // Enviar el formulario después de la alerta
            });
          }
        })
        .catch(error => {
          console.error('Error al verificar el correo:', error);
          Swal.fire({
            icon: 'error',
            title: 'Error de servidor',
            text: 'Hubo un problema al verificar el correo. Intenta nuevamente más tarde.',
            confirmButtonText: 'Aceptar'
          });
        });
      
    } else {
      // Si algún campo está vacío, mostrar una alerta de error
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Por favor, completa todos los campos.',
        confirmButtonText: 'Aceptar'
      });
    }
  });
});
