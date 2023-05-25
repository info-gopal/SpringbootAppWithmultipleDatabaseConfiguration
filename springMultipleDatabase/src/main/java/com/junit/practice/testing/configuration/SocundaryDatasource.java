package com.junit.practice.testing.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(transactionManagerRef = "secondaryTransactionManager", entityManagerFactoryRef = "secondaryEntityManagerFactory", basePackages = {
		"com.junit.practice.testing.repo.libraryrepository" })
public class SocundaryDatasource {
	@Value("${spring.secondary.datasource.url}")
	private String url;
	@Value("${spring.secondary.datasource.username}")
	private String userName;
	@Value("${spring.secondary.datasource.password}")
	private String passsword;

	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix = "spring.secondary.datasource")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().url(url).username(userName).password(passsword).build();

	}

	@Bean("secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("secondaryDataSource") DataSource dataSource) {

		return builder.dataSource(dataSource).packages("com.junit.practice.testing.entites.library").build();

	}

	@Bean("secondaryTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

		return new JpaTransactionManager(entityManagerFactory);

	}

}
