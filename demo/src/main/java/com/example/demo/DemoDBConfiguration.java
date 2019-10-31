package com.example.demo;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * jdbc多数据集源配置
 * @author kyoxue
 * @date 2019年10月28日
 */
@Configuration
public class DemoDBConfiguration {
	/**  定义数据源  */
	//默认数据源
	@Primary
	//bean名称
	@Bean(name="orderDB")
	//为数据源取别名区分
	@Qualifier("orderDB")
	//指定配置数据源前缀
	@ConfigurationProperties("spring.datasource.order")
	public DataSource orderDB() {
		return DataSourceBuilder.create().build();
	}
	//bean名称
	@Bean(name="reportDB")
	//为数据源取别名区分
	@Qualifier("reportDB")
	//指定配置数据源前缀
	@ConfigurationProperties("spring.datasource.report")
	public DataSource reportDB() {
		return DataSourceBuilder.create().build();
	}
	//bean名称
	@Bean(name="testDB")
	//为数据源取别名区分
	@Qualifier("testDB")
	//指定配置数据源前缀
	@ConfigurationProperties("spring.datasource.test")
	public DataSource testDB() {
		return DataSourceBuilder.create().build();
	}
	/**  定义API  */
	//生成api对象 -- 订单操作
	@Bean(name = "orderApi")
	public JdbcTemplate orderApi(@Qualifier("testDB") DataSource db) {
		return new JdbcTemplate(db);
	}
	//生成api对象 -- 业务操作
	@Bean(name = "reportApi")
	public JdbcTemplate reportApi(@Qualifier("reportDB") DataSource db) {
		return new JdbcTemplate(db);
	}
	//生成api对象 -- test
	@Bean(name = "testApi")
	public JdbcTemplate testApi(@Qualifier("orderDB") DataSource db) {
		return new JdbcTemplate(db);
	}
}
