package studentmanagmentapp.dao;

import java.util.List;

import studentmanagment.model.Subjects;

public interface SubjectsDAO {

	public boolean saveSubjects(Subjects subjects);

	public List<Subjects> getSubjects();
	
	public Subjects getSubjectsById(Long id);

	public boolean updateSubjectsById(Subjects subjects);

	public boolean hardDeleteSubjects(Long id);
	
	public boolean softDeleteSubjects(Long id);

}
