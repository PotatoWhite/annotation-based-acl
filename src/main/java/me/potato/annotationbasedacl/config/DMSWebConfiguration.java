/*
 * DMSFormatter.java 2021. 07. 02
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.annotationbasedacl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author dongju.paek
 */
@Configuration
public class DMSWebConfiguration extends WebMvcConfigurationSupport {
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addConverterFactory(new StringToEnumConverter());
	}

	@Override
	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		super.configureContentNegotiation(configurer);
		configurer.favorPathExtension(false);
	}
}