package com.easyresearch.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("usersdao")
public class UsersDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public Users getUser(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("id",id);
		
		return jdbc.queryForObject("select * from users,address where users.id=:id and users.id=address.id",params, new UserMapper());
		
	}
	
}
