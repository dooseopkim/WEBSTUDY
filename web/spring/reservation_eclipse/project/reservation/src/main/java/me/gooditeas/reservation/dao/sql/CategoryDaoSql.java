package me.gooditeas.reservation.dao.sql;

public class CategoryDaoSql {

	public static String SELECT_CATEGORIES = 
			  "SELECT C.id, C.name, count(C.id) AS count "
			+ "FROM	product AS P LEFT JOIN category AS C ON (C.id = P.category_id) " 
			+ "GROUP BY P.category_id";
}
