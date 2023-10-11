package com.qsp.hospitalmanagement.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.hospitalmanagement.util.ResponseStructure;

 
 
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	   @ExceptionHandler(IdNotFound.class)
	    public ResponseEntity<ResponseStructure<String>> IdNotFoundExceptionHandler(IdNotFound ex)
	    {
	    	ResponseStructure<String> structure =new ResponseStructure<>();
	    	structure.setMessage(ex.getMessage());
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setData("Data with given Id are Not Found");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	    }
	   
	   @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			 Map<String ,String> map=new HashMap<>();
			 List<ObjectError> error= ex.getAllErrors();
			 for(ObjectError objectError:error)
			 {
				 FieldError fieldError=(FieldError)objectError;
				 String field=fieldError.getField();
				 String message=fieldError.getDefaultMessage();
				 map.put(field, message);
			 }
			 return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		}
		

		
	 
		 

}
