package me.gooditeas.reservation.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.gooditeas.reservation.config.ApplicationConfig;

public class DataSourceTest {
	public static void main(String[] args) {
		ApplicationContext apc = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = apc.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("접속 성공^^");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
