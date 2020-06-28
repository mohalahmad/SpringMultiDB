package com.multiDB.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multiDB.model2.testtable2;
import com.multiDB.repository2.testtable2Repository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = testtable2Repository.class, entityManagerFactoryRef = "test2DSEmFactory", transactionManagerRef = "test2DSTransactionManager")
public class testtable2config {
	
	@Bean
	@ConfigurationProperties("spring.datasource2")
	public DataSourceProperties test2DSProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource test2DS(@Qualifier("test2DSProperties") DataSourceProperties test2DSProperties) {
		return test2DSProperties.initializeDataSourceBuilder().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean test2DSEmFactory(@Qualifier("test2DS") DataSource test2DS, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(test2DS).packages(testtable2.class).build();
	}
	
	@Bean
	public PlatformTransactionManager test2DSTransactionManager(EntityManagerFactory test2DSEmFactory) {
		return new JpaTransactionManager(test2DSEmFactory);
	}

}