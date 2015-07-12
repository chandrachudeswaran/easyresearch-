package com.easyresearch.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
		
		return jdbc.queryForObject("select * from users where users.id=:id" ,params, new UserMapper());
		
	}
	
	public int getUserid(String username){
		MapSqlParameterSource params = new MapSqlParameterSource("username",username);
		return jdbc.queryForObject("select id from users where username=:username", params,Integer.class);
	}
	
	
	public boolean createUser(Users user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		return jdbc.update("insert into users (username,password,email,enabled,city,country) values(:username,:password,:email,:enabled,:city,:country)", params)==1;
		
		
	}
}
