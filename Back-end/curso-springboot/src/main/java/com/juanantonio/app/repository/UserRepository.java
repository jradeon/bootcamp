package com.juanantonio.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juanantonio.app.entity.User;

//le decimos que es de tipo repositorio
@Repository 

//hacemos que herede de la interface de JPA para que here
//objetivo tipo USER y nuestra ID que es de tipo long
public interface UserRepository extends JpaRepository<User, Long>{
	

}
