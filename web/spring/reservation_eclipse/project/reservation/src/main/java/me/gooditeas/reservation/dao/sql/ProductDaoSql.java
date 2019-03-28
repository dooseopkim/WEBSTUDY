package me.gooditeas.reservation.dao.sql;

public class ProductDaoSql {

	public static String SELECT_PRODUCTS = "SELECT \n" + "	display_info_id AS displayInfoId,\n"
			+ "    place_name AS placeName,\n" + "    content AS productContent,\n"
			+ "    description AS productDescription,\n" + "    DPI.product_id AS productId,\n"
			+ "    save_file_name AS productImageUrl\n" + "FROM\n" + "	(SELECT \n" + "		DI.id AS display_info_id,\n"
			+ "		place_name,\n" + "        PD.id AS product_id,\n" + "        content,\n" + "        description\n"
			+ "	 FROM \n" + "		display_info AS DI\n" + "	 LEFT JOIN\n" + "        product AS PD \n"
			+ "	 ON (DI.product_id = PD.id)\n" + "     WHERE category_id = :categoryId) AS DPI\n" + "LEFT JOIN\n"
			+ "	(SELECT\n" + "		product_id,\n" + "        save_file_name\n" + "	 FROM \n"
			+ "		product_image AS PI \n" + "	 LEFT JOIN \n" + "		file_info AS FI \n"
			+ "	 ON(PI.file_id = FI.id)\n" + "	 WHERE PI.type = 'th') AS PFI\n"
			+ "ON ( DPI.product_id = PFI.product_id)\n" + "LIMIT :start, :productsPerPage ";
	public static String COUNT_PRODUCTS = "SELECT count(DI.id) AS totalCount\n"
			+ "FROM display_info AS DI LEFT JOIN product AS PD\n" + "ON DI.product_id = PD.id\n"
			+ "WHERE PD.category_id = :categoryId;";
}
