package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.example.domains.entities.Film;
import com.example.domains.entities.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PagosDetailsDTO {
	@JsonProperty("id")
	private int paymentId;
	@JsonProperty("Empleado")
	private String empleado;
	@JsonProperty("total")
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fecha_pago;
	
	public static PagosDetailsDTO from(Payment source) {
		return new PagosDetailsDTO(
				source.getPaymentId(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getAmount(),
				source.getPaymentDate()
				);
				
	}
}

