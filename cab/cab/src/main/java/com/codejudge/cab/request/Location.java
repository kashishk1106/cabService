package com.codejudge.cab.request;

import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Location {
	@JsonProperty("id")
	UUID id;
	
	@Valid
	@JsonProperty("latitude")
	Double latitude;
	
	@Valid
	@JsonProperty("longitude")
	Double longitude;
}
