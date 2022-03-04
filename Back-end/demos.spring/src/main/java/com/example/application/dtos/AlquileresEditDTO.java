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
	@ApiModelProperty(value = "Identificador del alquiler de la película.")
	private int rentalId;
	
	@ApiModelProperty(value = "Identificador del alquiler del cliente.")
	@NotNull
	@Positive
	@JsonProperty("Cliente")
	private int customer;
	
	@NotNull
	@Positive
	@ApiModelProperty(value = "Identificador del inventario de la película.")
	@JsonProperty("Pelicula")
	private int inventory;
	
	@NotNull
	@Positive
	@ApiModelProperty(value = "Identificador del empleado.")
	@JsonProperty("Empleado")
	private int empleado;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonProperty("Fecha de Alquiler")
	@ApiModelProperty(value = "Formato fecha yyyy-MM-dd hh:mm:ss.")
	private Date rentalDate;
	
	@JsonProperty("Fecha devolución")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Formato fecha yyyy-MM-dd hh:mm:ss.")
	private Date returnDate;
	
	@ApiModelProperty(value = "Lista de identificadores de alquileres.")
	private List<PagosEditDTO> pagos;

	public static AlquileresEditDTO from(Rental source) {
		return new AlquileresEditDTO(
				source.getRentalId(),
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(),
				source.getStaff().getStaffId(),
				source.getRentalDate(),
				source.getReturnDate(),
				source.getPayments().stream().map(item -> PagosEditDTO.from(item)).toList() //RECORRE LOS PAYMENT Y LOS CONVIERTE A PAGOSEDITDTO
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
			
			
	// Borra los alquileres que sobran
	var delAlquiladas = target.getPayments().stream()
		.filter(entity -> pagos.stream().noneMatch(dto -> entity.getPaymentId()== dto.getPaymentId()))
		.toList();// buscamos
		delAlquiladas.forEach(item -> target.removePayment(item)); //borramos
				
				
	//Actualizar los alquileres que faltan
		target.getPayments().forEach(entity-> {
					
		var dto = pagos.stream().filter(item -> item.getPaymentId()== entity.getPaymentId()).findFirst().get();
		if(entity.getAmount()!= dto.getAmount()) entity.setAmount(dto.getAmount());
		if(entity.getPaymentDate()!= dto.getFecha_pago()) entity.setPaymentDate(dto.getFecha_pago());
		if(entity.getStaff().getStaffId()!= dto.getEmpleado()) entity.setStaff(new Staff(dto.getEmpleado()));
		});
		
	// Añade los alquileres que faltan
		pagos.stream()
		.filter(dto -> target.getPayments().stream().noneMatch(entity -> entity.getPaymentId()== dto.getPaymentId()))
		.forEach(dto -> target.addPayment(PagosEditDTO.from(dto, target)));
		return target;
		}
	}
