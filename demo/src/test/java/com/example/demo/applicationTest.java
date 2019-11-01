package com.example.demo;

import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.CommDao;
import com.example.demo.dao.TestDao;
import com.example.demo.dao.order.OrderJPADao;
import com.example.demo.dao.report.ReportJPADao;
import com.example.demo.dao.test.TestJPADao;
import com.example.demo.entity.EntityConfig;
import com.example.demo.entity.EntityTest;
import com.example.demo.entity.order.EntityOrder;
import com.example.demo.entity.report.EntityReport;
import com.example.demo.entity.test.EntityTestJPA;
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
//相同bean名冲突解决
@ComponentScan(nameGenerator = AnnotationBeanNameGenerator.class)
public class applicationTest {
	@Resource
	private TestJPADao testJPA;
	@Resource
	private OrderJPADao orderJPA;
	@Resource
	private ReportJPADao reportJPA;
	@Test
	public void testEntityTestJPA()throws Exception{
//		EntityTestJPA vo = new EntityTestJPA();
//		vo.setTestName("ttt1");
//		testJPA.save(vo);
		//findBy字段名
//		EntityTestJPA testJpa = testJPA.findByTestName("ttt1");
		
		//findBy字段名Or字段名
//		EntityTestJPA testJpa = testJPA.findByTestNameOrId("", (long)1);
		
		//简单示例查询findOne
//		EntityTestJPA vo = new EntityTestJPA();
//		vo.setId((long)1);
//		//org.springframework.data.domain.Example
//		Example<EntityTestJPA> ex = Example.of(vo); 
//		EntityTestJPA jpa = testJPA.findOne(ex).get();
//		assertNotEquals(jpa, null);
//		System.out.println(jpa.toString());
		
		
		EntityTestJPA vo = new EntityTestJPA();
		vo.setTestName("ttt1");
		//使用适配器查询
		/**
	     * ExampleMatcher.GenericPropertyMatchers.contains()      包含字段
	     * ExampleMatcher.GenericPropertyMatchers.endsWith()      以该字段结尾
	     * ExampleMatcher.GenericPropertyMatchers.startsWith()    以该字段开始
	     * ExampleMatcher.GenericPropertyMatchers.caseSensitive() 区分大小写
	     * ExampleMatcher.GenericPropertyMatchers.exact()         精准匹配
	     * ExampleMatcher.GenericPropertyMatchers.ignoreCase()    忽略该字段
	     * ExampleMatcher.GenericPropertyMatchers.regex()         正则匹配
	     */
//		//ps:withMatcher()只能静态访问，不能用ExampleMatcher实例访问，否则导致sql无效
//		ExampleMatcher em = ExampleMatcher.matching()
//		.withIgnorePaths("id")//忽略 不加入 where查询
//		.withMatcher("testName", ExampleMatcher.GenericPropertyMatchers.startsWith());//t%
////		.withMatcher("testName", ExampleMatcher.GenericPropertyMatchers.endsWith());//%t1
////		.withMatcher("testName", ExampleMatcher.GenericPropertyMatchers.contains());//contain t1
//		Example<EntityTestJPA> ex = Example.of(vo, em);
//		List<EntityTestJPA> tests = testJPA.findAll(ex);
//		assertNotEquals(null, tests);
//		tests.forEach(each -> {
//			System.out.println(each.toString());
//		});
		//page query
//		Pageable pageable = PageRequest.of(0,2,new Sort(Sort.Direction.DESC,"id"));
//		ExampleMatcher em = ExampleMatcher.matchingAll()
//		.withMatcher("testName", ExampleMatcher.GenericPropertyMatchers.exact());//exact martch
//		Example<EntityTestJPA> ex = Example.of(vo, em);
//		Page<EntityTestJPA> tests = testJPA.findAll(ex,pageable);
//		tests.forEach(x->{
//			System.out.println(x.toString());
//		});
		//sort query
//		Sort orders = new Sort(Sort.Direction.DESC,"id");
//		ExampleMatcher em = ExampleMatcher.matchingAll()
//		.withMatcher("testName", ExampleMatcher.GenericPropertyMatchers.exact());//exact martch
//		Example<EntityTestJPA> ex = Example.of(vo, em);
//		List<EntityTestJPA> tests = testJPA.findAll(ex,orders);
//		tests.forEach(x->{
//			System.out.println(x.toString());
//		});
		//find by diy interface
//		List<EntityTestJPA> tests = testJPA.findAllGreaterThan((long)1);
//		tests.forEach(x->{
//			System.out.println(x.toString());
//		});
		//get by orginal sql
//		List<EntityTestJPA> tests = testJPA.getByTestNameLike("%t1");
//		tests.forEach(x->{
//			System.out.println(x.toString());
//		});
		//get by hql
		//hql查询返回的如果是多个字段用Object[]数组接，下标对应sql顺序字段
		//hql查询返回的如果是一个字段，用Object接
		//hql查询返回的如果是多条，在Object/Object[]外封装层List接
		//通过Object或Object数组下标获取结果再填充到Bean中
		List<Object[]> tests = testJPA.getByTestNameLikeHQL("%t1");
		tests.forEach(x->{
			EntityTestJPA y= new EntityTestJPA();
			y.setId((long)x[0]);
			y.setTestName(x[1].toString());
			System.out.println(y.toString());
		});
	}
	@Test
	public void testEntityOrderJPA()throws Exception{
		EntityOrder vo = new EntityOrder();
		vo.setOrderNo("bbb");
		vo.setTime(new Date());
		vo.setPlat(1);
		vo.setShop(1);
		vo.setPrice(new BigDecimal(100.00));
		orderJPA.save(vo);
	}
	@Test
	public void testEntityReportJPA()throws Exception{
		EntityReport vo = new EntityReport();
		vo.setReportName("tttttt");
		reportJPA.save(vo);
	}
	//注入的接口类
	@Autowired
	private TestService testService;
	@Autowired
	private TestDao testDao;
	@Autowired
	private CommDao<EntityConfig> testReportDao;
	@Test
	public void testJDBC2()throws Exception{
		EntityConfig entityConfig = testReportDao.select("QNRMD5");
		assertNotEquals(entityConfig, null);
		System.out.println(entityConfig.toString());
	}
	@Test
	public void testJDBC()throws Exception{
		/** add */
		EntityTest test = new EntityTest();
		test.setCreateDatetime(new Date());
		test.setRemark("test remark");
		testDao.insert(test);
		
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
