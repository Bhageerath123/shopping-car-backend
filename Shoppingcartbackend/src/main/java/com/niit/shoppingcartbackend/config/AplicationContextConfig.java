package com.niit.shoppingcartbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.CategoryDAOimpl;
import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackend.model.Product;
import com.niit.shoppingcartbackend.model.Suppliername;
import com.niit.shoppingcartbackend.model.User;

@Configuration
@ComponentScan("com.niit.shoppingcartbackend")
@EnableTransactionManagement

public class AplicationContextConfig{
	  
   @Bean(name="dataSource")
   public DriverManagerDataSource getH2dataSource(){
	   DriverManagerDataSource dataSource=new DriverManagerDataSource();
	   dataSource.setDriverClassName("org.h2.Driver");
	   dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitdb");
	   dataSource.setUsername("sa");
	   dataSource.setPassword("sa");
	   return dataSource ;
	   
   }
		
   
	 
	
	private Properties getHibernateProperties(){
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		return properties;
		
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder =new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Suppliername.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		return sessionBuilder.buildSessionFactory();
	}
	
    @Autowired
    @Bean(name="transactionManager")
    public org.springframework.orm.hibernate5.HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
    	
    
    	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
    	return transactionManager;
    	
    }
    
   @Autowired
   @Bean(name="categoryDAO")
   public com.niit.shoppingcartbackend.dao.CategoryDAO getCategoryDAO(SessionFactory sessionFactory){
	   return new com.niit.shoppingcartbackend.dao.CategoryDAOimpl(sessionFactory) ;
   }
   @Autowired
   @Bean(name="supplierDAO")
   public com.niit.shoppingcartbackend.dao.SuppliernameDAO getSupplierDAO(SessionFactory sessionFactory){
	   return new com.niit.shoppingcartbackend.dao.SuppliernameDAOimpl(sessionFactory) ;
   }
   @Autowired
   @Bean(name="userDAO")
   public com.niit.shoppingcartbackend.dao.UserDAO getUserDAO(SessionFactory sessionFactory){
	   return new com.niit.shoppingcartbackend.dao.UserDAOimpl(sessionFactory) ;
   }
   @Autowired
   @Bean(name="productDAO")
   public com.niit.shoppingcartbackend.dao.ProductDAO getProductDAO(SessionFactory sessionFactory){
	   return new com.niit.shoppingcartbackend.dao.ProductDAOimpl(sessionFactory) ;
   }
}
