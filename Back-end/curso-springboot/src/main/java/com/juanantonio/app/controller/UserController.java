package com.juanantonio.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanantonio.app.entity.User;
import com.juanantonio.app.service.UserService;

@RestController
// anotación combinación entre controller y responsebody
// controller para definir que es un controlador 
//ResponseBody  para indicar que el valor de retorno de nuestros métodos
// debe usarse como el cuerpo de respuesta de la solicitud (por defecto un Json)

@RequestMapping("/api/users")

// El controlador se va a comunicar con los métodos que hemos definido en nuestra interface
// Service

public class UserController {

	// Hay que hacer una infección de dependencias

	@Autowired
	private UserService userService;

	// Create a new user
	@PostMapping // Para crear
	public ResponseEntity<?> create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));

	}

	// Read an user
	@GetMapping("/{id}") // operación get conseguir un usario de la base de datos
							// los valores variables se ponen entre corchetes

	public ResponseEntity<?> read(@PathVariable Long userId) {

		// Controlar excepciones por si el id no existe
		Optional<User> oUser = userService.findById(userId);
		if (!oUser.isPresent()) { // SI NO ESTA PRESENTE UN OBJETO USER
			return ResponseEntity.notFound().build();
		}

		// si todo ha ido bien con el ok, devolvemos nuestro ususario
		return ResponseEntity.ok(oUser);

	}

	// update an user
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId) {
		Optional<User> user = userService.findById(userId);
		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// BeanUtils.copyProperties(userDetails, user.get());
		user.get().setName(userDetails.getName());
		user.get().setSurname(userDetails.getSurname());
		user.get().setEmail(userDetails.getEmail());
		user.get().setEnabled(userDetails.getEnabled());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));

	}

	// Delete an User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
		// Comprobamos si existe la base de datos
		if (!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(userId);
		return ResponseEntity.ok().build();

	}
	
	//Read all Users
	@GetMapping
	public List <User> readAll (){
		List<User> users = StreamSupport // streamSupport que herede de object
		.stream(userService.findAll().spliterator(), false)
		.collect(Collectors.toList()); // nos va a converstir la colección en una lista
		return users;
	}
	

}
