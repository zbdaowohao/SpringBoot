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
 * 读取DataSource2数据源
 */
@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.ads.dataSource.datasource2.mapper", sqlSessionFactoryRef = "datasource2SqlSessionFactory")
public class DataSource2 {

	/**
	 * @methodDesc: 功能描述:(配置datasource2数据库)
	 */
	@Bean(name = "DataSource2")
	@ConfigurationProperties(prefix = "spring.datasource.datasource2")
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * @methodDesc: 功能描述:(datasource2 sql会话工厂)
	 * @param: @param
	 *             dataSource
	 */
	@Bean(name = "datasource2SqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("DataSource2") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// bean.setMapperLocations(
		// new
		// PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/datasource2/*.xml"));
		return bean.getObject();
	}

	/**
	 * @methodDesc: 功能描述:(datasource2 事物管理)
	 * @param: @param
	 *             dataSource
	 */
	@Bean(name = "datasource2TransactionManager")
	public DataSourceTransactionManager testTransactionManager(@Qualifier("DataSource2") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "datasource2SqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("datasource2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
