$("#btnAgregar").click(function () {
    var codigo = $("#codigo").val();
    var apellidoPaterno = $("#apellidoPaterno").val();
    var apellidoMaterno = $("#apellidoMaterno").val();
    var nombres = $("#nombres").val();

    var nuevoAlumno = {
        codigo: codigo,
        apellidoPaterno: apellidoPaterno,
        apellidoMaterno: apellidoMaterno,
        nombres: nombres
    };

    // Enviar los datos al servidor mediante $.post
    $.post('alumnocrud?tipo=2', nuevoAlumno, function (data) {
        console.log(data);
        if (data.resultado === "OK") {
            location.reload();
        } else {
            alert("ERROR al agregar alumno");
        }
    }, 'json');
});




