package com.example.demo;

import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.TestDao;
import com.example.demo.entity.EntityTest;
import com.example.demo.propertis.TestDemoPropertis;
import com.example.demo.propertis.TestPropertis;
import com.example.demo.service.TestService;
/**
 * 集成springboot环境测试，主要测后台服务，dao等需要@autoware注入依赖的功能
 * 这里因为项目加入了websocket例子，所以将test引入容器环境并随机开端口，
 * 否则会报javax.websocket.server.ServerContainer not available
 * 如果没有websocket，(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)可以去除
 * @author kyoxue
 * @date 2019年10月15日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class applicationTest {

	//注入的接口类
	@Autowired
	private TestService testService;
	@Autowired
	private TestDao testDao;
	@Test
	public void testJDBC()throws Exception{
		/** add */
//		EntityTest test = new EntityTest();
//		test.setCreateDatetime(new Date());
//		test.setRemark("test remark");
//		testDao.insert(test);
		
		/** find by primary key */
//		EntityTest test = testDao.select(1);
//		assertNotEquals(test, null);
//		System.out.println(test.toString());
		
		/** update */
//		test.setRemark("new remark");
//		testDao.update(test);
		
		/** find table data all */
//		List<EntityTest> tests = testDao.select();
//		assertNotEquals(tests, null);
//		for (EntityTest entityTest : tests) {
//			System.out.println(entityTest.toString());
//		}
		
		/** delete data by primary key*/
//		testDao.delete(1);
	}
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
