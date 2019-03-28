package me.jihwan.connect.daoexam.dao;

import static me.jihwan.connect.daoexam.dao.RoleDaoSqls.DELETE_BY_ROLE_ID;
import static me.jihwan.connect.daoexam.dao.RoleDaoSqls.SELECT_ALL;
import static me.jihwan.connect.daoexam.dao.RoleDaoSqls.SELECT_BY_ROLE_ID;
import static me.jihwan.connect.daoexam.dao.RoleDaoSqls.UPDATE;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import me.jihwan.connect.daoexam.dto.Role;

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	public RoleDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");
	}
	
	
	public List<Role> selectAll(){
		return jdbcTemplate.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
		// binding 할 값을 전달할 목적으로 emptyMap 사용.
		// 하나의 Row에 대한 역할을 하는게 rowMapper
	}
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}

	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbcTemplate.update(UPDATE, params);
	}
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbcTemplate.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbcTemplate.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);		
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
