package me.gooditeas.reservation.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.gooditeas.reservation.dao.ProductDao;
import me.gooditeas.reservation.dto.Product;
import me.gooditeas.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> getProductsInfo(Integer categoryId, Integer start) {
		Map<String, Object> entityMap = new LinkedHashMap<>();
		
		Integer totalCount = productDao.countProuducts(categoryId);
		List<Product> productList = null;
		if(categoryId == null) {
			start = 0;
			productList = productDao.selectProuducts(categoryId, start, totalCount);			
		}else {
			productList = productDao.selectProuducts(categoryId, start, ProductService.productsPerPage);
		}
		
		entityMap.put("totalCount", totalCount);
		entityMap.put("items", productList);
		return entityMap;
	
	// get 2개인데 굳이 ? Transaction 사용?
	}
}
