package me.gooditeas.reservation.controller.api;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.gooditeas.reservation.service.ProductService;
import static me.gooditeas.reservation.controller.api.ProductApiKeys.PRODUCT_APIKEY;

@RestController
@RequestMapping(path="/api/products")
public class ProductApiController {
	
	@Autowired
	ProductService productsevice;
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> products( @RequestParam(name="categoryId", required = true) int categoryId,
										   				@RequestParam(name="start", required = false, defaultValue = "0") int start,
										   				@RequestParam(name="appkey", required = false)String appkey){
		if(appkey == null || !appkey.equals(PRODUCT_APIKEY)) {
			return new ResponseEntity<Map<String,Object>>(new HashMap<>(), HttpStatus.UNAUTHORIZED);
		}
		
		Map<String,Object> productsInfo = productsevice.getProductsInfo(categoryId, start);
		return new ResponseEntity<Map<String,Object>>(productsInfo, HttpStatus.OK);
	}

	
}
