var conector = require('../mySql/mySql');

var usuario = {
    selectAll: function(req, res){
        var query = 'select * from usuario';
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
                    usuarios:datos,
                    mensaje: 'el envio fue exitoso'
                });
            }
        });
        
    },
    get: function(req, res) {
        var id = req.params.idUsuario;
        var query = 'select * from usuario where usuarioId = ' + id;
        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            res.json({
                ok:true,
                usuario :datos[0],
                mensaje: 'el envio fue exitoso'
            });
        });
    },
    login: function(req, res) {
        var params = req.body;
        var username = params.username;
        var password = params.password;
        var query = "select * from usuario where username= '"+username+"' and password= '"+password +"'";
        conector.conectar();
        console.log(query);
        console.log(req.body)

        conector.ejecutarQuery(query, (err, datos)=>{
            if(err){
                res.status(400).json({
                    ok:false,
                    error:err
                });
            }else{
                
                console.log(datos[0]);
                    res.json({
                        usuario:datos[0]
                    });
                
            }
        });



    },
    insert: function(req, res){
        var body = req.body;
        var username = body.username;
        var password = body.password;
        var query = "insert into usuario (username,password) values ('"+username+"','"+password+"')";

        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            if(err){
                res.status(400).json({
                    ok:false,
                    error:err
                });
            }else{
                res.json({
                    ok:true
                });
            }
        });
    },
    delete: function( req, res) {
        var id = req.params.idUsuario;
        var query = 'delete from usuario where usuarioId = ' + id;
        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            res.json({
                ok:true,
                mensaje: 'el envio fue exitoso'
            });
        });
    },
    update: function( req, res) {
        var id = req.params.idUsuario;
        var body = req.body;
        var nombreCompleto = body.nombreCompleto;
        var username = body.username;
        var password = body.password;
        var query = "update  usuario set nombreCompleto = '"+nombreCompleto+"', username= '"+username+"',password= '"+password+"' where usuarioId= "+ id;

        conector.conectar();
        conector.ejecutarQuery(query, (err, datos)=>{
            if(err){
                res.status(400).json({
                    ok:false,
                    error:err
                });
            }else{
                res.json({
                    ok:true
                });
            }
        });
    }
};
module.exports = usuario;