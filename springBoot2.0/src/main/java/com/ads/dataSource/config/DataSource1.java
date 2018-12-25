package com.ads.dataSource.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 读取DataSource1数据源
 */
@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.ads.dataSource.datasource1.mapper", sqlSessionFactoryRef = "datasource1SqlSessionFactory")
public class DataSource1 {

	/**
	 * @methodDesc: 功能描述:(配置datasource1数据库)
	 */
	@Bean(name = "DataSource1")
	@ConfigurationProperties(prefix = "spring.datasource.datasource1")
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * @methodDesc: 功能描述:(datasource1 sql会话工厂)
	 * @param: @param
	 *             dataSource
	 */
	@Bean(name = "datasource1SqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("DataSource1") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// bean.setMapperLocations(
		// new
		// PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/datasource1/*.xml"));
		return bean.getObject();
	}

	/**
	 * @methodDesc: 功能描述:(datasource1 事物管理)
	 * @param: @param
	 *             dataSource
	 */
	@Bean(name = "datasource1TransactionManager")
	public DataSourceTransactionManager testTransactionManager(@Qualifier("DataSource1") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "datasource1SqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("datasource1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
