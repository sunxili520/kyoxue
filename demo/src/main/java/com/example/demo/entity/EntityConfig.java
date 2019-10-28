package com.example.demo.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityConfig {

	private String code;
	private String value;
	private String remark;
	private String creater;
	private String modifier;
	private Date createTime;
	private Date modifyTime;
	private String state;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("code:").append(code).append(" ");
		buffer.append("value:").append(value).append(" ");
		buffer.append("remark:").append(remark).append(" ");
		buffer.append("creater:").append(creater).append(" ");
		buffer.append("createTime:").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime)).append(" ");
		buffer.append("state:").append(state).append(" ");
		return buffer.toString();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
