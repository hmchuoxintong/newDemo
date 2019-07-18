package com.nz.supplieritem.security.properties;

import lombok.Data;

@Data
public class BrowserProperties {

    private String loginPage = "/signIn";

    private int rememberMeSeconds = 3600*24*7;
}
