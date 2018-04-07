/**
 * 
 */
package cm.tke.onlineshopbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 12Lions
 *
 */

@Configuration
@ComponentScan(basePackages={"cm.tke.onlineshopbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//Variable de configuration de la bd avec Hibernate
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshop";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	//dataSource bean
	@Bean
	public DataSource getDatasource(){
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//Fournir les informations de connection de la base de donnée
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME); 
		dataSource.setPassword(DATABASE_PASSWORD);
		
		
		return dataSource;
	}
	
	//Session factory
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("cm.tke.onlineshopbackend.dto");
		
		
		return builder.buildSessionFactory();
	}

	
	// Retourne toutes les propriétes de Hibernate
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		
		return properties;
	}
	
	
	//Hibernate Transaction Manager 
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	
	

}
