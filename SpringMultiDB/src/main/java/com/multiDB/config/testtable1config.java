package com.multiDB.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multiDB.model.testtable;
import com.multiDB.repository.testtableRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = testtableRepository.class, entityManagerFactoryRef = "test1DSEmFactory", transactionManagerRef = "test1DSTransactionManager")
public class testtable1config {
	
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource1")
	public DataSourceProperties test1DSProperties() {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean
	public DataSource test1DS(@Qualifier("test1DSProperties") DataSourceProperties test1DSProperties) {
		return test1DSProperties.initializeDataSourceBuilder().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean test1DSEmFactory(@Qualifier("test1DS") DataSource test1DS, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(test1DS).packages(testtable.class).build();
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager test1DSTransactionManager(EntityManagerFactory test1DSEmFactory) {
		return new JpaTransactionManager(test1DSEmFactory);
	}

}