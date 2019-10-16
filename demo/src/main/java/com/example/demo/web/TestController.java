package com.example.demo.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	@RequestMapping(value="/testvo",method={RequestMethod.POST})
	public TestVO getTestVO() {
		TestVO vo = new TestVO();
		vo.setAge(13);
		vo.setName("薛邵");
		vo.setSex(true);
		vo.setDate(new Date());
		return vo;
	}
	@RequestMapping(value="/list",method={RequestMethod.POST})
	public List<TestVO> getTestList() {
		List<TestVO> vos = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		vo.setAge(13);
		vo.setName("薛邵");
		vo.setSex(true);
		vo.setDate(new Date());
		vos.add(vo);
		TestVO vo1 = new TestVO();
		vo1.setAge(15);
		vo1.setName("xiaoming");
		vo1.setSex(false);
		vo1.setDate(new Date());
		vos.add(vo1);
		return vos;
	}
	@RequestMapping(value="/v")
	public void validateTestVO(@Valid TestVO testVO,BindingResult result) {
		if(result.hasErrors()){
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error:list){
				System.out.println(error.getCode()+"-"+error.getDefaultMessage());
			}
		}
	}
}
