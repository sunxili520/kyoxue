package com.example.demo;

import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 针对localhost:3306/order数据源的JPA配置
 * ps：多数据源，JPA配置类至少有一个，其下所有方法添加primary注解
 * 本示例primary写在test数据源配置中
 * @author kyoxue
 * @date 2019年10月30日
 */
//标识此为spring bean 配置类，启动时加载
@Configuration
//启用事务支持
@EnableTransactionManagement
@EnableJpaRepositories(
		//JPA数据访问环境
		entityManagerFactoryRef="localContainerEntityManagerFactoryBeanOrder",
		//JPA事务
		transactionManagerRef="transactionManagerOrder",
		//dao接口包扫描
		basePackages={"com.example.demo.dao.order"})
public class DemoJPAOrderConfiguration {
	//引入orderDB数据源，别名orderDB与DemoDBConfiguration中@Qualifier("orderDB")一致
	@Autowired
	@Qualifier("orderDB")
	private DataSource orderDB;
	@Autowired
    private JpaProperties jpaProperties;
	@Resource
	private HibernateProperties hibernateProperties;
	
    private Map<String, Object> getVendorProperties() {
    	return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }
	/**
	 * 创建JPA数据访问环境
	 * @param entityManagerFactoryBuilder
	 * @return
	 */
	@Bean(name="localContainerEntityManagerFactoryBeanOrder")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanOrder(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder entityManagerFactoryBuilderOrder) {
		return entityManagerFactoryBuilderOrder
		//数据源
		.dataSource(orderDB)
		//JPA配置信息
		.properties(getVendorProperties())
		//实体类的包路径
		.packages("com.example.demo.entity.order")
		//JPA数据环境名称定义
		.persistenceUnit("persistenceUnitOrder")
		.build();
	}
	/**
	 * 操控数据库的对应API
	 * EntityManager是JPA中⽤于增、删、改、查的接⼝
	 * ，它的作⽤相当于⼀座桥梁
	 * ，连接内存中的Java对象 和数据库的数据存储。
	 * 	  使⽤EntityManager中的相关接⼝对数据库实体进⾏操作的时候
	 * ，EntityManager会跟踪实体对象的状态
	 * ，并决定在特定时刻将对实体的操作映射到数据库操作上⾯
	 * @param entityManagerFactoryBuilderOrder
	 * @return
	 */
	@Bean(name="entityManagerOrder")
	public EntityManager entityManagerOrder(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder entityManagerFactoryBuilderOrder){
		return localContainerEntityManagerFactoryBeanOrder(entityManagerFactoryBuilderOrder).getObject().createEntityManager();
	}
	/**
	 * 给数据源添加JPA事务
	 * @param entityManagerFactoryBuilderOrder
	 * @return
	 */
	@Bean(name="transactionManagerOrder")
	PlatformTransactionManager transactionManagerOrder(EntityManagerFactoryBuilder entityManagerFactoryBuilderOrder){
		return new JpaTransactionManager(localContainerEntityManagerFactoryBeanOrder(entityManagerFactoryBuilderOrder).getObject());
	}
}
