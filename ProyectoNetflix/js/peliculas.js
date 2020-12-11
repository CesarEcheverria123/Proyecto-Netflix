var url = 'http://localhost:3000/api/';
var user = localStorage.getItem("usuario");
if(user == null) {
    window.location.href = "index.html";
} else {
    fetch(url + "series", {
        method: 'GET',
        headers:{
            'Content-Type': 'application/json'
        }
        }).then(res => res.json())
        .catch(error => {
            alert("No se pudo cargar las carteleras")
    
        }).then(response => {
            if(response.ok == false) {
                alert("No se pudo cargar las carteleras")
    
                return;
            }
            console.log(response);
            rellenarDatos(response.series);
        });
}

    function rellenarDatos(dato) {
        let html = "";
        for (let index = 0; index < dato.length; index++) {
            const serie = dato[index];
            html += "<div class='video'>";
            html += "<a href='detallepelicula.html?idSerie="+serie.serieId+"'>";
            html +=    "<img src='"+serie.portada+"' alt='"+serie.nombreSerie+"'>";
            html +=    "<p>"+serie.nombreSerie+"</p></a></div>";
        }
        $("#listadoSeries").html(html+'');
       
    }
   function salir() {
        localStorage.removeItem("usuario");
        location.href = "index.html";
    }