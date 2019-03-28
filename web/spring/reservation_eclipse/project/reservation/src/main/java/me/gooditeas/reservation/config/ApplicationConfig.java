package me.gooditeas.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/* 
 * Component Scan
 * - Dao
 * - Service
 * 
 * Import Configuration
 * - DBConfiguration 
*/

@Configuration
@ComponentScan(basePackages= {"me.gooditeas.reservation.dao",
								"me.gooditeas.reservation.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
