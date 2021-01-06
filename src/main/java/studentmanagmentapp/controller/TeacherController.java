package studentmanagmentapp.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import applicationproperties.ApplicationProperties;
import exceptions.SeriaNumException;
import studentmanagment.db.DbHelper;
import studentmanagmentapp.dao.TeacherDAO;
import studentmanagmentapp.dao.TeacherDAOImpl;
import studentmanagmentapp.service.TeacherService;
import studentmanagmentapp.service.TeacherServiceImpl;

public class TeacherController {

	public static void teacherController() throws Exception{
		
		TeacherDAO teacherDAO = new TeacherDAOImpl();
		TeacherService teacherService = new TeacherServiceImpl(teacherDAO);

		Scanner sc = new Scanner(System.in);

		DbHelper.getConnection();
		ApplicationProperties.printTeacherMenu();

		System.out.println("Please select operation with num");
		int selectedOperation = sc.nextInt();
		
		try {
			switch (selectedOperation) {

			case 1:
				System.out.println("MENU -> Add Teacher Operation");
				teacherService.addTeachers();
				teacherController();
				break;
				
			case 2:
				System.out.println("MENU ->Get Teacher List");
				teacherService.printTeachers();
				teacherController();
                break;
                
			case 3:
				System.out.println("MENU ->Soft Delete Teacher By ID");
				teacherService.printTeachers();
				teacherService.softDeleteTeacher();
				teacherController();
				break;
				
			case 4:
				System.out.println("MENU ->Hard Delete Teacher By ID");
				teacherService.printTeachers();
				teacherService.hardDeleteTeacher();
				teacherController();
				break;
				
			case 5:
				System.out.println("MENU -> Update Teacher Data By ID");
				teacherService.printTeachers();
				teacherService.updateTeacherById();
				teacherController();
				break;
			}
			
		} catch (SeriaNumException ex) {
			System.err.println(ex.getMessage());
			teacherController();
		} catch (InputMismatchException ex) {
			System.err.println("Input xetasi");
		    teacherController();
		} catch (Exception ex) {
			System.out.println("Bilinmeyen xeta bas verdi");
			teacherController();
		}


	}

}
