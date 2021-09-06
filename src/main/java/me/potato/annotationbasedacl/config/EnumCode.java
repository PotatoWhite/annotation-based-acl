/*
 * Constant.java 2021. 07. 02
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.annotationbasedacl.config;

import java.util.Optional;

/**
 * @author dongju.paek
 */
public interface EnumCode<T> {
	Optional<T> search(String code);
}

