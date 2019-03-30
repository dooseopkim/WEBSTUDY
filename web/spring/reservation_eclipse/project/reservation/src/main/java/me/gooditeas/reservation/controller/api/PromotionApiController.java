package me.gooditeas.reservation.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.gooditeas.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/api/promotions")
public class PromotionApiController {
	
	@Autowired
	private PromotionService promotionService;


	@GetMapping
	public ResponseEntity<Map<String,Object>> promotions(){
		Map<String,Object> promotionsInfo = promotionService.getPromotionsInfo();
		return new ResponseEntity<Map<String,Object>>(promotionsInfo, HttpStatus.OK);
	}

}
