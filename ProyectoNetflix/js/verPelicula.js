var idEpisodio = findGetParameter("idEpisodio");
var url = 'http://localhost:3000/api/';

fetch(url + "episodio/"+idEpisodio, {
    method: 'GET',
    headers:{
        'Content-Type': 'application/json'
    }
    }).then(res => res.json())
    .catch(error => {
    }).then(response => {
        if(response.ok == false) {
            return;
        }
        console.log(response);
        rellenarDatos(response.episodio);
    });
    function rellenarDatos(dato) {
        let html = "";
        
            const episodio = dato;
            html += "<h1>"+episodio.titulo+"</h1>";
            html += "<iframe width='95%' class='elVideo' src='https://www.youtube.com/embed/"+episodio.youtubeVideoId+"' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>"
        
        $("#reproductor").html(html+'');
    console.log(html);
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
function salir() {
    localStorage.removeItem("usuario");
    location.href = "index.html";
}