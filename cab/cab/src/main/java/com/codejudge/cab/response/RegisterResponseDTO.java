package com.codejudge.cab.response;

import java.math.BigDecimal;
import java.util.UUID;

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
public class RegisterResponseDTO {
	
	@JsonProperty("id")
	UUID id;
	
	@JsonProperty("name")
	String name;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("phone_number")
	BigDecimal phoneNumber;
	
	@JsonProperty("license_number")
	String licenseNumber;
	
	@JsonProperty("car_number")
	String carNumber;
	
}
