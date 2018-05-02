package com.myservices.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.myservices.sqlserver.dao")
public class SQLServerConfig {

	@Bean(name="sqlServerDataSource")
	@ConfigurationProperties(prefix="sqlserver.datasource")
	public DataSource sqlServerDataSource(){
		
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="sqlServerEntityManagerFactory")
	@PersistenceUnit(unitName="sqlserver")
	public LocalContainerEntityManagerFactoryBean sqlServerEntityManager(EntityManagerFactoryBuilder builder){
		return builder.dataSource(sqlServerDataSource())
				.persistenceUnit("sqlserver")
				.properties(jpaProperties())
				.packages("com.myservices.sqlserver.entity")
				.build();
	}
	
	private Map<String,String> jpaProperties(){
		
		Map<String,String> props=new HashMap<>();
		props.put("hibernate.show_sql","true");
		//props.put("hibernate.hbm2ddl.auto","validate");
		//props.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		
		return props;
	}
}
