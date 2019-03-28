package me.gooditeas.reservation.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.gooditeas.reservation.dao.ProductDao;
import me.gooditeas.reservation.dto.ProductDto;
import me.gooditeas.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public Map<String, Object> getProductsInfo(Integer categoryId, Integer start) {
		Map<String, Object> jsonResult = new LinkedHashMap<>();
		
		List<ProductDto> productList = productDao.selectProuducts(categoryId, start, ProductService.productsPerPage);
		Integer totalCount = productDao.countProuducts(categoryId);
		
		jsonResult.put("items", productList);
		jsonResult.put("totalCount", totalCount);
		return jsonResult;
	}
}
