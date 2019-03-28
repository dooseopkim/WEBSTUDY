package me.jihwan.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost:3306/todolistdb?useUnicode=true";
    private String dbUser = "root";
    private String dbPasswd = "pass";

    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(driverClassName);
    	dataSource.setUrl(dbUrl);
    	dataSource.setUsername(dbUser);
    	dataSource.setPassword(dbPasswd);
    	return dataSource;
    }
}
