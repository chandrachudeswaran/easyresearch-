package com.easyresearch.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usersdao")
public class UsersDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
	@Transactional
	public boolean createUser(Users user){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("city", user.getCity());
		params.addValue("country", user.getCountry());
		params.addValue("authority", user.getAuthority());
		
		 jdbc.update("insert into users (username,password,email,enabled,city,country) values(:username,:password,:email,:enabled,:city,:country)", params);
		
		return jdbc.update("insert into authorities (username,authority) values(:username,:authority)", params)==1;
	}

	public boolean existsUsername(String username) {
		
		return jdbc.queryForObject("select count(*) from users where username=:username", new MapSqlParameterSource("username",username),Integer.class)>0;
	}

	public boolean existsEmail(String email) {
	
		return jdbc.queryForObject("select count(*) from users where email=:email", new MapSqlParameterSource("email",email),Integer.class)>0;
	}



	
}
