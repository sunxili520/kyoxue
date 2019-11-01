package com.example.demo.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.test.EntityTestJPA;
/**
 * 继承JpaRepository<实体名称,实体主键类型>，使用其内置大量常用API
 * @author kyoxue
 * @date 2019年10月31日
 */
@Qualifier("testJPA")
public interface TestJPADao extends JpaRepository<EntityTestJPA, Long>,TestJPADiyDao {
	//findBy属性名
	public EntityTestJPA findByTestName(String testName)throws RuntimeException;
	//findBy属性名Or属性名
	public EntityTestJPA findByTestNameOrId(String testName,Long id)throws RuntimeException;
	@Query(value="select * from `jpa_test` where 1=1 and test_name like ?1",nativeQuery=true)
	public List<EntityTestJPA> getByTestNameLike(String likeTestName)throws RuntimeException;
	//如果存在相同类名实体，最好带包位置，不然结果集可能转不过来ClassCastException
	@Query(value="select id,testName from com.example.demo.entity.test.EntityTestJPA where 1=1 and testName like ?1")
	public List<Object[]> getByTestNameLikeHQL(String likeTestName)throws RuntimeException;
}
