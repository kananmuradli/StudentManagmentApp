package studentmanagmentapp.service;

import studentmanagment.model.Teacher;

public interface TeacherService {
	
	public boolean addTeachers();
	
	public void printTeachers();
	
	public void softDeleteTeacher();
	
	public void hardDeleteTeacher();
	
	public Teacher getTeacherById();
	
	public void updateTeacherById();
	
	public void printTeacher(Teacher teacher);
}
