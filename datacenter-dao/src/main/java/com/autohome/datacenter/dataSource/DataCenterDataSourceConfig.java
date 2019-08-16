package com.autohome.datacenter.dataSource;

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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author houxuesong
 * @date 2019-05-26 17:27
 * @desc 多数据源-datacenter数据源配置
 */
@Configuration
@MapperScan(basePackages="com.autohome.datacenter.mapper.datacenter", sqlSessionTemplateRef="dataCenterSqlSessionTemplate")
public class DataCenterDataSourceConfig {
	
	@Bean(name="dataCenterDataSource")
	@ConfigurationProperties(prefix="spring.datasource.datacenter")
	@Primary
	public DataSource dataCenterDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="dataCenterSqlSessionFactory")
	@Primary
	public SqlSessionFactory dataCenterSqlSessionFactory(@Qualifier("dataCenterDataSource") DataSource datasource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
		bean.setTypeAliasesPackage("com.autohome.datacenter.bean");
		return bean.getObject();
	}
	
	@Bean(name="dataCenterTransactionManager")
	@Primary
	public DataSourceTransactionManager dataCenterTransactionManager(@Qualifier("dataCenterDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name="dataCenterSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate dataCenterSqlSessionTemplate(@Qualifier("dataCenterSqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
