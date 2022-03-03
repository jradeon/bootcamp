package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class AlquileresDetailsDTO {
	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("Cliente")
	private int customer;
	@JsonProperty("Pelicula")
	private int inventory;
	@JsonProperty("Empleado")
	private int empleado;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonProperty("Fecha de Alquiler")
	private Date rentalDate;
	@JsonProperty("Fecha devolución")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;
	private List<Integer> pagos;

	public static AlquileresDetailsDTO from(Rental source) {
		return new AlquileresDetailsDTO(
				source.getRentalId(),
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(),
				source.getStaff().getStaffId(),
				source.getRentalDate(),
				source.getReturnDate(),
				null
		// source.getCustomer().getFirstName() + " " +
		// source.getCustomer().getLastName(),
		// source.getInventory().getFilm().getTitle(), // acceder a través de las tablas
		// source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
		// source.getRentalDate(),

		);
	}
}
