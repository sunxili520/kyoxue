package com.example.demo.propertis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//定义为实例对象，方便在springboot中引用
@Component
//通过资源文件key前缀统一，后缀与属性名统一来加载资源文件配置
//注意，使用这个注解必须pom引入依赖
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-configuration-processor</artifactId>
//<optional>true</optional>
//</dependency>
@ConfigurationProperties(prefix="demo")
public class TestPropertis {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
