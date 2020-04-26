package com.codejudge.cab.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
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
	@Valid
	@NotNull
	@JsonProperty("name")
	String name;
	@Valid
	@NotNull
	@JsonProperty("email")
	String email;
	@Valid
	@NotNull
	@Digits(integer = 10, fraction = 0)
	@JsonProperty("phone_number")
	BigDecimal phoneNumber;
	@Valid
	@NotNull
	@JsonProperty("license_number")
	String licenseNumber;
	@Valid
	@NotNull
	@JsonProperty("car_number")
	String carNumber;
	
}
