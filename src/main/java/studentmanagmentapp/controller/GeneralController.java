package studentmanagmentapp.controller;

import java.util.Scanner;

import applicationproperties.ApplicationProperties;
import studentmanagment.db.DbHelper;

public class GeneralController {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		DbHelper.getConnection();
		ApplicationProperties.printGeneralMenu();

		System.out.println("Please select module with num");
		int selectedOperation = sc.nextInt();

		switch (selectedOperation) {
		case 1:
			System.out.println("Student Module");
			StudentController.studentController();
			main(args);
			break;
		case 2:
			System.out.println("Teacher Module");
			TeacherController.teacherController();
			main(args);
			break;
		case 3:
			System.out.println("Group Module");
			GroupController.groupController();
			main(args);
			break;
		case 4:
			System.out.println("Subjects Module");
			SubjectsController.subjectsController();
			main(args);
			break;
		}
	}

}
