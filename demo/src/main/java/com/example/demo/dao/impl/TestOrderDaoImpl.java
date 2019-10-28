package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CommDao;
import com.example.demo.entity.EntityOrder;
@Repository("testOrderDao")
public class TestOrderDaoImpl implements CommDao<EntityOrder> {

	@Autowired
	private JdbcTemplate orderApi;

	@Override
	public int insert(EntityOrder t) throws RuntimeException {
		// TODO Auto-generated method stub
		String sql = "insert into t_order(createDatetime,orderNo) values(?,?)";
		return orderApi.update(sql, t.getCreateDatetime(),t.getOrderNo());
	}

	@Override
	public int update(EntityOrder t) throws RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object id) throws RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EntityOrder> select() throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityOrder select(Object id) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
