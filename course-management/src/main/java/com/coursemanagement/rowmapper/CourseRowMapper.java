package com.coursemanagement.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.coursemanagement.api.Course;

public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

		Course course = new Course();		//vlozenie udajov z DB do objektov course, 
											//objekt course vrati do CourseDAOImpl
		
		course.setId( rs.getInt("id"));
		course.setName(rs.getString("name"));
		course.setDescription(rs.getString("description"));
		course.setRoom(rs.getInt("room"));
		course.setTutor(rs.getString("tutor"));
		
		
		
		return course;
	}

	
}
