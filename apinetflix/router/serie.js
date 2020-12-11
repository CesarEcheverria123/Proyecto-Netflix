var express = require('express');
var serieControler = require('../controllers/serie');

var serieRouter = express.Router();
serieRouter.get('/series', serieControler.selectAll);
serieRouter.get('/serie/:id', serieControler.get);

module.exports = serieRouter;