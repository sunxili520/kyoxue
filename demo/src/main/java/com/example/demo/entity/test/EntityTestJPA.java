package com.example.demo.entity.test;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="EntityTestJPA")
@Table(name="jpa_test")
public class EntityTestJPA {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String testName;
	@Column
	private Date time;
	@Column
	private Boolean flag;
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
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
