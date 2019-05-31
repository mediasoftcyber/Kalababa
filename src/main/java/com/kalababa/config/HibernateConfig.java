package com.kalababa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

//@Configuration
//@EnableTransactionManagement
/*@ComponentScan(basePackages = "com.kalababa.dao")*/
public class HibernateConfig {
	/*@Bean
	public LocalSessionFactoryBean createSessionFactory(DataSource ds) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(ds);
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.put("hibernate.hbm2ddl.auto","create");
		prop.put("hibernate.show_sql","true");
		prop.put("hibernate.format_sql","true");
		sfb.setHibernateProperties(prop);
		sfb.setAnnotatedClasses(Authorities.class, BillingAddress.class, Cart.class, CartItem.class,Customer.class,CustomerOrder.class,Product.class, Queries.class, ShippingAddress.class, User.class);
		return sfb;
	}*/
	// dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {

		HikariDataSource dataSource = new HikariDataSource();
		// Providing the database connection information
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///kalababa");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;

	}

	// sessionFactory bean will be available

	@Bean
	public SessionFactory getSessionFactory() {
		DataSource ds = getDataSource();
		System.out.println("HibernateConfig.getSessionFactory()" + ds.getClass());
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.kalababa.model");

		SessionFactory factory = builder.buildSessionFactory();
		System.out.println(factory);
		return factory;
	}

	// All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	// transactionManager bean

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
