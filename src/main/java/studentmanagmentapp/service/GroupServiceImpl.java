package studentmanagmentapp.service;

import java.util.List;
import java.util.Scanner;
import studentmanagment.model.Group;
import studentmanagmentapp.dao.GroupDAO;

public class GroupServiceImpl implements GroupService {

	private GroupDAO groupDAO;

	public GroupServiceImpl(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	@Override
	public boolean addGroups() {
		boolean isAdded = false;
		Scanner sc = new Scanner(System.in);

		System.err.println("Elave edeceyiniz group sayini daxil edin");
		int groupCount = sc.nextInt();

		for (int i = 0; i < groupCount; i++) {
			Group group = new Group();
			System.out.println("Groupun adi");
			group.setName(sc.next());
			isAdded = groupDAO.saveGroup(group);
		}
		return isAdded;
	}

	@Override
	public Group getGroupById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Groupun id-sini daxil edin");
		Group group = groupDAO.getGroupById(sc.nextLong());
		return group;
	}

	@Override
	public void printGroup(Group group) {
		System.out.println(group.getId() + " - " + group.getName());
	}

	@Override
	public void printGroups() {
		List<Group> groups = groupDAO.getGroups();
		for (Group group : groups) {
			printGroup(group);
		}
	}

	@Override
	public void updateGroupById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deyishiklik etmek istediyiniz groupu sechin");
		Group groupFromDb = groupDAO.getGroupById(sc.nextLong());
		printGroup(groupFromDb);

		while (true) {
			System.out.println("Deyishiklik etmek istediyiniz melumati sechin");
			System.out.println("1.Groupun_Adi\n 0-EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {
				case 1:
					System.out.println("Yeni group_adini daxil edin");
					groupFromDb.setName(sc.next());
					break;
				}
				groupDAO.updateGroupById(groupFromDb);
			} else {
				
				break;
			}

		}
	}

	@Override
	public void hardDeleteGroup() {
		System.out.println("Silmek istediyiniz groupun ID-sini daxil edin");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (groupDAO.hardDeleteGroup(id)) {
				System.out.println("Group ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void softDeleteGroup() {
		System.out.println("Silmek istediyiniz groupun ID-sini daxil edin");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (groupDAO.softDeleteGroup(id)) {
				System.out.println("Group ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	}
