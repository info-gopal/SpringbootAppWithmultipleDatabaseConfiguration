package com.junit.practice.testing.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory", 
transactionManagerRef = "primaryTransactionManager", 
basePackages = {
		"com.junit.practice.testing.repo.bookrepository" })
public class PrimaryDataSourceConfiguaration {
	@Value("${spring.primary.datasource.url}")
	private String url;
	@Value("${spring.primary.datasource.username}")
	private String userName;
	@Value("${spring.primary.datasource.password}")
	private String password;

	@Primary
	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.primary.datasource")
	public DataSource primaryDataSource() {

		return DataSourceBuilder.create().url(url).username(userName).password(password).build();
	}

	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("primaryDataSource") DataSource primaryDataSource) {

		// HashMap<String, Object> properties = new HashMap<>();
		// properties.put("hibernate.hbm2ddl-auto", "update");

		return builder.dataSource(primaryDataSource)
				//.properties(properties)
				.packages("com.junit.practice.testing.entites.book").build();

		// .persistenceUnit("db1")
		// .properties(properties)

	}

	@Primary
	@Bean(name = "primaryTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {

		return new JpaTransactionManager(primaryEntityManagerFactory);

	}

}
