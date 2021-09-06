/*
 * TestService.java 2021. 09. 06
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver CloudPROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.annotationbasedacl.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.potato.annotationbasedacl.Permit;
import me.potato.annotationbasedacl.enums.Role;

/**
 * @author dongju.paek
 */
@Slf4j
@Service
public class TestService {

	@Permit(roles = {Role.ADMIN, Role.USER})
	public String getLevel01(Role role, String arg01, String arg02) {
		return "Hello World : lv 01 -" + arg01;
	}

	@Permit(roles = {Role.ADMIN})
	public String getLevel02(Role role, String arg01, String arg02) {
		return "Hello World : lv 02 - " + arg02;
	}
}