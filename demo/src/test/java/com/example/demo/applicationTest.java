package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.propertis.TestDemoPropertis;
import com.example.demo.propertis.TestPropertis;
import com.example.demo.service.TestService;
/**
 * 集成springboot环境测试，主要测后台服务，dao等需要@autoware注入依赖的功能
 * @author kyoxue
 * @date 2019年10月15日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class applicationTest {

	//注入的接口类
	@Autowired
	private TestService testService;
	@Test
	public void contextLoads() throws Exception{
		testService.print();
	}

	@Value("${demo.title}")
	private String title;
	
	@Test
	public void testProperties()throws Exception{
		System.out.println(title);
	}
	
	@Resource
	private TestPropertis testPropertis;
	@Test
	public void testProperties2()throws Exception{
		System.out.println("TEST----------"+testPropertis.getTitle());
	}
	
	@Resource
	private TestDemoPropertis testDemoPropertis;
	@Test
	public void testProperties3()throws Exception{
		System.out.println("TEST DEMO----------"+testDemoPropertis.getName()+"-----"+testDemoPropertis.getSex());
	}
}
