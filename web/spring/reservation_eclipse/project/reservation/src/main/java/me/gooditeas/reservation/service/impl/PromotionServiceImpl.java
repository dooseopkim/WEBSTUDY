package me.gooditeas.reservation.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gooditeas.reservation.dao.PromotionDao;
import me.gooditeas.reservation.dto.Promotion;
import me.gooditeas.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{
	
	@Autowired
	private PromotionDao promotionDao;

	@Override
	public Map<String, Object> getPromotionsInfo() {
		Map<String,Object> entityMap = new LinkedHashMap<>();
		List<Promotion> promotionList = promotionDao.selectAll();
		entityMap.put("items", promotionList);
		return entityMap;
	}
	



}
