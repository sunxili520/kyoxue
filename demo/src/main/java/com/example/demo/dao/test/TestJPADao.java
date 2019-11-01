package com.example.demo.dao.test;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
	//findBy属性名Is
	public List<EntityTestJPA> findByTestNameIs(String testName)throws RuntimeException;
	//findBy属性名Equals
	public List<EntityTestJPA> findByTestNameEquals(String testName)throws RuntimeException;
	//findBy属性名Or属性名
	public EntityTestJPA findByTestNameOrId(String testName,Long id)throws RuntimeException;
	//findBy属性名And属性名
	public EntityTestJPA findByIdAndTestName(Long id,String testName)throws RuntimeException;
	//findBy属性名Between
	public List<EntityTestJPA> findByIdBetween(Long id,Long _id)throws RuntimeException;
	//findBy属性名LessThan <
	public List<EntityTestJPA> findByIdLessThan(Long id)throws RuntimeException;
	//findBy属性名LessThanEqual <=
	public List<EntityTestJPA> findByIdLessThanEqual(Long id)throws RuntimeException;
	//findBy属性名GreaterThan >
	public List<EntityTestJPA> findByIdGreaterThan(Long id)throws RuntimeException;
	//findBy属性名GreaterThanEqual >=
	public List<EntityTestJPA> findByIdGreaterThanEqual(Long id)throws RuntimeException;
	//findBy属性名After
	public List<EntityTestJPA> findByIdAfter(Long id)throws RuntimeException;
	//findBy属性名Before
	public List<EntityTestJPA> findByIdBefore(Long id)throws RuntimeException;
	//findBy属性名After >date
	public List<EntityTestJPA> findByTimeAfter(Date date)throws RuntimeException;
	//findBy属性名Before <date
	public List<EntityTestJPA> findByTimeBefore(Date date)throws RuntimeException;
	//findBy属性名IsNull
	public List<EntityTestJPA> findByTestNameIsNull()throws RuntimeException;
	//findBy属性名NotNull
	public List<EntityTestJPA> findByTestNameNotNull()throws RuntimeException;
	//findBy属性名IsNotNull
	public List<EntityTestJPA> findByTestNameIsNotNull()throws RuntimeException;
	//findBy属性名Like %要自己在参数拼接
	public List<EntityTestJPA> findByTestNameLike(String testName)throws RuntimeException;
	//findBy属性名NotLike %要自己在参数拼接
	public List<EntityTestJPA> findByTestNameNotLike(String testName)throws RuntimeException;
	//findBy属性名StartingWith 不用写%的模糊查询 xx%  这个会走索引
	public List<EntityTestJPA> findByTestNameStartingWith(String testName)throws RuntimeException;
	//findBy属性名EndingWith 不用写%的模糊查询 %xx
	public List<EntityTestJPA> findByTestNameEndingWith(String testName)throws RuntimeException;
	//findBy属性名Containing 不用写%的模糊查询 %xx%
	public List<EntityTestJPA> findByTestNameContaining(String testName)throws RuntimeException;
	//findBy属性名OrderBy待排序的属性名Desc/Asc
	public List<EntityTestJPA> findByTestNameOrderByIdDesc(String testName)throws RuntimeException;
	//findBy属性名Not <>
	public List<EntityTestJPA> findByIdNot(Long id)throws RuntimeException;
	//findBy属性名In 
	public List<EntityTestJPA> findByIdIn(Collection<Long> id)throws RuntimeException;
	//findBy属性名NotIn 
	public List<EntityTestJPA> findByIdNotIn(Collection<Long> id)throws RuntimeException;
	//findBy属性名True 
	public List<EntityTestJPA> findByFlagTrue()throws RuntimeException;
	//findBy属性名False
	public List<EntityTestJPA> findByFlagFalse()throws RuntimeException;
	//findBy属性名IgnoreCase 忽略大小写 如验证码
	public List<EntityTestJPA> findByTestNameIgnoreCase(String testName)throws RuntimeException;
	//countBy属性名 统计
	public long countByTime(Date date)throws RuntimeException;
	//deleteBy属性名
	public void deleteByTestName(String testName)throws RuntimeException;
	//findFirstByOrderBy属性名Desc/Asc(默认不用写)  max(id)/min(id)
	public EntityTestJPA findFirstByOrderById()throws RuntimeException;
	//findTopByOrderBy属性名Desc/Asc(默认不用写)  max(id)/min(id)
	public EntityTestJPA findTopByOrderByIdDesc()throws RuntimeException;
	//findTop数量ByOrderBy属性名Desc/asc(默认不用写)
	public Slice<EntityTestJPA> findTop20ByOrderByIdDesc(Long id,Pageable pageable)throws RuntimeException;
	//findTop数量By属性名
	public Slice<EntityTestJPA> findTop20ById(Long id,Pageable pageable)throws RuntimeException;
	//queryFirst数量By属性名
	public Page<EntityTestJPA> queryFirst10ByTestName(String testName,Pageable pageable)throws RuntimeException;
	//findFirst数量By属性名
	public List<EntityTestJPA> findFirst10ByTestName(String testName,Pageable pageable)throws RuntimeException;
	//findTop数量By属性名
	public List<EntityTestJPA> findTop10ByTestName(String testName,Pageable pageable)throws RuntimeException;
	
	@Query(value="select * from `jpa_test` where 1=1 and test_name like ?1",nativeQuery=true)
	public List<EntityTestJPA> getByTestNameLike(String likeTestName)throws RuntimeException;
	//如果存在相同类名实体，最好带包位置，不然结果集可能转不过来ClassCastException
	//EntityTestJPA为Entity注解的值
	@Query(value="select id,testName from com.example.demo.entity.test.EntityTestJPA where 1=1 and testName like ?1")
	public List<Object[]> getByTestNameLikeHQL(String likeTestName)throws RuntimeException;
	
	@Query(value="select test from com.example.demo.entity.test.EntityTestJPA test where 1=1 and test.testName like ?1")
	public List<EntityTestJPA> getByTestNameLikeHQL2(String likeTestName)throws RuntimeException;
}
