package me.gooditeas.reservation.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import me.gooditeas.reservation.dto.Promotion;

import static me.gooditeas.reservation.dao.sql.PromotionDaoSql.SELECT_PROMOTIONS;

import java.util.List;

import javax.sql.DataSource;

@Repository
public class PromotionDao {

	private JdbcTemplate jdbc;
	RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

	public PromotionDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	
	public List<Promotion> selectAll(){
			List<Promotion> promotionList = jdbc.query(SELECT_PROMOTIONS, rowMapper);
			return promotionList;
	}

}
