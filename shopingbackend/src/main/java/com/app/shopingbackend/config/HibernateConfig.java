package com.app.shopingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.app.shopingbackend.config"})
public class HibernateConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean(){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource());
		sessionFactoryBean.setPackagesToScan(new String[]{"com.app.shopingbackend.dto"});
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		
		return sessionFactoryBean;
	}
	
	@Bean
	public DataSource datasource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/onlineshopping");
		ds.setUsername("sa");
		ds.setPassword("");
		
		return ds;
	}
	
	public Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s){
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		
		return txManager;
	}

}
