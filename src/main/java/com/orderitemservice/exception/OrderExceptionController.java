package com.orderitemservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orderitemservice.exception.OrderNotFoundException;

@ControllerAdvice
public class OrderExceptionController {
	@ExceptionHandler(value = OrderNotFoundException.class)
	   public ResponseEntity<Object> exception(OrderNotFoundException exception) {
	      return new ResponseEntity<>("Order not found with the given orderid", HttpStatus.NOT_FOUND);
	   }

}
