package com.example.demo.dao;

import java.util.List;

public interface CommDao<T> {
	/** 新增一条数据 */
	public int insert(T t)throws RuntimeException;
	/** 修改一条数据 */
	public int update(T  t)throws RuntimeException;
	/** 根据主键删除一条数据 */
	public int delete(Object id)throws RuntimeException;
	/** 查询全部数据 */
	public List<T> select()throws RuntimeException;
	/** 根据主键查询一条数据 */
	public T select(Object id)throws RuntimeException;
}
