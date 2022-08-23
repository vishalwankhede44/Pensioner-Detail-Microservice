package com.cognizant.PensionerDetail.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
@RestController
@SuppressWarnings("PMD.GuardLogStatementJavaUtil")
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
	
	@ExceptionHandler(PensionerNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest webRequest){
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handleUserNotFoundException - Started ");
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage());
		
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handleUserNotFoundException - Ended ");
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND); 
		
	}
	
	@ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleOtherException(Exception ex,WebRequest webRequest){
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handleOtherException - Started ");
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage());
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("CustomizedResponseEntityExceptionHandler - handleOtherException - Ended Message -> {} ",ex.getMessage());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.FORBIDDEN); 
		
	}

	
	
}
