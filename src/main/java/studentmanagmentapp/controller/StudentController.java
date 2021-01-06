package studentmanagmentapp.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import applicationproperties.ApplicationProperties;
import exceptions.SeriaNumException;
import studentmanagment.db.DbHelper;
import studentmanagmentapp.dao.StudentDAO;
import studentmanagmentapp.dao.StudentDAOImpl;
import studentmanagmentapp.service.StudentService;
import studentmanagmentapp.service.StudentServiceImpl;


public class StudentController {

	public static void studentController() throws Exception{

		StudentDAO studentDAO = new StudentDAOImpl();
		StudentService studentService = new StudentServiceImpl(studentDAO);

		Scanner sc = new Scanner(System.in);

		DbHelper.getConnection();
		ApplicationProperties.printStudentMenu();

		System.out.println("Please select operation with num");
		int selectedOperation = sc.nextInt();

		try {
			switch (selectedOperation) {

			case 1:
				System.out.println("MENU -> Add Student Operation");
				studentService.addStudents();
				studentController();
				break;
			
			case 2:
				System.out.println("MENU ->Get Student List");
				studentService.printStudents();
				studentController();
                break;
                
			case 3:
				System.out.println("MENU ->Soft Delete Student By ID");
				studentService.printStudents();
				studentService.softDeleteStudent();
				studentController();
				break;
			
			case 4:
				System.out.println("MENU ->Hard Delete Student By ID");
				studentService.printStudents();
				studentService.hardDeleteStudent();
				studentController();
				break;
				
			case 5:
				System.out.println("MENU -> Update Student Data By ID");
				studentService.printStudents();
				studentService.updateStudentById();
				studentController();
				break;
			}
			
		} catch (SeriaNumException ex) {
			System.err.println(ex.getMessage());
			studentController();
		} catch (InputMismatchException ex) {
			System.err.println("Input xetasi");
			studentController();
		} catch (Exception ex) {
			System.out.println("Bilinmeyen xeta bas verdi");
			studentController();
		}

	}
}