/*
 * CodeToEnumConverterFactory.java 2021. 07. 02
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.annotationbasedacl.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import lombok.SneakyThrows;

/**
 * @author dongju.paek
 */
public class StringToEnumConverter implements ConverterFactory<String, Enum<? extends EnumCode>> {

	@Override
	public <T extends Enum<? extends EnumCode>> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToEnumsConverter<>(targetType);
	}

	private static final class StringToEnumsConverter<T extends Enum<? extends EnumCode>> implements Converter<String, T> {

		private final Class<T> enumType;

		public StringToEnumsConverter(Class<T> enumType) {
			this.enumType = enumType;
		}

		@SneakyThrows
		@Override
		public T convert(String source) {
			if (source.isEmpty()) {
				return null;
			}

			T[] constants = enumType.getEnumConstants();
			if (constants.length > 1)
				return (T)((EnumCode)constants[0]).search(source).orElseThrow(() -> new IllegalArgumentException());

			return null;
		}
	}
}