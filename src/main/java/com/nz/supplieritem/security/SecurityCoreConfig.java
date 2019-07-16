package com.nz.supplieritem.security;

import com.nz.supplieritem.security.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)//让配置读取器生效
public class SecurityCoreConfig {

}
