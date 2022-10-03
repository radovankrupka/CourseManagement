package com.coursemanagement.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.coursemanagement.api.Course;
import com.coursemanagement.api.UserData;
import com.coursemanagement.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/showCourses")
	public String showCourseList(Model model, Authentication auth) {

																		// naplnenie username a role z "users" db
		String UN = auth.getName();
		model.addAttribute("UN", UN);
		model.addAttribute("role", auth.getAuthorities());

																		// Service -->  DAO - naplnenie info o pouzivatelovi z "userdata" DB
		UserData userData = courseService.getUserData(UN);
		model.addAttribute("userdata", userData);

																		// zavolanie service metody o data kurzov z "courses" DB
		List<Course> courseList = courseService.loadCourses(); 			// Service call (Controller --> Service --> DAO )
		model.addAttribute("courses", courseList); 

		return "course-list";
	}
	
	

	@GetMapping("/addCourse") 											//=request mapping (get method)
	public String addCourse(Model model) {
		
		Course course = new Course();
		model.addAttribute("course", course);

																		// vytvorenie listu dostupnych tutorov pre form:select
		List<String> tutorList = courseService.getTutorList();
		model.addAttribute("tutorlist", tutorList);
																		/*System.out.println("moj list:"+ tutorList + "moj kurz" + course);*/

		return "add-course";
	}

	
	@PostMapping("/saveCourse") 										// musi byt post kvoli PRG
	public String saveCourse(Course course) { 							// spring nam vytvori objekt course, nastavi hodnoty parametrov z URL
																		// adresy (url binding)
		
																		/*System.out.println("moj list:"+ tutorList + "moj kurz" + course);*/

		if (course.getId() == 0) { 										// id == 0 ak doteraz kurz neexistoval
																		// Service call pre zavolanie DAO --> DAO implementacie a ulozenie udajov z DTO (udaje z
																		// formularu vlozene pouzivatelom)
			courseService.saveCourse(course); 
		}

		else {
			courseService.updateCourse(course);
		}

		return "redirect:/showCourses"; 								// post-redirect-get pattern, aby refresh znovu neukladal data
	}

	
	
	@GetMapping("/updateCourse")
	public String updateCourse(@RequestParam("courseID") int ID, Model model) { // ReqParam nam ziskava ID kurzu ktory
																				// chce user upraviù na zaklade
		Course servCourse = courseService.getCourse(ID);						// URL do ktorej ukladame toto ID
		model.addAttribute("course", servCourse);								// pomocou query v add-course.jsp
																				// formulari
																				//  a prenos info z objektu obs. info z DB do obj. ktory vstupuje do view layeru

		List<String> tutorList = courseService.getTutorList(); 			// vytvorenie listu dostupnych tutorov pre form:select
		model.addAttribute("tutorlist", tutorList);

		return "add-course";
	}
	
	
	
	@GetMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("courseID") int ID) {

		courseService.deleteCourse(ID);

		return "redirect:/showCourses";
	}

	@GetMapping("/accessDenied")
	public String denyAccess() {
		return "accessDenied";
	}
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/showCourses";
	}

}
