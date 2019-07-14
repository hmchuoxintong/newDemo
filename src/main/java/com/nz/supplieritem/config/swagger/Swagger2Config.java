package com.nz.supplieritem.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//注解开启 swagger2 功能
@EnableSwagger2
//注解标示,这是一个配置类,@Configuation注解包含了@Component注解
//可以不用在使用@Component注解标记这是个bean了
@Configuration
@EnableWebMvc
public class Swagger2Config implements WebMvcConfigurer {

    /**
     * 将Swagger2 的swagger-ui.html加入资源路径下,否则Swagger2静态页面不能访问。要想使资源能够访问
     * 继承WebMvcConfigurer接口，这里采用此方法 网上有人说使用该方法会导致date编译等问题，可能在配置文件中得到解决，
     *      本人没有碰到，不多做解释
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     * 接口文档默认访问路径http://localhost:8080/swagger-ui.html，
     *          配置文件中有配置此处为http://localhost:8080/springboot2/swagger-ui.html
     * 注解说明参考博客：https://blog.csdn.net/qq_28009065/article/details/79104103，
     */
    @Bean
    public Docket userDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户接口文档")
                .apiInfo(apiInfo("用户接口文档"))
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nz.supplieritem.controller.user"))//指向自己的controller即可
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket itemDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("商品接口文档")
                .apiInfo(apiInfo("商品接口文档"))
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nz.supplieritem.controller.item"))//指向自己的controller即可
                .paths(PathSelectors.any())
                .build();
    }

    //设置文档信息
    private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
                //页面标题
                .title(desc)
                //设置作者联系方式,可有可无
                .contact(new Contact("mc", "https://www.baidu.com", "865124492@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();

    }
}
