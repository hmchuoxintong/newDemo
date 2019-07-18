package com.nz.supplieritem.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Api(description="用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value="添加用户",notes="添加用户")
    @GetMapping("/add")
    public Map<String,String> add(String userName, String userPassword){
        System.out.println("userName = [" + userName + "], userPassword = [" + userPassword + "]");
        Map<String, String> map = new HashMap<>();
        map.put("name",userName);
        map.put("password",userPassword);
        return map;
    }
    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "int", example="123")
    })
    @DeleteMapping("/delete")
    public Map<String,String> delete(Integer userId){
        System.out.println("userId = [" + userId + "]");
        Map<String, String> map = new HashMap<>();
        map.put("success","1");
        return map;
    }
    @ApiOperation(value = "修改用户" ,  notes="修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "int" , example="123"),
            @ApiImplicitParam(name = "userName", value = "用户姓名", required = true, paramType = "query", dataType = "String", example="李磊"),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true, paramType = "query", dataType = "String", example="12324434")
    })
    @GetMapping("/update")
    public Map<String,String> update(@Valid @NotNull(message = "用户名不能为空") Integer userId, String userName, String userPassword, BindingResult erros){
        System.out.println("userId = [" + userId + "], userName = [" + userName + "], userPassword = [" + userPassword + "]");
        if(erros.hasErrors()){
            erros.getAllErrors().stream().forEach(e->{
                System.out.println(e.getObjectName() + e.getDefaultMessage());
            });
        }
        Map<String, String> map = new HashMap<>();
        map.put("success","1");
        return map;
    }
    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "userName", value = "用户姓名", required = true, paramType = "query", dataType = "String")
    })
    @GetMapping("/query")
    public Map<String,Object> query(Integer userId,String userName){
        System.out.println("userId = [" + userId + "], userName = [" + userName + "]");
        Map<String, Object> map = new HashMap<>();
        map.put("id",userId);
        map.put("name",userName);
        return map;
    }

    /**
     * 获取当前的用户信息
     * @return
     */
    @GetMapping("/me")
    public Object getMe(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/getme")
    public Object getMe2(Authentication authentication){
        return authentication;
    }

}
