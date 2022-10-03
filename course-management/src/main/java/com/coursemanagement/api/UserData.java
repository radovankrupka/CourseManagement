package com.coursemanagement.api;

public class UserData {
	
	public String login;
	public String name;
	public String surname;
	public String note;
	public String worktime;
	
	
	public String getLogin() {
		return login;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getNote() {
		return note;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	

}
