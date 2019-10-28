package com.example.demo.entity;
/**
 * 测试表 实体对象
 * @author kyoxue
 * @date 2019年10月28日
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityTest {

	private Integer id;
	private Date createDatetime;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buff = new StringBuffer();
		buff.append("id:").append(this.id).append(" ");
		buff.append("createDatetime:").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreateDatetime())).append(" ");
		buff.append("remark:").append(this.remark).append(" ");
		return buff.toString();
	}
}
