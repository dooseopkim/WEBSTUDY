package me.jihwan.connect.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.jihwan.connect.daoexam.config.ApplicationConfig;
import me.jihwan.connect.daoexam.dao.RoleDao;
import me.jihwan.connect.daoexam.dto.Role;

public class SelectAllTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		RoleDao roleDao = ac.getBean(RoleDao.class);

		List<Role> list = roleDao.selectAll();

		for (Role role : list) {
			System.out.println(role);
		}
		
	}
}
