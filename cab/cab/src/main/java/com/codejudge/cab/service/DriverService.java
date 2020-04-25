package com.codejudge.cab.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.codejudge.cab.request.Location;
import com.codejudge.cab.request.RegisterRequestDTO;
import com.codejudge.cab.response.AvailableCabs;
import com.codejudge.cab.response.ExceptionResponse;
import com.codejudge.cab.response.RegisterResponseDTO;

public interface DriverService {

	RegisterResponseDTO getRegister(RegisterRequestDTO request) throws ExceptionResponse;

	HttpStatus saveLocation(Location location) throws ExceptionResponse;

	AvailableCabs getLocation(Location location);

}
