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
@ApiModel(value = "Pagos editables", description = "Version editable de los alquileres.")
public class PagosEditDTO {
		@JsonProperty("id")
		private int paymentId;
		
		@NotNull
		@Positive
		@ApiModelProperty(value = "Identificador del empleado.")
		@JsonProperty("Empleado")
		private int empleado;
		
		@NotNull
		@DecimalMin(value = "0.0", inclusive = false)
		@Digits(integer = 3, fraction = 2)
		@ApiModelProperty(value = "Un máximo de 3 dígitos enteros y 2 decimales.")
		@JsonProperty("total")
		private BigDecimal amount;
		
		@ApiModelProperty(value = "Fecha del pago")
		@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
		private Date fecha_pago;
		
		public static PagosEditDTO from(Payment source) {
			return new PagosEditDTO(
					source.getPaymentId(),
					source.getStaff().getStaffId(),
					source.getAmount(),
					source.getPaymentDate()
					);		
		}

		public static Payment from(PagosEditDTO source, Rental rental) {
			return new Payment(
					source.getPaymentId(),
					source.getAmount(),
					source.getFecha_pago(),
					new Staff(source.getEmpleado()),
					rental
					);
		}
	   
	}
