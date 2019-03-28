package me.gooditeas.reservation.service;


import java.util.Map;


public interface ProductService {
	public static final Integer productsPerPage = 4;
	public Map<String, Object> getProductsInfo(Integer categoryId, Integer start);
}
