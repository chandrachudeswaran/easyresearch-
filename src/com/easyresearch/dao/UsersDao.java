package com.easyresearch.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	
	public int getUserid(String username){
		MapSqlParameterSource params = new MapSqlParameterSource("username",username);
		return jdbc.queryForObject("select id from users where username=:username", params,Integer.class);
	}
	
	@Transactional
	public boolean createUser(Users user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		jdbc.update("insert into users (username,password,email,enabled) values(:username,:password,:email,:enabled)", params);
		int id = getUserid(user.getUsername());
		user.setId(id);
		return jdbc.update("insert into address (id,city,country) values(:id,:address.city,:address.country)", params) ==1;
	}
}
