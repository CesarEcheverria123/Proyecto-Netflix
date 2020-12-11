var tipo = findGetParameter("serie");
if(tipo == 'true') {
    document.getElementById("isSerie").style.display="block";

} else {
    document.getElementById("isSerie").style.display="none";
}
function findGetParameter(parameterName) {
    var result = null,
        tmp = [];
    var items = location.search.substr(1).split("&");
    for (var index = 0; index < items.length; index++) {
        tmp = items[index].split("=");
        if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
    }
    return result;
}

function verDetalle(idVista){
    document.getElementById(idVista).style.display="block";
}