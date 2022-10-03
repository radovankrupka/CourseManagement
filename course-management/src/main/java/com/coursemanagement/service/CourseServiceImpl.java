package com.coursemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.DAO.CourseDAO;
import com.coursemanagement.api.Course;
import com.coursemanagement.api.UserData;




@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	
	@Override
	public List<Course> loadCourses() {
		
		List<Course> courseList = courseDAO.loadCourses();		//DAO call
		
		return courseList;
	}


	@Override
	public void saveCourse(Course course) {

		//tu je moznost napisania rozsirujuceho kodu (business logic)
		//Priklad: Pri ulozeni novehho kurzu odoslat potvrdzujuci mail
		
		courseDAO.saveCourse(course);		//DAO call
		
		
	}


	@Override
	public Course getCourse(int id) {
		
		return courseDAO.getCourse(id);
	}


	@Override
	public void updateCourse(Course course) {

		courseDAO.updateCourse(course);
		
	}


	@Override
	public void deleteCourse(int id) {
		
		courseDAO.deleteCourse(id);
		
	}


	@Override
	public UserData getUserData(String UN) {
		
		return courseDAO.getUserData(UN);
	}


	@Override
	public List<String> getTutorList() {
		List<String> tutorList = courseDAO.getTutorList();
		return tutorList;
	}


	

}
