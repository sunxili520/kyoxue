package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
@EnableWebSocket
@SpringBootApplication
@ComponentScan(nameGenerator = AnnotationBeanNameGenerator.class)
//不用spring security而引入了依赖的话，暂时屏蔽掉，不用登录。
//貌似不起作用，后通过configuration解决，见DemoSecurityConfiguratoin
//@EnableAutoConfiguration(exclude = {
//		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
//})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
