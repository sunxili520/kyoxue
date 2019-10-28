package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.TestDao;
import com.example.demo.entity.EntityTest;
@Repository("testDao")
public class TestDaoImpl implements TestDao {
	/** spring boot 自带JDBC api */
	@Autowired
	private JdbcTemplate testApi;
	@Override
	public int insert(EntityTest test) throws RuntimeException {
		// TODO Auto-generated method stub
		String sql ="insert into t_test (createDatetime,remark) values (?,?)";
		Date createDatetime = test.getCreateDatetime();
		String remark = test.getRemark();
		return testApi.update(sql, createDatetime,remark);
	}

	@Override
	public int update(EntityTest test) throws RuntimeException {
		// TODO Auto-generated method stub
		String sql ="update t_test set createDatetime = ?,remark = ? where id = ?";
		Date createDatetime = test.getCreateDatetime();
		String remark = test.getRemark();
		Integer id = test.getId();
		return testApi.update(sql, createDatetime,remark,id);
	}

	@Override
	public int delete(Integer id) throws RuntimeException {
		// TODO Auto-generated method stub
		String sql = "delete from t_test where id = ?";
		return testApi.update(sql, id);
	}

	@Override
	public List<EntityTest> select() throws RuntimeException {
		// TODO Auto-generated method stub
		String sql = "select id,createDatetime,remark from t_test order by createDatetime desc";
		//     这种方式通过自己映射的字段与数学集合来反馈
		return testApi.query(sql, new entityTestResult());
		//     这种方式通过框架自动映射来反馈
//		return testApi.query(sql, new BeanPropertyRowMapper<EntityTest>(EntityTest.class));
	}

	@Override
	public EntityTest select(Integer id) throws RuntimeException {
		// TODO Auto-generated method stub
		String sql = "select id,createDatetime,remark from t_test where id=?";
		return testApi.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<EntityTest>(EntityTest.class));
	}
	/**
	 * 字段与属性封装
	 * @author kyoxue
	 * @date 2019年10月28日
	 */
	class entityTestResult implements RowMapper<EntityTest>{

		@Override
		public EntityTest mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			EntityTest test = new EntityTest();
			test.setId(rs.getInt("id"));
			test.setCreateDatetime(rs.getDate("createDatetime"));
			test.setRemark(rs.getString("remark"));
			return test;
		}
		
	}
}
