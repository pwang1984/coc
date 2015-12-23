/**
 *
 */
package com.catsvie.coc.main;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.catsvie.coc.log.NoLogging;

/**
 *
 * @author Peng Wang Peng Wang<br/>
 *         Sep 22, 2015
 * @version 1.0 <br/>
 */
@Configuration
@PropertySource({ "/database.conf" })
@NoLogging
public class AppDBConfig {
	@Value("${driver:com.sybase.jdbc2.jdbc.SybDriver}")
	private String driver;

	@Value("${user:dba}")
	private String user;

	@Value("${password:viesta98}")
	private String password;

	@Value("${url:jdbc:sybase:Tds:localhost:2804}")
	private String url;

	@Value("${minIdleNum:1}")
	private int minIdle;

	@Value("${maxIdleNum:8}")
	private int maxIdle;

	@Value("${maxActiveNum:-1}")
	private int maxActive;

	@Value("${maxWaitMillis:5000}")
	private long maxWaitMillis;

	@Value("${validationQuery:select 1}")
	private String validationQuery;

	@Value("${validationTimoutSec:5}")
	private int validationTimeOut;

	@Value("${testOnBorrow:true}")
	private boolean testOnBorrow;

	@Value("${testOnReturn:false}")
	private boolean testOnReturn;

	@Value("${removeAbandoned:false}")
	private boolean removeAbandoned;

	@Value("${removeAbandonedTimeoutSec:7200}")
	private int removeAbandonedTimeoutSec;

	@Value("${dialect:org.hibernate.dialect.SybaseAnywhereDialect}")
	private String dialect;

	@Value("${logSql:false}")
	private String logSql;

	@Value("${autoUpdate:update}")
	private String autoUpdate;

	@Bean
	@NoLogging
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.catsvie.coc");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(additionalProperties());
		return entityManagerFactory;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", logSql);
		properties.setProperty("hibernate.format_sql", logSql);
		properties.setProperty("hibernate.dialect", dialect);
		properties.setProperty("hibernate.hbm2ddl.auto", autoUpdate);
		return properties;
	}

	@Bean
	@NoLogging
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMaxOpenPreparedStatements(200);
		dataSource.setMaxActive(maxActive);
		dataSource.setDefaultAutoCommit(true);
		dataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		dataSource.setMaxWait(maxWaitMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setValidationQueryTimeout(validationTimeOut);
		dataSource.setRemoveAbandoned(removeAbandoned);
		dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeoutSec);
		return dataSource;
	}
}
