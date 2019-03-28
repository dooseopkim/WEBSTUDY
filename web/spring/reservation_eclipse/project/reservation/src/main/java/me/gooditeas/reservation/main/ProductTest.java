package me.gooditeas.reservation.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.gooditeas.reservation.config.ApplicationConfig;
import me.gooditeas.reservation.dao.ProductDao;
import me.gooditeas.reservation.dto.ProductDto;
import me.gooditeas.reservation.service.ProductService;

public class ProductTest {
	public static void main(String[] args) {
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ProductDao productDao = ac.getBean(ProductDao.class);
		List<ProductDto> productList = productDao.selectProuducts(1, 0, 4);

		System.out.println(productList.size());
		
		System.out.println(productDao.countProuducts(1));
		
		
		
		//ApplicationContext에 등록될 때,implement 된 상위 클래스가 등록됨.
		ProductService productService = ac.getBean(ProductService.class);

		
	}
}

