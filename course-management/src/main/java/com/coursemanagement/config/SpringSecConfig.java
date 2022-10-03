package com.coursemanagement.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SpringSecConfig extends WebSecurityConfigurerAdapter { //zabezpecenie endpointov
		
	@Autowired
	private DataSource dataSource;			//vstup dat z DB
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { //nacitanie user info z DB podla Spring user Schema
																					// zabezpecenie BCryptPassEncoderom
																					//zjednodusene vdaka dodrzania Spring security predpisu databazy ("authorities")
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder);
			
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(final HttpSecurity http) throws Exception {
		
		
        http
        	.authorizeRequests()
        	.antMatchers("/deleteCourse").hasAuthority("MANAGER")
        	.antMatchers("/addCourse").hasAuthority("MANAGER")
        	.antMatchers("/").authenticated()
        	.and()
              .formLogin()
                .defaultSuccessUrl("/showCourses", true)
        	.and()
        		.exceptionHandling().accessDeniedPage("/accessDenied");
      
        		
        		
    }
	
	
	
}
