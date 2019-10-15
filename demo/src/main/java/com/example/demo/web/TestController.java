package com.example.demo.web;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.TestVO;

@RestController
public class TestController {

	@RequestMapping("/test/{p}/{v}")
	public String test(@PathVariable("p") String p,@PathVariable("v") Integer v) {
		return "aaaaaaaaaaaaaaaaaaaaaaaa"+p+v;
	}
	@RequestMapping(name="/testvo",method={RequestMethod.POST})
	public TestVO getTestVO() {
		TestVO vo = new TestVO();
		vo.setAge(13);
		vo.setName("薛邵");
		vo.setSex(true);
		vo.setDate(new Date());
		return vo;
	}
}
