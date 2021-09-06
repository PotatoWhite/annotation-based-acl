/*
 * TestControllerAdvice.java 2021. 09. 07
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver CloudPROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.annotationbasedacl.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongju.paek
 */
@Slf4j
@Component
@ControllerAdvice(basePackageClasses = {TestController.class})
public class TestControllerAdvice {

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(Exception.class)
	public void denied(Exception ex) {
		log.info("DENY {}", ex.getMessage());
	}
}