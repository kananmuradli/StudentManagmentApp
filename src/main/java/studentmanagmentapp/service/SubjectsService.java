package studentmanagmentapp.service;

import studentmanagment.model.Subjects;

public interface SubjectsService {

	public boolean addSubjects();

	public void printSubjects();

	public Subjects getSubjectsById();

	public void updateSubjectsById();
	
	public void hardDeleteSubjects();

	public void softDeleteSubjects();

	public void printSubjects1(Subjects subjects);
}
