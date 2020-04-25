package com.codejudge.cab.service.impl;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codejudge.cab.request.Location;
import com.codejudge.cab.request.RegisterRequestDTO;
import com.codejudge.cab.response.AvailableCabs;
import com.codejudge.cab.response.ExceptionResponse;
import com.codejudge.cab.response.RegisterResponseDTO;
import com.codejudge.cab.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	static ArrayList<RegisterResponseDTO> drivers=new ArrayList<>();
	static ArrayList<Location> locations=new ArrayList<>();
	
	public RegisterResponseDTO getRegister(RegisterRequestDTO request) throws ExceptionResponse {
		RegisterResponseDTO response=convert(request);
		ArrayList<RegisterResponseDTO> checkExisting=(ArrayList<RegisterResponseDTO>) drivers.stream()
				.filter(driver->driver.getPhoneNumber().equals(response.getPhoneNumber()))
				.collect(Collectors.toList());
		if(checkExisting.isEmpty())
			drivers.add(response);
		else	
			throw new ExceptionResponse("Fail","fail");
		return response;
	}

	private RegisterResponseDTO convert(RegisterRequestDTO request) {
		RegisterResponseDTO response=new RegisterResponseDTO();
		response.setCarNumber(request.getCarNumber());
		response.setEmail(request.getEmail());
		response.setPhoneNumber(request.getPhoneNumber());
		response.setLicenseNumber(request.getLicenseNumber());
		response.setName(request.getName());
		response.setId(UUID.randomUUID());
		return response;
	}

	@Override
	public HttpStatus saveLocation(Location location) throws ExceptionResponse {
		ArrayList<RegisterResponseDTO> checkExisting=(ArrayList<RegisterResponseDTO>) drivers.stream()
				.filter(driver->driver.getId().equals(location.getId()))
				.collect(Collectors.toList());
		if(!checkExisting.isEmpty()) {
			locations.add(location);
			return HttpStatus.ACCEPTED;
		}
		else
			throw new ExceptionResponse("Fail","fail");
	}

	@Override
	public AvailableCabs getLocation(Location location) {
		AvailableCabs cabs=new AvailableCabs();
		ArrayList<RegisterResponseDTO> listofDrivers=new ArrayList<>();
		for(Location loc:locations)
		{
			double distance=calculateDistance(loc,location);
			if(distance<4)
			{
				listofDrivers=(ArrayList<RegisterResponseDTO>) drivers.stream()
						.filter(driver->driver.getId().equals(loc.getId()))
						.collect(Collectors.toList());
			}
		}
				cabs.setAvailableCabs(listofDrivers);
				return cabs;
	}

	private double calculateDistance(Location cabLocations, Location location) {
		double dLat = Math.toRadians(location.getLatitude() - cabLocations.getLatitude()); 
        double dLon = Math.toRadians(location.getLongitude() - cabLocations.getLongitude()); 
        cabLocations.setLatitude(Math.toRadians(cabLocations.getLatitude())); 
        location.setLatitude(Math.toRadians(location.getLatitude())); 
        double a = Math.pow(Math.sin(dLat / 2), 2) +  
                   Math.pow(Math.sin(dLon / 2), 2) *  
                   Math.cos(cabLocations.getLatitude()) *  
                   Math.cos(location.getLatitude()); 
        double rad = 6371; 
        double c = 2 * Math.asin(Math.sqrt(a)); 
        return rad * c; 
	}
	
	
}
