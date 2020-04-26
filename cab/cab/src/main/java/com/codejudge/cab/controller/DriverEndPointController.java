package com.codejudge.cab.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codejudge.cab.request.Location;
import com.codejudge.cab.request.RegisterRequestDTO;
import com.codejudge.cab.response.AvailableCabs;
import com.codejudge.cab.response.RegisterResponseDTO;
import com.codejudge.cab.service.DriverService;

@RestController
@RequestMapping("/api/v1")
public class DriverEndPointController {
	@Autowired
	DriverService driverService;
	
	@PostMapping("/driver/register/")
	public ResponseEntity<RegisterResponseDTO> getRegister(@Valid @RequestBody RegisterRequestDTO request){
		return new ResponseEntity<>(driverService.getRegister(request),HttpStatus.CREATED);
	}
	
	@PostMapping("/driver/{id}/sendLocation/")
	public ResponseEntity saveLocation(@PathVariable("id") UUID id,@Valid @RequestBody Location location){
		location.setId(id);
		return new ResponseEntity(driverService.saveLocation(location));
	}
	
	@PostMapping("/passenger/available_cabs/")
	public ResponseEntity<AvailableCabs> saveLocation(@RequestBody Location location) {
		return new ResponseEntity(driverService.getLocation(location),HttpStatus.OK);
	}
	

}
