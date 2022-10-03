package com.coursemanagement.api;

public class Course { 		//BO object (entity) 
							// DB to backend
	
		
		public int id;
		public String name;
		public String description;
		public Integer room;
		public String tutor;
		
		
		
		
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getDescription() {
			return description;
		}
		public Integer getRoom() {
			return room;
		}
		public String getTutor() {
			return tutor;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setRoom(Integer room) {
			this.room = room;
		}
		public void setTutor(String tutor) {
			this.tutor = tutor;
		}
		@Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", description=" + description + ", room=" + room
					+ ", tutor=" + tutor + "]";
		}

		

}
