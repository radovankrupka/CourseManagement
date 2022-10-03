package com.coursemanagement.service;
import java.util.List;

import com.coursemanagement.api.Course;
import com.coursemanagement.api.UserData;




public interface CourseService {
	
	List<Course> loadCourses();

	void saveCourse(Course course);
	
	Course getCourse(int id);

	void updateCourse(Course course);

	void deleteCourse(int id);

	UserData getUserData(String UN);

	List<String> getTutorList();



}
