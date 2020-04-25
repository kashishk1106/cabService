package com.codejudge.cab.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Kashish.Kataria
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegisterRequestDTO {
	@NotNull
	@JsonProperty("name")
	String name;
	
	@NotNull
	@JsonProperty("email")
	String email;
	
	@NotNull
	@JsonProperty("phone_number")
	BigDecimal phoneNumber;
	
	@NotNull
	@JsonProperty("license_number")
	String licenseNumber;
	
	@NotNull
	@JsonProperty("car_number")
	String carNumber;
	
}
