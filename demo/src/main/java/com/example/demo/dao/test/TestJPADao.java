package com.example.demo.dao.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.test.EntityTestJPA;
/**
 * 继承JpaRepository<实体名称,实体主键类型>，使用其内置大量常用API
 * @author kyoxue
 * @date 2019年10月31日
 */
@Qualifier("testJPA")
public interface TestJPADao extends JpaRepository<EntityTestJPA, Long> {
	public EntityTestJPA findByTestName(String testName)throws RuntimeException;
}
