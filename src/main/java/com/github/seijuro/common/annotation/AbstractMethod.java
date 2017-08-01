package com.github.seijuro.common.annotation;

public @interface AbstractMethod {
    public String ClassName() default "Unknown class";
    public String MethodName() default "Unknown method";
    public String Description() default "No description";
}
