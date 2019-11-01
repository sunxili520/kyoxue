package com.example.demo.dao.test;

import java.util.List;

import com.example.demo.entity.test.EntityTestJPA;
/**
 * 自定义类似JpaRepository内置方法
 * @author kyoxue
 * @date 2019年11月1日
 * @param <T>
 * @param <ID>
 */
public interface TestJPADiyDao{
	/**
	 * 查找比主键id大的数据集合
	 * @param id
	 * @return
	 */
	public List<EntityTestJPA> findAllGreaterThan(Long id);
}
