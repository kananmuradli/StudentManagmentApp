package studentmanagmentapp.dao;

import java.util.List;
import studentmanagment.model.Student;

public interface StudentDAO {
     
	public boolean saveStudent(Student student);
	
	public List<Student> getStudents();
	
	public boolean softDeleteStudent(Long id);
	
	public boolean hardDeleteStudent(Long id);
	
	public Student getStudentById(Long id);
	
	public boolean updateStudentById(Student student);

	}
