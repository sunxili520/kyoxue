package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CommDao;
import com.example.demo.entity.EntityConfig;
@Repository("testReportDao")
public class TestReportDaoImpl implements CommDao<EntityConfig> {

	@Autowired
	private JdbcTemplate reportApi;

	@Override
	public int insert(EntityConfig t) throws RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EntityConfig t) throws RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object id) throws RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EntityConfig> select() throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityConfig select(Object id) throws RuntimeException {
		// TODO Auto-generated method stub
		String sql = "select * from t_gnzl_config where code = ?";
		return reportApi.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<EntityConfig>(EntityConfig.class));
	}
}
