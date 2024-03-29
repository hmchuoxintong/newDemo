package com.nz.supplieritem.validate;

import com.nz.supplieritem.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ImageCode imageCode = imageCodeGenerator.createImageCode(new ServletWebRequest(req));
        sessionStrategy.setAttribute(new ServletWebRequest(req),SESSION_KEY,imageCode);

        ImageIO.write(imageCode.getImage(),"JPEG",res.getOutputStream());
    }

}
