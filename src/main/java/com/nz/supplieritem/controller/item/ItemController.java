package com.nz.supplieritem.controller.item;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(description = "商品接口")
@RestController
@RequestMapping("/item")
public class ItemController {
    @ApiOperation(value="添加商品",notes="添加商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemName", value = "商品名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "itemType", value = "商品类别", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "itemInfo", value = "商品描述", required = true, paramType = "query", dataType = "String")
    })
    @GetMapping("/add")
    public Map<String,Object> add(String itemName, String itemType, String itemInfo){
        System.out.println("itemName = [" + itemName + "], itemType = [" + itemType + "], itemInfo = [" + itemInfo + "]");
        Map<String, Object> map = new HashMap<>();
        map.put("success",1);
        map.put("msg","添加商品成功");
        map.put("itemName",itemName);
        map.put("itemType",itemType);
        map.put("itemInfo",itemInfo);
        return map;
    }
    @ApiOperation(value = "删除商品" ,  notes="删除商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId", value = "商品标识", required = true, paramType = "query", dataType = "int", example="123")
    })
    @DeleteMapping("/delete")
    public Map<String,String> delete(Integer itemId){
        System.out.println("itemId = [" + itemId + "]");
        Map<String, String> map = new HashMap<>();
        map.put("success","1");
        return map;
    }
    @ApiOperation(value = "修改商品" ,  notes="修改商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId", value = "商品标识", required = true, paramType = "query", dataType = "int" , example="123"),
            @ApiImplicitParam(name = "itemName", value = "商品名称", required = true, paramType = "query", dataType = "String", example="瓷砖"),
            @ApiImplicitParam(name = "itemInfo", value = "商品详情", required = true, paramType = "query", dataType = "String", example="json字符串")
    })
    @GetMapping("/update")
    public Map<String,String> update(Integer itemId, String itemName, String itemInfo){
        System.out.println("itemId = [" + itemId + "], itemName = [" + itemName + "], itemInfo = [" + itemInfo + "]");
        Map<String, String> map = new HashMap<>();
        map.put("success","1");
        return map;
    }
    @ApiOperation(value = "查询商品" ,  notes="查询商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId", value = "商品标识", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "itemName", value = "商品名称", required = true, paramType = "query", dataType = "String")
    })
    @GetMapping("/query")
    public Map<String,Object> query(Integer itemId,String itemName){
        System.out.println("itemId = [" + itemId + "], itemName = [" + itemName + "]");
        Map<String, Object> map = new HashMap<>();
        map.put("itemId",itemId);
        map.put("itemName",itemName);
        return map;
    }
}
