var express = require('express');
var bodyParser = require('body-parser');

var app = express();

// cargar archivosRutas
var usuarioRouter = require('./router/usuario');
var serieRouter = require('./router/serie');
var temporadaRouter = require('./router/temporada');

// middlewares
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());
// cors
app.use((req, res, next ) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'Authorization, X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Allow-Request-Method');
    res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
    res.header('Allow', 'GET, POST, OPTIONS, PUT, DELETE');
    next();
});

// rutas
app.use('/api', usuarioRouter, serieRouter, temporadaRouter);


// exportar
module.exports = app;
