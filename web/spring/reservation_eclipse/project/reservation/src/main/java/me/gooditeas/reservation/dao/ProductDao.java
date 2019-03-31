package me.gooditeas.reservation.dao;

import static me.gooditeas.reservation.dao.sql.ProductDaoSql.COUNT_PRODUCTS;
import static me.gooditeas.reservation.dao.sql.ProductDaoSql.SELECT_PRODUCTS;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import me.gooditeas.reservation.dto.Product;
//Dao -> Service -> Controller(Chrome Restlet)

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}



	public List<Product> selectProuducts(Integer categoryId, Integer start, Integer productsPerPage) {
		Map<String,Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("start", start);
		params.put("products_per_page", productsPerPage);
		return jdbc.query(SELECT_PRODUCTS, params, rowMapper);
	}
	
	public Integer countProuducts(Integer categoryId) {
		Map<String,Integer> param = Collections.singletonMap("category_id", categoryId);
		return jdbc.queryForObject(COUNT_PRODUCTS, param, Integer.class);
	}
}
