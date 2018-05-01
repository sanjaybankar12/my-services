package com.myservices.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.myservices.mysql.dao")
public class MySQLConfig {

	@Bean(name="dataSource")
	@Primary
	@ConfigurationProperties(prefix="mysql.datasource")
	public DataSource mysqlDataSource(){
		
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="entityManagerFactory")
	@Primary
	@PersistenceUnit(unitName="mysql")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManager(EntityManagerFactoryBuilder builder){
		return builder.dataSource(mysqlDataSource())
				.persistenceUnit("mysql")
				.properties(jpaProperties())
				.packages("com.myservices.mysql.entity")
				.build();
	}
	
	private Map<String,String> jpaProperties(){
		
		Map<String,String> props=new HashMap<>();
		props.put("hibernate.show_sql","true");
		
		return props;
	}
}
