package com.nz.supplieritem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = "com.nz.supplieritem.*")
public class SupplieritemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplieritemApplication.class, args);
    }

}
