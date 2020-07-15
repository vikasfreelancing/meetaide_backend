package com.meetaide.meetaide.advices;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author paytm
 */
@ControllerAdvice(basePackages = "com.meetaide.meetaide.controller")
public class GlobalControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleLedgerInvalidParamException(IllegalArgumentException e) {
        return e.getMessage();
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

