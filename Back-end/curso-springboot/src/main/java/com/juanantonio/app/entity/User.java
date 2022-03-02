package com.juanantonio.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users") // creamos la tabla users
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // esto es que el id va a ser de tipo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//para el mapeo a nuestra base de datos
	@NotBlank // para que no se puedan meter datos en blanco
	@Column(length = 50)
	private String name;

	@NotBlank
	@Column(length = 50)
	private String surname;

	@NotBlank
	@Column(name = "mail", nullable = false, length = 50, unique = true)
	private String email;

	private boolean enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}