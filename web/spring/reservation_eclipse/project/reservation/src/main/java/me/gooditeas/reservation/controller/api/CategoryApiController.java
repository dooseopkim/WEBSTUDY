package me.gooditeas.reservation.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.gooditeas.reservation.service.CategoryService;

@RestController
@RequestMapping(path="/api/categories")
public class CategoryApiController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> categories(){
		Map<String,Object> categoriesInfo = categoryService.getAllCategories();
		return new ResponseEntity<Map<String,Object>>(categoriesInfo, HttpStatus.OK);
	}
}
