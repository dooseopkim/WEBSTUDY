package me.gooditeas.reservation.dao.sql;

public class ProductDaoSql {

	public static String SELECT_PRODUCTS = 
			"SELECT display_info_id, place_name , product_content, product_description, PDI.product_id, product_image_url\n" + 
			"FROM (SELECT DI.id AS display_info_id, DI.place_name, PD.content AS product_content, PD.description AS product_description, DI.product_id,PD.category_id\n" + 
			"		FROM display_info AS DI LEFT JOIN product AS PD \n" + 
			"			ON (PD.id = DI.product_id)) AS PDI\n" + 
			"	LEFT JOIN\n" + 
			"		(SELECT PI.product_id , FI.save_file_name AS product_image_url\n" + 
			"		FROM product_image AS PI LEFT JOIN file_info AS FI \n" + 
			"			ON (FI.id = PI.file_id)\n" + 
			"		WHERE PI.type = 'th') AS PFI\n" + 
			"	ON (PDI.product_id = PFI.product_id)\n" + 
			"WHERE CASE WHEN :category_id IS NULL THEN true ELSE category_id = category_id END\n" + 
			"LIMIT :start,:products_per_page;";
	
	public static String COUNT_PRODUCTS = "SELECT count(DI.id) AS total_count "
			+ "FROM display_info AS DI LEFT JOIN product AS PD " + "ON DI.product_id = PD.id "
			+ "WHERE CASE WHEN :category_id IS NULL THEN true ELSE PD.category_id = :category_id END";
}
