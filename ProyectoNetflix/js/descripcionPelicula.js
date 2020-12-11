var idSerie = findGetParameter("idSerie");
var url = 'http://localhost:3000/api/';

fetch(url + "serie/"+idSerie, {
    method: 'GET',
    headers:{
        'Content-Type': 'application/json'
    }
    }).then(res => res.json())
    .catch(error => {
        alert("No se pudo cargar la serie")

    }).then(response => {
        if(response.ok == false) {
            alert("No se pudo cargar la serie")

            return;
        }
        console.log(response);
        rellenarDatos(response.serie);
    });
fetch(url + "temporadas/"+idSerie, {
    method: 'GET',
    headers:{
        'Content-Type': 'application/json'
    }
    }).then(res => res.json()).catch(error => {
            alert("No se pudo cargar la serie")
        }).then(response => {
            if(response.ok == false) {
                alert("No se pudo cargar la temporada")
                return;
            }
            console.log(response);
            rellenarDatosPelicula(response.temporadas)
        });
        function rellenarDatosPelicula(temporadas ) {
            let html = "";
            for (let index = 0; index < temporadas.length; index++) {
                const temporada = temporadas[index];
                html += "<li onclick='abrirEpisodio("+temporada.temporadaId+")'> " +temporada.nombreTemporada +" <div id='temp"+temporada.temporadaId+"' class='episoVistas' style = 'display: none'>"
                html += "</div></li>";
            }
            $("#isTemporada").html(html+'');
        }
      function  abrirEpisodio(temporadaId) {
        let listEpiso =  document.getElementsByClassName("episoVistas");
        for (let index = 0; index < listEpiso.length; index++) {
            listEpiso[index].style.display = "none";    
        }
        fetch(url + "temporada/"+temporadaId, {
            method: 'GET',
            headers:{
                'Content-Type': 'application/json'
            }
            }).then(res => res.json())
            .catch(error => {        
            }).then(response => {
                var  html = "<ul>";
                console.log(response);
                if(response.ok == false) {
                    alert("No se pudo cargar la serie")
                    return;
                }
                let episodios = response.episodios;
                if (!episodios) { alert("no tiene episodio"); return;}
                for (let index = 0; index < episodios.length; index++) {
                    html += "<li> <a href='verpelicula.html?idEpisodio="+episodios[index].episodioId+"'>" + episodios[index].titulo;
                    html += "</a></li>";
                } 
                html += "</ul>";
                console.log(html);
                $("#temp"+temporadaId).html(html+'');
                document.getElementById("temp"+temporadaId).style.display="block";

            });

            

      }
function rellenarDatos(serie) {
    let html = "";
        html += "<div class='main video'> <img src='"+serie.portada+"' style='width: 300px; height: 30%;' class='imagendetalle' alt='"+serie.nombreSerie+"'>";
        html += "<div class='explicacion-pelicula'> <h2 class='titulo-pelicula'>"+serie.nombreSerie+" </h2> <p class='titulo-detalle'>"+serie.descripcion+"</p>";
        html +=  "</div></div>";
        
    $("#destino").html(html+'');
       
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
