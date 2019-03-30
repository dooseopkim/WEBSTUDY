package me.gooditeas.reservation.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.gooditeas.reservation.config.ApplicationConfig;
import me.gooditeas.reservation.dao.PromotionDao;
import me.gooditeas.reservation.dto.Promotion;

public class PromotionTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PromotionDao dao = ac.getBean(PromotionDao.class);
		List<Promotion> promotionList = dao.selectAll();
		for(Promotion item : promotionList) {
			System.out.println(item);
		}
	}
}
