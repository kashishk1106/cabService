package com.codejudge.cab.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ExceptionResponse extends RuntimeException{

	String status;
	
	String reason;
}
