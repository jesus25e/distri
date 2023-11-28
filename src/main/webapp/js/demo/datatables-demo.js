// Call the dataTables jQuery plugin
$(document).ready(function () {
    let dataTable = $("#dataTable").DataTable({  
        ajax: 'alumnocrud?tipo=1',
        columns: [
            {data: 'codiAlum'},
            {data: 'appaAlum'},
            {data: 'apmaAlum'},
            {data: 'nombAlum'}
        ]
    });
});
