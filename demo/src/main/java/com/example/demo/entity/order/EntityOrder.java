package com.example.demo.entity.order;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
@Entity(name="jpa_order")
@Table(name="jpa_order",indexes= {
		@Index(columnList="plat,shop"),
		@Index(columnList="time")
})
public class EntityOrder {
	@Id
	//主键生成策略GenerationType包括AUTO、INDENTITY、SEQUENCE和TABLE
	//generator主键生成器名称
	@GeneratedValue(strategy=GenerationType.AUTO,generator="order_generator")
	private Long id;
	@Column(name="plat",nullable=false,length=4)
	private Integer plat;
	@Column(name="shop",nullable=false,length=4)
	private Integer shop;
	@Column(name="price",precision=15,scale=2,nullable=true)
	private BigDecimal price;
	@Column
	private Date time;
	@Column
	private String orderNo;
	public Integer getPlat() {
		return plat;
	}
	public void setPlat(Integer plat) {
		this.plat = plat;
	}
	public Integer getShop() {
		return shop;
	}
	public void setShop(Integer shop) {
		this.shop = shop;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
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
