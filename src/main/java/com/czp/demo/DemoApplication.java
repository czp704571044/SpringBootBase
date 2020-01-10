package com.czp.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.czp.demo.Mapper")  //包扫描
@Controller
@EnableSwagger2         //接口文档
@ServletComponentScan   //启动器启动时，扫描本目录以及子目录带有的webservlet注解的
@EnableCaching  //开启缓存
public class DemoApplication extends SpringBootServletInitializer {  //继承Init并重写configure方法。  在terminal中输入 mvn clean package 进行打包操作。

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());

	}
	@RequestMapping("/")
	public String hello(){
		return "index";
	}
}
