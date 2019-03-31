package me.gooditeas.reservation.main;


import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.gooditeas.reservation.config.ApplicationConfig;
import me.gooditeas.reservation.service.ProductService;


public class ProductTest {
	public static void main(String[] args) {
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ProductService productService = ac.getBean(ProductService.class);
		Map<String, Object> productList = productService.getProductsInfo(1, 1);
		Set<String> keySets = productList.keySet();
		for(String key : keySets) {
			System.out.println(productList.get(key));
		}
		

		
	}
}

