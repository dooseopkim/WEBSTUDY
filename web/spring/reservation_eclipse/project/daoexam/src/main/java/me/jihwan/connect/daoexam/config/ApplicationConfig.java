package me.jihwan.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@ComponentScan(basePackages = { "me.jihwan.connect.daoexam.dao.*" })
@Configuration
@Import({DBConfig.class})
public class ApplicationConfig {

}
