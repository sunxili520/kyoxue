package com.example.demo.web;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestJspController {

	@GetMapping("/")
	public String forward(Map<String,Object> model){
		//map传递参数到前端输出
		model.put("time",new Date());
		model.put("message","kyoxue");
		//直接写JSP文件的名字
		return "test";
	}
}
