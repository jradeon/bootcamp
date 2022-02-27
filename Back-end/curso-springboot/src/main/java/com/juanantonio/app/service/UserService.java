package com.juanantonio.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juanantonio.app.entity.User;

public interface UserService {
	//Vamos a declarar nuestros métodos
	
	//Va a devolver un objeto User findAll
	public Iterable<User> findAll();
	
//	también va a tener un método donde va a poder usar paginación y según la implementación
//	podemos pasarle un objetvo que es paginable y devuelve un pageable
	
	public Page<User> findAll (Pageable pageable);
	
//	Otro método que va a devolver un Optional 
	
	public Optional<User> findById(Long id);
	
//	Un método para guardar una entidad o actualizarla
	
	public User save(User user);
	
//	Un método que no devuelve nada para borrar un usuario por ID
	
	public void deleteById(Long id);

}
