var conector = require('../mySql/mySql');

var temporada = {
    selectAll: function(req, res){
        var serieId = req.params.serieId;
        var query = 'select * from temporada where serieId = ' + serieId + " order by orden asc";
        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            if(err){
                res.status(400).json({
                    ok:false,
                    mensaje:err
                });
            }else{
                res.json({
                    ok:true,
                    temporadas:datos,
                    mensaje: 'el envio fue exitoso'
                });
            }
        });
        
    },
    get: function(req, res) {
        var id = req.params.id;
        var query = 'select * from episodio where temporadaId = ' + id + ' order by orden asc';
        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            res.json({
                ok:true,
                episodios :datos,
                mensaje: 'el envio fue exitoso'
            });
        });
    },
    getEpisodio: function(req, res) {
        var id = req.params.id;
        var query = 'select * from episodio where episodioId = ' + id;
        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            res.json({
                ok:true,
                episodio :datos[0],
                mensaje: 'el envio fue exitoso'
            });
        });
    }
};
module.exports = temporada;