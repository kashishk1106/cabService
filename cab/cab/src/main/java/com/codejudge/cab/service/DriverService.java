package com.codejudge.cab.service;

import org.springframework.http.HttpStatus;

import com.codejudge.cab.request.Location;
import com.codejudge.cab.request.RegisterRequestDTO;
import com.codejudge.cab.response.AvailableCabs;
import com.codejudge.cab.response.RegisterResponseDTO;

public interface DriverService {

	RegisterResponseDTO getRegister(RegisterRequestDTO request);

	HttpStatus saveLocation(Location location);

	AvailableCabs getLocation(Location location);

}
