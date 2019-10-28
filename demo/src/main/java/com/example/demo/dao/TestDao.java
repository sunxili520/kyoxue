package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.EntityTest;

public interface TestDao {
	/** 新增一条数据 */
	public int insert(EntityTest test)throws RuntimeException;
	/** 修改一条数据 */
	public int update(EntityTest test)throws RuntimeException;
	/** 根据主键删除一条数据 */
	public int delete(Integer id)throws RuntimeException;
	/** 查询全部数据 */
	public List<EntityTest> select()throws RuntimeException;
	/** 根据主键查询一条数据 */
	public EntityTest select(Integer id)throws RuntimeException;
}
