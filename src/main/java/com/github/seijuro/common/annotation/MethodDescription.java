package com.github.seijuro.common.annotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodDescription {
    String name() default "no name";
    String description() default "no description";
}
