package com.coursemanagement.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.coursemanagement.api.UserData;

public class UserDataRowMapper implements RowMapper<UserData>  {
	
	@Override
	public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserData userData = new UserData();		//vlozenie udajov pouz. z DB do objektu triedy UserData 
												
		
		
		userData.setLogin(rs.getString("login"));
		userData.setName(rs.getString("name"));
		userData.setSurname(rs.getString("surname"));
		userData.setNote(rs.getString("note"));
		userData.setWorktime(rs.getString("worktime"));

		return userData;
	}

}
