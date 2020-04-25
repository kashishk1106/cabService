package com.codejudge.cab.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AvailableCabs {
	
	@JsonProperty("available_cabs")
	ArrayList<RegisterResponseDTO> availableCabs;

}
