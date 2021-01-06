package studentmanagmentapp.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import applicationproperties.ApplicationProperties;
import exceptions.SeriaNumException;
import studentmanagment.db.DbHelper;
import studentmanagmentapp.dao.SubjectsDAO;
import studentmanagmentapp.dao.SubjectsDAOImpl;
import studentmanagmentapp.service.SubjectsService;
import studentmanagmentapp.service.SubjectsServiceImpl;


public class SubjectsController {

	public static void subjectsController() throws Exception{
		
		SubjectsDAO subjectsDAO = new SubjectsDAOImpl();
		SubjectsService subjectsService = new SubjectsServiceImpl(subjectsDAO);

		Scanner sc = new Scanner(System.in);

		DbHelper.getConnection();
		ApplicationProperties.printSubjectsMenu();

		System.out.println("Please select operation with num");
		int selectedOperation = sc.nextInt();

		try {
			switch (selectedOperation) {

			case 1:
				System.out.println("MENU -> Add Subjects Operation");
				subjectsService.addSubjects();
				subjectsController();
				break;
			
			case 2:
				System.out.println("MENU ->Get Subjects List");
				subjectsService.printSubjects();
				subjectsController();
                break;
                
			case 3:
				System.out.println("MENU ->Soft Delete Subjects By ID");
				subjectsService.printSubjects();
				subjectsService.softDeleteSubjects();
				subjectsController();
				break;
			
			case 4:
				System.out.println("MENU ->Hard Delete Subjects By ID");
				subjectsService.printSubjects();
				subjectsService.hardDeleteSubjects();
				subjectsController();
				break;
				
			case 5:
				System.out.println("MENU -> Update Subjects Data By ID");
				subjectsService.printSubjects();
			    subjectsService.updateSubjectsById();
				subjectsController();
				break;
			}
			
		} catch (SeriaNumException ex) {
			System.err.println(ex.getMessage());
			subjectsController();
		} catch (InputMismatchException ex) {
			System.err.println("Input xetasi");
			subjectsController();
		} catch (Exception ex) {
			System.out.println("Bilinmeyen xeta bas verdi");
			subjectsController();
		}

	}
}
