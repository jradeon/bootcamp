package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Film;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(value = "Alquileres editables", description = "Version editable de los alquileres.")
public class AlquileresEditDTO {
	
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

	public static AlquileresEditDTO from(Rental source) {
		return new AlquileresEditDTO(
				source.getRentalId(),
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(),
				source.getStaff().getStaffId(),
				source.getRentalDate(),
				source.getReturnDate(),
				source.getPayments().stream().map(item -> item.getPaymentId()).toList()
		);
	}
	
	   public static Rental from(AlquileresEditDTO source) {
	        return new Rental(
	                source.getRentalId(),
	                source.getRentalDate(),
	                source.getReturnDate(), 
	                new Customer (source.getCustomer()),
	                new Inventory (source.getInventory()),                                
	                new Staff (source.getEmpleado())     
	                );
	    }

	   public Rental update(Rental target) {
		   if(target.getCustomer().getCustomerId() != customer)
				target.setCustomer(new Customer(customer));
			if(target.getInventory().getInventoryId() != inventory)
				target.setInventory(new Inventory(inventory));
			if(target.getStaff().getStaffId() != empleado)
				target.setStaff(new Staff(empleado));
			target.setRentalDate(rentalDate);
			target.setReturnDate(returnDate);
			
			
//				// Borra los alquileres que sobran
//				var delAlquiladas = target.getPayments().stream()
//						.filter(item -> !pagos.contains(item.getPaymentId()))
//						.toList();
//				delAlquiladas.forEach(item -> target.removePayment(item));
////				// Añade los alquileres que falta
//				pagos.stream()
//					.filter(idPaymentDTO -> !target.getPayments().stream().anyMatch(alquiler -> alquiler.getPaymentId() == idPaymentDTO))
////					.forEach(idPaymentDTO -> target.addPayment(new Payment(idPaymentDTO)));
				return target;
		}
	}
