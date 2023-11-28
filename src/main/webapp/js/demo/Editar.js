// Esperar a que el documento esté listo
$(document).ready(function () {
    // Manejar el clic en el botón "Editar"
    $("#btnEditar").click(function () {
        // Obtener los datos del formulario de edición
        var codigo = $("#codigo").val();
        var apellidoPaterno = $("#apellidoPaterno").val();
        var apellidoMaterno = $("#apellidoMaterno").val();
        var nombres = $("#nombres").val();

        // Crear un objeto con los datos del formulario
        var datosEditar = {
            tipo: "3", // Tipo 4 para editar
            codigo: codigo,
            apellidoPaterno: apellidoPaterno,
            apellidoMaterno: apellidoMaterno,
            nombres: nombres
        };

        // Enviar los datos al servidor utilizando $.post
        $.post("alumnocrud", datosEditar, function (data) {
              console.log(data);
            if (data.resultado === "OK") {
                // Recargar la página o actualizar la tabla de alumnos después de editar
                location.reload();
            } else {
                alert("ERROR al editar alumno");
            }
        }, "json");
    });
});
