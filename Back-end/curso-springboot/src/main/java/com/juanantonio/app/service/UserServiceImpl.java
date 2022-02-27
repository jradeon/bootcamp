package com.juanantonio.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanantonio.app.entity.User;
import com.juanantonio.app.repository.UserRepository;

//lo nombramos como servicio
@Service
public class UserServiceImpl implements UserService{
	
	//Le decimos que nos inyecte nuestro UserRepository
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	@Transactional(readOnly = true) //Método transacional de solo lectura
	public Iterable<User> findAll() {
		//nos va a devolver
		return userRepository.findAll(); 
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) { // Método que página	
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) { 
		return userRepository.findById(id);
	}

	@Override
	@Transactional //cambios pero no de solo lectura
	public User save(User user) { //guardar nuestro usuario o actualizarlo
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	

}
