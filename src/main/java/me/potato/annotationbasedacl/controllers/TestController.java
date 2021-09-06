/*
 * TestController.java 2021. 09. 06
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver CloudPROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.annotationbasedacl.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.potato.annotationbasedacl.enums.Role;
import me.potato.annotationbasedacl.services.TestService;

/**
 * @author dongju.paek
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {

	private final TestService testService;

	@GetMapping("/level01")
	public String getLevel01(@RequestHeader("Role") Role role) {
		return testService.getLevel01(role, "A1", "A2");
	}

	@GetMapping("/level02")
	public String getLevel02(@RequestHeader("Role") Role role) {
		return testService.getLevel02(role, "A1", "A2");
	}

	@GetMapping("/level03")
	public String getLevel03(@RequestHeader("Role") Role role) {

		return testService.getLevel02(role, "A1", "A2");
	}
}