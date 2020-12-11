var conector = require('../mySql/mySql');

var serie = {
    selectAll: function(req, res){
        var query = 'select * from serie';
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
                    series:datos,
                    mensaje: 'el envio fue exitoso'
                });
            }
        });
        
    },
    get: function(req, res) {
        var id = req.params.id;
        var query = 'select * from serie where serieId = ' + id;
        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            res.json({
                ok:true,
                serie :datos[0],
                mensaje: 'el envio fue exitoso'
            });
        });
    }
};
module.exports = serie;