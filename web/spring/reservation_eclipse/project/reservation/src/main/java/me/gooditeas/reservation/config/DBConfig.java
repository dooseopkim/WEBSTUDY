package me.gooditeas.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

//Database Configurations

@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
	private final String DRIVER_CLASSNAME = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/reservationdb?useUnicode=true";
    private final String DB_USER = "reservation";
    private final String DB_PASSWORD = "1234";
    
    
    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(DRIVER_CLASSNAME);
    	dataSource.setUrl(DB_URL);
    	dataSource.setUsername(DB_USER);
    	dataSource.setPassword(DB_PASSWORD);
    	return dataSource;
    }
    
    /* annotationDrivenTransactionManager
     * Return the default transaction manager bean to use for annotation-driven database transaction management, i.e.
     * */
    @Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManger();
	}
    /* transactionManager
     * The TransactionManager interface defines the methods that allow an application server to manage
     *  transaction boundaries.
     * */
	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}
}
