package com.tattoosoft.persistence.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.xipilli.persistence.reveng.InstallRevengOutput;

@Configuration
@ComponentScan({ "com.tattoosoft.persistence" })
@EnableTransactionManagement
@PropertySources(value = {
	@PropertySource("classpath:/hibernate.properties"),
	@PropertySource("classpath:/jdbc.properties")
})
public class DataBaseConfig implements TransactionManagementConfigurer {
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.user"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
	}

	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "tattoosoft.persistence" });
        sessionFactory.setHibernateProperties(new Properties() {{
	            setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	            setProperty("hibernate.globally_quoted_identifiers", env.getRequiredProperty("hibernate.globally_quoted_identifiers"));
	            setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	            setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	            setProperty("hibernate.use_sql_comments", env.getRequiredProperty("hibernate.use_sql_comments"));
	            setProperty("hibernate.max_fetch_depth", env.getRequiredProperty("hibernate.max_fetch_depth"));
	        }
	    });
        sessionFactory.setPackagesToScan(new String[] { "com.tattoosoft.persistence.dao","com.tattoosoft.persistence.model" });
        return sessionFactory;
    }

	@Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	@Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
}
