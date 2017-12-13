package com.dirk.demo.datasource.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mysql数据源配置
 * @author Dirk
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="mysqlEntityManagerFactory", transactionManagerRef="mysqlTransactionManager", basePackages = {"com.dirk.demo.datasource.mysql.repository"})
public class MysqlDbConfig {
	@Bean(name="mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("mysqlDatasource")DataSource datasource) {
		return builder.dataSource(datasource).packages("com.dirk.demo.datasource.mysql.entity").persistenceUnit("mysqlUnit").build();
	}
	
	@Bean(name="mysqlDatasource")
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("mysqlEntityManagerFactory")EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}