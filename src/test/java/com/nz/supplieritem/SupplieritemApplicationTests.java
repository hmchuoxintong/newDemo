package com.nz.supplieritem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplieritemApplicationTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void contextLoads() {
    }
    @Test
    public void whenQuerySuccess(){
        try {
            String example= "{'userId':1, 'userName':'kqzu'}";
            String kqzhu = mvc.perform(get("/user/query")
            .param("userId","1")
            .param("userName","李雷")
            .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1)).andReturn().getResponse().getContentAsString();
            System.out.println(kqzhu);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void test1(){
        String example= "{'id':1, 'name':'kqzu'}";
        try {
            ResultActions kqzhu = mvc.perform(post("/user")  // 路径
                    .contentType(MediaType.APPLICATION_JSON)   //用contentType表示具体请求中的媒体类型信息，MediaType.APPLICATION_JSON表示互联网媒体类型的json数据格式（见备注）
                    .content(example)
                    .accept(MediaType.APPLICATION_JSON)) //accept指定客户端能够接收的内容类型
                    .andExpect(content().contentType("application/json;charset=UTF-8")) //验证响应contentType == application/json;charset=UTF-8
                    .andExpect(jsonPath("$.id").value(1)) //验证id是否为1，jsonPath的使用
                    .andExpect(jsonPath("$.name").value("kqzhu"));
            // 验证name是否等于Zhukeqian
        } catch (Exception e) {
            e.printStackTrace();
        }
        String errorExample = "{'id':1, 'name':'kqzhu'}";
        try {
            MvcResult result = mvc.perform(post("/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(errorExample)
                    .accept(MediaType.APPLICATION_JSON)) //执行请求
                    .andExpect(status().isBadRequest()) //400错误请求，  status().isOk() 正确  status().isNotFound() 验证控制器不存在
                    .andReturn();  //返回MvcResult
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void whenUploadSuccess(){
        try {
            String file = mvc.perform(fileUpload("/file")
                    .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello world upload".getBytes())
                    )
            ).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            System.out.println(file.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
