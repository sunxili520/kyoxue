package com.example.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test/{p}/{v}")
	public String test(@PathVariable("p") String p,@PathVariable("v") Integer v) {
		return "aaaaaaaaaaaaaaaaaaaaaaaa"+p+v;
	}
}
