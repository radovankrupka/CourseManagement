package com.coursemanagement.DAO;

import java.util.List;

import com.coursemanagement.api.Course;
import com.coursemanagement.api.UserData;


public interface CourseDAO { 		//Data access layer

	
	public List<Course> loadCourses();
	
	void saveCourse(Course course);
	
	public Course getCourse(int ID);

	public void updateCourse(Course course);

	public void deleteCourse(int id);

	public UserData getUserData(String uN);

	public List<String> getTutorList();

	
		
	
	
	
}
