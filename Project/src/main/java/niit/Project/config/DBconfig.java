package niit.Project.config;

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
@ComponentScan(basePackages="niit.Project")
public class DBconfig {
	@Bean(name="dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		return dataSource;
	}
	public Properties getHibernateProperties()
	{
		Properties hproperties=new Properties();
		hproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hproperties.setProperty("hibernate.hbm2ddl.auto","update");
		hproperties.setProperty("hibernate.show_sql","true");
		hproperties.setProperty("hconnection.pool_size","1");
		hproperties.setProperty("vache.provider_class","org.hibernate.cache.NoCacheProvider");
		hproperties.setProperty("hibernate.id.new_generator_mapping", "true");
		
		return hproperties;
	}
	@Bean(name="sessionFactory")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan("niit.Project");
		
		return sessionFactory;
	}
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager getTranactionManager(SessionFactory sessionFactory)
	{
		 HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		 transactionManager.setSessionFactory(sessionFactory);
		 return transactionManager;
	}}