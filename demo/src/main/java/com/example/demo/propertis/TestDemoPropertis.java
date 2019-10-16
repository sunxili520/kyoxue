package com.example.demo.propertis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="demo")
//配置资源文件位置，这里是string数组，可以多个
//encoding必须加上，如果要读取中文，不然乱码，因为springboot源码加载properties是以ISO-8859-1读取的
@PropertySource(value={"classpath:demo.properties"},encoding="utf-8")
public class TestDemoPropertis {

	private String name;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
