package studentmanagmentapp.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import applicationproperties.ApplicationProperties;
import exceptions.SeriaNumException;
import studentmanagment.db.DbHelper;
import studentmanagmentapp.dao.GroupDAO;
import studentmanagmentapp.dao.GroupDAOImpl;
import studentmanagmentapp.service.GroupService;
import studentmanagmentapp.service.GroupServiceImpl;


public class GroupController {

	public static void groupController() throws Exception{
		
		GroupDAO groupDAO = new GroupDAOImpl();
		GroupService groupService = new GroupServiceImpl(groupDAO);

		Scanner sc = new Scanner(System.in);

		DbHelper.getConnection();
		ApplicationProperties.printGroupMenu();

		System.out.println("Please select operation with num");
		int selectedOperation = sc.nextInt();

		try {
			switch (selectedOperation) {

			case 1:
				System.out.println("MENU -> Add Group Operation");
				groupService.addGroups();
				groupController();
				break;
			
			case 2:
				System.out.println("MENU ->Get Group List");
				groupService.printGroups();
				groupController();
                break;
                
			case 3:
				System.out.println("MENU ->Soft Delete Group By ID");
				groupService.printGroups();
				groupService.softDeleteGroup();
				groupController();
				break;
			
			case 4:
				System.out.println("MENU ->Hard Delete Group By ID");
				groupService.printGroups();
				groupService.hardDeleteGroup();
				groupController();
				break;
				
			case 5:
				System.out.println("MENU -> Update Group Data By ID");
				groupService.printGroups();
				groupService.updateGroupById();
				groupController();
				break;
			}
			
		} catch (SeriaNumException ex) {
			System.err.println(ex.getMessage());
			groupController();
		} catch (InputMismatchException ex) {
			System.err.println("Input xetasi");
			groupController();
		} catch (Exception ex) {
			System.out.println("Bilinmeyen xeta bas verdi");
			groupController();
		}

	}

	}
