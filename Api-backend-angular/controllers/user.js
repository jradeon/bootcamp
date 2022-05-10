"use strict";
//módulos
var bcrypt = require("bcrypt-nodejs");
const { status } = require("express/lib/response");

//modelos
var User = require("../models/user");

// servicio jwt
var jwt = require('../services/jwt');

//acciones
function pruebas(req, res) {
  res.status(200).send({
    message: "Probando el controlador de usuarios y la acción pruebas", user: req.user
  });
}

function saveUser(req, res) {
  //Crear el objeto del Usuario
  var user = new User();

  //Recoger los parámetros que nos llegan de la petición
  var params = req.body;

  // Comprobar si llega la password
  if (params.password && params.name && params.surname && params.email) {
    // Asignar valores al usuario
    user.name = params.name;
    user.surname = params.surname;
    user.email = params.email;
    user.role = "ROLE_USER";
    user.image = null;

    User.findOne({ email: user.email.toLowerCase()}, (err, issetUser) => {
      if (err) {
        res.status(500).send({ message: "Error al comprobar el usuario" });
      } else {
        if (!issetUser) {
          // Cifrar la contraseña
          bcrypt.hash(params.password, null, null, function (err, hash) {
            user.password = hash;
            // Guardo usuario en Base de Datos
            user.save((err, userStored) => {
              if (err) {
                res.status(500).send({ message: "Error al Guardar el usuario" });
              } else {
                if (!userStored) {
                  res.status(404).send({ message: "No se ha registrado el usuario" });
                } else {
                  res.status(200).send({ user: userStored });
                }
              }
            });
          });
        } else {
          res.status(200).send({ message: "El usuario no puede registrarse porque ya existe"});
        }
      }
    });
  } else {
    res.status(200).send({
      message:
        "Introduce los datos correctamente para poder registrar al ususario"});
  }
}

function login(req, res){
var params = req.body;
var email = params.email;
var password = params.password;

User.findOne({ email: email.toLowerCase()}, (err, user) => {
    if (err) {
      res.status(500).send({ message: "Error al comprobar el usuario" });
    } else {
      if (user) {
          bcrypt.compare(password, user.password, (err, check) => {
            if(check){

                //comprobar y generar token
                if(params.getToken){
                    //Devolver token jwt
                    res.status(200).send({
                        token: jwt.createToken(user)
                    })
                }else{
                    res.status(200).send({user});
                }
                
            }else{
                res.status(404).send({
                message: 'El usuario no ha podido loguearse correctamente'
            });
            }
          });
          
    } else {
        res.status(404).send({
            message: 'El usuario no ha podido loguearse'
        });
      }
    }
  });
}

function updateUser(req, res){
  var userId = req.params.id;
  var update = req.body;

  if(userId != req.user.sub){
    return res.status(500).send({message: 'No tienes permisos para actualizar el usuario'});
  }

  User.findByIdAndUpdate(userId, update, {new:true}, (err,userUpdated)=> {
    if(err){
      res.status(500).send({message: 'Error al actualizar usuario'});
    }else{
        if(!userUpdated){
          res.status(404).send({message: 'No se ha podido actualizar el usuario'});
        }else{
          res.status(200).send({user: userUpdated});
        }
    }
  })

  res.status(200).send({
    message: 'Actualizar usuario'
});
}

function uploadImage(req, res){
  
  var userId = req.params.id;
  var file_name = 'No subido...';
  
  if(req.file){
    var file_path = req.file.image.path;
    var file_split = file_path.split('\\');
    var file_name = file.split[2];

    res.status(200).send({
      file_path: file_path,
      file_split: file_split,
      file_name: file_name
    });

  }else{
    res.status(500).send({message: 'No se han subido ficheros'});
  }

}

module.exports = {
  pruebas,
  saveUser,
  login,
  updateUser,
  uploadImage
};
