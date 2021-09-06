package me.potato.annotationbasedacl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import me.potato.annotationbasedacl.enums.Role;

/**
 * @author dongju.paek
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permit {
	Role[] roles() default {Role.ADMIN};
}
