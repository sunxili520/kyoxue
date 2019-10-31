package com.example.demo.entity.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="jpa_test")
public class EntityTestJPA {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String testName;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buff  =new StringBuffer();
		buff.append("id=").append(id).append(" ");
		buff.append("testName=").append(testName).append(" ");
		return buff.toString();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
}
