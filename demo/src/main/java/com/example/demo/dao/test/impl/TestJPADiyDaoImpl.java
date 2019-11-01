package com.example.demo.dao.test.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.test.TestJPADiyDao;
import com.example.demo.entity.test.EntityTestJPA;
@Resource
public class  TestJPADiyDaoImpl implements TestJPADiyDao {
	/**
	 * 字段装配testDB的configuration中注册bean entityManagerTest
	 */
	@Autowired
	 private EntityManager entityManagerTest;
	@Override
	public List<EntityTestJPA> findAllGreaterThan(Long id) {
		// TODO Auto-generated method stub
		CriteriaBuilder  cb = entityManagerTest.getCriteriaBuilder();
		CriteriaQuery<EntityTestJPA> cq = cb.createQuery(EntityTestJPA.class);
		Root<EntityTestJPA> entityTestJPARoot = cq.from(EntityTestJPA.class);
		Predicate condition = cb.greaterThan(entityTestJPARoot.get("id"), id);
		cq.where(condition);
		cq.select(entityTestJPARoot);
		TypedQuery<EntityTestJPA> query = entityManagerTest.createQuery(cq);
		return query.getResultList();
	}

}
