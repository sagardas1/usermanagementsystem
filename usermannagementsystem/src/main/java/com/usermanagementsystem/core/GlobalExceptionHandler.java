package com.usermanagementsystem.core;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usermanagementsystem.baseResponce.BaseResponce;
import com.usermanagementsystem.exception.BaseException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({BaseException.class})
	public BaseResponce responce(BaseException e) {
		BaseResponce baseResponce=new BaseResponce(null, e.getStatusMessage(), e.getStatusCode(), e.isSuccessStatus());
		return baseResponce;
		
	}

}
