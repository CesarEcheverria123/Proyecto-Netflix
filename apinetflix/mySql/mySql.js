var mysql = require('mysql');
var connection;
var SQL = {
    
    conectar: function() {
        connection = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: 'root',
            database: 'netflix_clone_db'
          });
          
          connection.connect( err => {
            if (err) throw err;
            console.log('Connected!');
            // creacion del servidor
          });
    },
    ejecutarQuery: function(query, callback) {
        connection.query(query,(err, result)=>{
            if(err){
                console.log(err);
                callback(err);
                return;
            }
            if(result.length===0){
                callback('el reguistro solicitado no exite');
            }else{
            callback(null,result);}
        });
    },
    desconectar: function() {
        connection.end();
        console.log('Desconenctado');
    }
};
module.exports = SQL;
