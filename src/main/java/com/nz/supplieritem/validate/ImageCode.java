package com.nz.supplieritem.validate;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Data
public class ImageCode {
    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;//过期时间

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }
    public boolean isExpried(){
        return LocalDateTime.now().isAfter(getExpireTime());
    }
}
