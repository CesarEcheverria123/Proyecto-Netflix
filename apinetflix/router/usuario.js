var express = require('express');
var usuarioController = require('../controllers/Usuario');

var usuarioRouter = express.Router();
usuarioRouter.post('/usuario', usuarioController.insert);
usuarioRouter.post('/usuario/login', usuarioController.login);
usuarioRouter.get('/usuario', usuarioController.selectAll);
usuarioRouter.get('/usuario/:idUsuario', usuarioController.get);
usuarioRouter.put('/usuario/:idUsuario', usuarioController.update);
usuarioRouter.delete('/usuario/:idUsuario', usuarioController.delete);

module.exports = usuarioRouter;