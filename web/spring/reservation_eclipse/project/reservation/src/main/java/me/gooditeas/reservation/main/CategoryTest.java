package me.gooditeas.reservation.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.gooditeas.reservation.config.ApplicationConfig;
import me.gooditeas.reservation.dao.CategoryDao;
import me.gooditeas.reservation.dto.Category;

public class CategoryTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		CategoryDao dao = ac.getBean(CategoryDao.class);
		List<Category> categoryList = dao.selectAll();
		
		for(Category item : categoryList) {
			System.out.println(item);
		}
	}
}
