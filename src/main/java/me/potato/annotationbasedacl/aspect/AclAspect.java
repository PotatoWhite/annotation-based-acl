/*
 * AclConfiguration.java 2021. 09. 06
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver CloudPROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.annotationbasedacl.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.potato.annotationbasedacl.Permit;

/**
 * @author dongju.paek
 */
@Slf4j
@Aspect
@Component
public class AclAspect {

	@Around(value = "@annotation(me.potato.annotationbasedacl.Permit)")
	public Object handle(ProceedingJoinPoint jp) throws Throwable {
		var methodSignature = (MethodSignature)jp.getSignature();
		var custom = methodSignature.getMethod().getAnnotation(Permit.class);

		if (!Arrays.stream(custom.roles()).anyMatch(s -> s == jp.getArgs()[0]))
			throw new Exception("denied.");

		return jp.proceed();
	}
}