package com.example.ThinkOnDemo.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ThinkOnDemo.domain.support.JsonResult;

@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	public JsonResult runtimeExceptionHandler(Exception e) {
		return new JsonResult().msg(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal())
				.data(null);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JsonResult exceptionHandler(Exception e) {
		return new JsonResult().msg(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal())
				.data(null);
	}
}
