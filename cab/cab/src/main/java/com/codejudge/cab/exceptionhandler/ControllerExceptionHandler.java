package com.codejudge.cab.exceptionhandler;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codejudge.cab.response.ExceptionResponse;
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler  {
		@ExceptionHandler(CustomException.class)
	    public ResponseEntity<ExceptionResponse> customHandleNotFound(Exception ex, WebRequest request) {

			ExceptionResponse errors = new ExceptionResponse();
	        errors.setReason(ex.getMessage());
	        errors.setStatus(HttpStatus.NOT_FOUND.toString());
	        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	    }

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, null, headers, HttpStatus.OK, request);
	}
	@ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
    // error handle for @Valid
    @Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {
        //Get all fields errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getField()+" "+x.getDefaultMessage())
                .collect(Collectors.toList());

        ExceptionResponse error = new ExceptionResponse("500",errors.get(0));
        return new ResponseEntity<>(error, headers, status);

    }
	@ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public @ResponseBody
    ResponseEntity defaultErrorHandler(HttpServletRequest request, Exception e) {
        ExceptionResponse error = new ExceptionResponse("500","Error");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
