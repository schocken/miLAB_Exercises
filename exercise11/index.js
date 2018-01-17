var express = require('express');
var app = express();
var router = express.Router();
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var instantMongoCrud = require('express-mongo-crud');
const MongoClient = require('mongodb').MongoClient;
const MONGO_URL = 'mongodb://schocken:eyalhugo123@ds259897.mlab.com:59897/musicdb';
var PORT = 3000;
mongoose.connect(MONGO_URL, { useMongoClient: true });

app.use(bodyParser.json());
var options = {
    host: `localhost:${PORT}`
}
app.use(instantMongoCrud(options));

router.get('/myapi', function(req, res){
    res.send('works well');
});

app.use(router);

app.listen(PORT, ()=>{
    console.log('started at '+PORT);
})
