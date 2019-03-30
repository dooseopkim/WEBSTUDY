package me.gooditeas.reservation.dao.sql;

public class PromotionDaoSql {
/*
 * /api/promotions : 프로모션 목록 구하기
 * 
 * id ,productId, productImageurl
 * **/
	public static final String SELECT_PROMOTIONS =
			"SELECT PM.id ,PM.product_id,PF.save_file_name AS product_image_url "+
			"FROM promotion AS PM "+
			"LEFT JOIN "+
			"(SELECT PDI.product_id, FI.save_file_name "+
			"FROM product_image AS PDI LEFT JOIN file_info AS FI ON (PDI.file_id =FI.id) "+
			"WHERE PDI.type = 'th') AS PF "+
			"ON (PM.product_id = PF.product_id)";
}
