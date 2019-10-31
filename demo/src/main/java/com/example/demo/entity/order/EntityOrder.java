package com.example.demo.entity.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="jpa_order")
public class EntityOrder {
	@Id
	//主键生成策略GenerationType包括AUTO、INDENTITY、SEQUENCE和TABLE
	//generator主键生成器名称
	@GeneratedValue(strategy=GenerationType.AUTO,generator="order_generator")
	private Long id;
	@Column
	private Date time;
	@Column
	private String orderNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
