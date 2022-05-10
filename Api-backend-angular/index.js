// Utilizar nuevas funcionalidades del Ecmascript 6
'use strict'
 
// Cargamos el módulo de mongoose para poder conectarnos a MongoDB
var mongoose = require('mongoose');
var app = require('./app'); // cargamos el fichero app
var port = process.env.port ||3789;
 
// Le indicamos a Mongoose que haremos la conexión con Promesas
mongoose.Promise = global.Promise;
 
const uri = 'mongodb://localhost:27017/zoo';

const options = {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    serverSelectionTimeoutMS: 5000,
    autoIndex: false, // Don't build indexes
    maxPoolSize: 10, // Maintain up to 10 socket connections
    serverSelectionTimeoutMS: 5000, // Keep trying to send operations for 5 seconds
    socketTimeoutMS: 45000, // Close sockets after 45 seconds of inactivity
    family: 4 // Use IPv4, skip trying IPv6
}

const connectWithDB = () => {
    mongoose.connect(uri, options, (err, db) => {
      if (err) console.error(err);
      else console.log("database connection")
      app.listen(port, () => {
          console.log("El servidor local con Node y Express está corriendo correctamente")
      });
    })
}

connectWithDB()
