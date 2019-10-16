package com.example.demo;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
/**
 * mvc层测试
 * @author kyoxue
 * @date 2019年10月15日
 */
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.web.TestController;
@SpringBootTest
public class ControllerTest {
	private MockMvc mockMvc;
	//@Before注解的表示在测试启动的时候优先执行，一般用作资源初始化。
	//这里初始化生成controller类单例
	@Before 
	public void setUp()throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(new TestController()).build();
	}
	@Test 
	public void controllerTest()throws Exception{
		//.accept(MediaType.APPLICATION_JSON_UTF8)
		//这句主要是设置JSON返回编码，避免出现中文乱码问题
		//print()方法，需要静态引入import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
		/***
		 * 成功打印，类似如下：
		 *  MockHttpServletRequest:
			      HTTP Method = GET
			      Request URI = /test/hhhhhhh/99
			       Parameters = {}
			          Headers = {Accept=[application/json;charset=UTF-8]}
			             Body = <no character encoding set>
			    Session Attrs = {}
			
			Handler:
			             Type = com.example.demo.web.TestController
			           Method = public java.lang.String com.example.demo.web.TestController.test(java.lang.String,java.lang.Integer)
			
			Async:
			    Async started = false
			     Async result = null
			
			Resolved Exception:
			             Type = null
			
			ModelAndView:
			        View name = null
			             View = null
			            Model = null
			
			FlashMap:
			       Attributes = null
			
			MockHttpServletResponse:
			           Status = 200
			    Error message = null
			          Headers = {Content-Type=[application/json;charset=UTF-8], Content-Length=[33]}
			     Content type = application/json;charset=UTF-8
			             Body = aaaaaaaaaaaaaaaaaaaaaaaahhhhhhh99
			    Forwarded URL = null
			   Redirected URL = null
			          Cookies = []
			          
			其中Body= aaaaaaaaaaaaaaaaaaaaaaaahhhhhhh99即我们预期打印的内容    
		 */
//		mockMvc.perform(MockMvcRequestBuilders.get("/test/hhhhhhh/99").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
		/**
		 * 通过.addExpect来判断预期内容是否符合，如果符合控制台无信息，如果不符合，junit控制台会显示具体错误信息
		 */
//		mockMvc.perform(MockMvcRequestBuilders.get("/test/hhhhhhh/99").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("hhhhhhh991")));
		
//		String returnJson = mockMvc.perform(MockMvcRequestBuilders.post("/testvo")).andReturn().getResponse().getContentAsString();
//		String returnJson = mockMvc.perform(MockMvcRequestBuilders.post("/list")).andReturn().getResponse().getContentAsString();
//		System.out.println(returnJson);
		mockMvc.perform(MockMvcRequestBuilders.post("/v")
//				.param("age", "28")
//				.param("name", "aaa")
//				.param("list", "[\"bb\",\"cc\"]")
//				.param("card", "123456789012345678")
//				.param("date", "2019-10-01 11:09:11")
//				.param("weight", "99.99")
//				.param("sex", "true")
////				.param("tmp", "")
////				.param("phone", "")
//				.param("dicimal", "18")
//				.param("email", "aaa")
		);
	}
}
