package com.nz.supplieritem.util.custom_annotation;

import com.nz.supplieritem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyContraintValidator implements ConstraintValidator<MyContraint,Object> {
//这里可以注入任何容器里面的bean
//    @Autowired
//    private UserService userService;
    @Override
    public void initialize(MyContraint constraintAnnotation) {
        System.out.println("MyContraint init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println(value);
        return true;
    }
}
