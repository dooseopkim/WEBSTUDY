package me.gooditeas.reservation.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gooditeas.reservation.dao.CategoryDao;
import me.gooditeas.reservation.dto.Category;
import me.gooditeas.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Map<String, Object> getAllCategories() {
		List<Category> categoryList = categoryDao.selectAll();
		Map<String,Object> entityMap = new LinkedHashMap<>();
		entityMap.put("items", categoryList);
		return entityMap;
	}
	
	
	

}
