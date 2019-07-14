package com.nz.supplieritem.entity.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
    @ApiModelProperty(value = "用户标识", dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "用户姓名", dataType = "String", example = "张三")
    private String name;
    @ApiModelProperty(value = "用户密码", dataType = "String", example = "123456")
    private String password;
}
