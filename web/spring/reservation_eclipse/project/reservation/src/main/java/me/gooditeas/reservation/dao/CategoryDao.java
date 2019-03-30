package me.gooditeas.reservation.dao;

import static me.gooditeas.reservation.dao.sql.CategoryDaoSql.SELECT_CATEGORIES;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import me.gooditeas.reservation.dto.Category;

@Repository
public class CategoryDao {
	private JdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	
	public List<Category> selectAll(){
		List<Category> categoryList = jdbc.query(SELECT_CATEGORIES, rowMapper);
		return categoryList;
	}
}
