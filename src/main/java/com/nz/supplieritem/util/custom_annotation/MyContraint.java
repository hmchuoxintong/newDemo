package com.nz.supplieritem.util.custom_annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义标注
 */
@Target({ElementType.METHOD,ElementType.FIELD})//可以标注在什么地方
@Retention(RetentionPolicy.RUNTIME)//运行时
@Constraint(validatedBy = MyContraintValidator.class)
public @interface MyContraint {
    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
