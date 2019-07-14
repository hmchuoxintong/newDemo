package com.nz.supplieritem.controller.user;

import com.nz.supplieritem.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Api(description = "登陆接口")
@RestController
public class LoginController {
    @ApiOperation(value="用户登陆", notes = "用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户姓名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("/login")
    public Map<String,Object> login(@NotNull String userName,@NotNull String password){
        System.out.println("userName = [" + userName + "], password = [" + password + "]");
        User u = new User();
        u.setId(1);
        u.setName(userName);
        u.setPassword(password);
        Map<String,Object> map = new HashMap<>();
        map.put("success",1);
        map.put("msg","登陆成功");
        map.put("user",u);
        return map;
    }
    @ApiOperation(value="用户注销", notes = "用户注销")
    @PostMapping("/loginOut")
    public void logout(){
        Map<String,Object> map = new HashMap<>();
        map.put("success",1);
        map.put("msg","注销成功");

    }
}
