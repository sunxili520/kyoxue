package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * SpringBoot项目必须实现SpringBootServletInitializer接口，覆盖的configure()方法
 * 才能让外部容器运行Spring Boot项目，主要在不用内嵌服务器，将项目打成war包在外部服务器运行的情况
 * 这里才是入口
 * @author kyoxue
 * @date 2019年10月16日
 */
public class ServletInitializer extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(DemoApplication.class);
	}
}
