package com.nz.supplieritem.security.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="mc.security")
@Data
public class SecurityProperties {

        private BrowserProperties browser = new BrowserProperties();

        private ValidateCodeProperties code = new ValidateCodeProperties();

}
