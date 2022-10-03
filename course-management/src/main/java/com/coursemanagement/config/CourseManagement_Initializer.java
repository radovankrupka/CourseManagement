
package com.coursemanagement.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//DISPATCHER SERVLET
public class CourseManagement_Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class[] configFiles = {CMConfig.class};
		
		return configFiles;
	}

	@Override
	protected String[] getServletMappings() {
		
		String[] mappings = {"/" };	//handle akukolvek URL
		return mappings;
	}

}
