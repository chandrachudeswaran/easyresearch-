package com.easyresearch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<Users>{

	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Address address = new Address();
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		
		Users users = new Users();
		users.setAddress(address);
		users.setEmail(rs.getString("email"));
		users.setId(rs.getInt("id"));
		users.setUsername(rs.getString("password"));
		users.setEnabled(rs.getBoolean("enabled"));
		return users;
	}

}
