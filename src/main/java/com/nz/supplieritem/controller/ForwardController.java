package com.nz.supplieritem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/{path}")
    public String one(@PathVariable String path){
        return path;
    }
}
