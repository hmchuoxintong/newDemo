package com.nz.supplieritem.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 */
public interface ValidateCodeGenerator {

    ImageCode createImageCode(ServletWebRequest req);
}
