package com.coursemanagement.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.coursemanagement.api.Course;
import com.coursemanagement.api.UserData;
import com.coursemanagement.rowmapper.CourseRowMapper;
import com.coursemanagement.rowmapper.UserDataRowMapper;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;   // nesmie zostat null, musi dostat data source, vytvorime mu bean vnutri config file

	@Override
	public List<Course> loadCourses() {
		
		
		String sql ="SELECT * FROM courses";  //vrati všetky data v kope, rowMapper ich rozdeli do objektov (Course)
		
		List<Course> courseList = jdbcTemplate.query(sql, new CourseRowMapper() ); //tento list bude obs. data z databazy
		
		
		
		return courseList; // vraciame naplneny list do controlleru
	}

	@Override
	public void saveCourse(Course course) { // ukladanie info z DTO do DB
			
		
		Object[] sqlParam = {course.getName(), course.getDescription(), course.getRoom(), course.getTutor()};
		String sql = "insert into courses(name,description,room,tutor) values(?,?,?,?)";   //sql prikaz
		jdbcTemplate.update(sql, sqlParam);
		
		System.out.println("objekt ulozeny...");
		
		
		
	}

	@Override
	public Course getCourse(int id) {

		String sql = "SELECT * FROM COURSES WHERE ID = ?";
		Course course = jdbcTemplate.queryForObject(sql, new CourseRowMapper(), id);
		
		return course;
	}

	@Override
	public void updateCourse(Course course) {

		String sql = "UPDATE COURSES SET name = ?, description = ?, room = ?, tutor = ? WHERE id = ?";
		jdbcTemplate.update(sql, course.getName(), course.getDescription(), course.getRoom(), course.getTutor(), course.getId());
		System.out.println("Kurz uspesne upraveny");
		
		
	}

	@Override
	public void deleteCourse(int id) {
		
		String sql = "DELETE FROM courses WHERE id = ?";
		jdbcTemplate.update(sql, id);
		System.out.println("Kurz uspesne vymazany");
		
		
	}

	@Override
	public UserData getUserData(String uN) {
		
		String sql = "SELECT * FROM USERDATA WHERE LOGIN = ?";
		UserData userData = jdbcTemplate.queryForObject(sql, new UserDataRowMapper(), uN);
		
		return userData;
	}

	@Override
	public List<String> getTutorList() {
		
		String sql = "SELECT USERNAME FROM AUTHORITIES WHERE AUTHORITY = \"TUTOR\"";
		List<String> tutorList = jdbcTemplate.queryForList(sql, String.class);
		
		
		return tutorList;
	}

	
}
