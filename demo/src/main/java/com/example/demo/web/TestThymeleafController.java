package com.example.demo.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.TestVO;

@Controller
public class TestThymeleafController {

	@GetMapping("/forward")
	public String forward(ModelMap model){
		model.addAttribute("message", "hello");
		model.addAttribute("aaa", "aaac");
		//直接写JSP文件的名字
		return "testThymeleaf";
	}
	
	@GetMapping("/user")
	public String getUser(ModelMap model){
		List<TestVO> users = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		vo.setName("小王");
		vo.setDate(new Date());
		users.add(vo);
		model.addAttribute("users", users);
		//直接写JSP文件的名字
		return "testThymeleaf";
	}
	
	@RequestMapping("/a/{p}/{v}")
	@ResponseBody
	public String a(@PathVariable("p") String p,@PathVariable("v") Integer v) {
		return "test href:"+p+v;
	}
}
