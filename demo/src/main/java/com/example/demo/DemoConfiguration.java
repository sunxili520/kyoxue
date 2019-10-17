package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.example.demo.filter.Test1Filter;
import com.example.demo.filter.Test2Filter;

@Configuration
public class DemoConfiguration {

	//注入一个ServerEndpointExporterBean,该 Bean 会自动注册使用@ServerEndpoint 注解申明的 websocket endpoint
	@Bean 
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}
	
	@Bean
	public FilterRegistrationBean<Test1Filter> RegistTest1(){
		//通过FilterRegistrationBean实例设置优先级可以生效
		//通过@WebFilter无效
		FilterRegistrationBean<Test1Filter> bean = new FilterRegistrationBean<Test1Filter>();
		bean.setFilter(new Test1Filter());//注册自定义过滤器
		bean.setName("flilter1");//过滤器名称
		bean.addUrlPatterns("/*");//过滤所有路径
		bean.setOrder(1);//优先级，最顶级
		return bean;
	}
	@Bean
	public FilterRegistrationBean<Test2Filter> RegistTest2(){
		//通过FilterRegistrationBean实例设置优先级可以生效
		//通过@WebFilter无效
		FilterRegistrationBean<Test2Filter> bean = new FilterRegistrationBean<Test2Filter>();
		bean.setFilter(new Test2Filter());//注册自定义过滤器
		bean.setName("flilter2");//过滤器名称
		bean.addUrlPatterns("/test/*");//过滤所有路径
		bean.setOrder(6);//优先级，越低越优先
		return bean;
	}
}
