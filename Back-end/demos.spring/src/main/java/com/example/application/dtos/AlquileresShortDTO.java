package com.example.application.dtos;


import java.util.Date;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

//con el lombok declaramos las variables y luego se las pasa al constructor
@Value 
public class AlquileresShortDTO {
	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("Fecha de Alquiler")
	private Date rentalDate;
	@JsonProperty("Nombre Cliente")
	private String customer;
	@JsonProperty("Titulo Pelicula")
	private String title;
	
	public static AlquileresShortDTO from(Rental source) {
		return new AlquileresShortDTO(
				source.getRentalId(),
				source.getRentalDate(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getInventory().getFilm().getTitle() //acceder a través de las tablas
				);
	}
}
