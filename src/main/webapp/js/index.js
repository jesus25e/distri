$(document).ready(function () {
    $("#btnIniciar").click(function () {
        let logi = $("#txtLogin").val();
        let pass = $("#txtClave").val();
        let parametro = {logi: logi, pass: pass};
        $.getJSON("validar", parametro, function (data) {
            console.log(data);
            if (data.resultado === "OK") {
                $(location).attr('href',"principal.html");
            } else {
                alert("ERROR");
            }
        });
    });
});