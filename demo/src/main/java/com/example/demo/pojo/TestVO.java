package com.example.demo.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TestVO {
//  判断字符串空用这个
	@NotBlank(message="姓名必须输入！")
	private String name;
	@NotBlank
	@Length(min=18,max=19,message="身份证长度必须在18-19之间")
	private String card;
	@NotNull
	@Past(message="日期必须必须是当天之前")
	//@Future
//  前台传递日期字符，自动转换成日期对象	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//  日期对象输出到前台，自动格式化展示	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date date;
//  判断基本类型空用这个	
	@NotNull(message="年龄必须输入！")
	@Max(message="最大年龄28岁！",value=28)
	@Min(message="最小年龄18岁！",value=18)
	private Integer age;
	@NotBlank
//  string，numeric大小判断	
	@Range(min=1,max=100,message="weight只能在1-100之间")
//  数组，集合大小判断	
//	@Size(max=100, min=1,message="size只能在1-100之间")
	@Digits(integer=3,fraction=2,message="weight只能为数字，整数3位以下，小数保留2位")
	private String weight;
	@NotNull
	@AssertTrue(message="性别只能填男！")
	//@AssertFalse
	private Boolean  sex;
//  判断集合空用这个	
	@NotEmpty(message="集合不能为空！")
	List<String> list;
	@Null(message="该字段不能设值！")
	//@NotNull
	private Object tmp;
	@NotBlank
	@Pattern(regexp="^[150[0-9]+]{11}",message="电话格式有问题！")
	private String phone;
	@NotBlank
	@Email(message="email格式不正确！")
	private String email;
	@DecimalMin(value="18",message="dicimal不能小于18！")
	@DecimalMax(value="20",message="dicimal不能大于20！")
	private BigDecimal dicimal;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getDicimal() {
		return dicimal;
	}
	public void setDicimal(BigDecimal dicimal) {
		this.dicimal = dicimal;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Object getTmp() {
		return tmp;
	}
	public void setTmp(Object tmp) {
		this.tmp = tmp;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
}
