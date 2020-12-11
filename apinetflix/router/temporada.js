var express = require('express');
var temporadaControler = require('../controllers/temporada');

var temporadaRouter = express.Router();
temporadaRouter.get('/temporadas/:serieId', temporadaControler.selectAll);
temporadaRouter.get('/temporada/:id', temporadaControler.get);
temporadaRouter.get('/episodio/:id', temporadaControler.getEpisodio);

module.exports = temporadaRouter;