package studentmanagmentapp.service;

import java.util.List;
import java.util.Scanner;
import studentmanagment.model.Subjects;
import studentmanagmentapp.dao.SubjectsDAO;

public class SubjectsServiceImpl implements SubjectsService{

	private SubjectsDAO subjectsDAO;

	public SubjectsServiceImpl(SubjectsDAO subjectsDAO) {
		this.subjectsDAO = subjectsDAO;
	}

	@Override
	public boolean addSubjects() {
		boolean isAdded = false;
		Scanner sc = new Scanner(System.in);

		System.err.println("Elave edeceyiniz subjects sayini daxil edin");
		int subjectsCount = sc.nextInt();

		for (int i = 0; i < subjectsCount; i++) {
			Subjects subjects = new Subjects();
			System.out.println("Subjectsin adi");
			subjects.setName(sc.next());
			isAdded = subjectsDAO.saveSubjects(subjects);
		}
		return isAdded;
	}
	
	@Override
	public Subjects getSubjectsById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Subjectsin id-sini daxil edin");
		Subjects subjects = subjectsDAO.getSubjectsById(sc.nextLong());
		return subjects;
	}
	
	@Override
	public void printSubjects1(Subjects subjects) {
		System.out.println(subjects.getId() + " - " + subjects.getName());
		
	}

	@Override
	public void printSubjects() {
		List<Subjects> subjects1 = subjectsDAO.getSubjects();
		for (Subjects subjects : subjects1) {
			printSubjects1(subjects);
		}
		
	}

	@Override
	public void updateSubjectsById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deyishiklik etmek istediyiniz subjectsi sechin");
		Subjects subjectsFromDb = subjectsDAO.getSubjectsById(sc.nextLong());
		printSubjects1(subjectsFromDb);

		while (true) {
			System.out.println("Deyishiklik etmek istediyiniz melumati sechin");
			System.out.println("1.Subjectsin_Adi\n 0-EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {
				case 1:
					System.out.println("Yeni subjects_adini daxil edin");
					subjectsFromDb.setName(sc.next());
					break;
				}
				subjectsDAO.updateSubjectsById(subjectsFromDb);
			} else {
				
				break;
			}

		}
		
	}

	@Override
	public void hardDeleteSubjects() {
		System.out.println("Silmek istediyiniz subjectsin ID-sini daxil edin");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (subjectsDAO.hardDeleteSubjects(id)) {
				System.out.println("Subjects ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void softDeleteSubjects() {
		System.out.println("Silmek istediyiniz subjectsin ID-sini daxil edin");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (subjectsDAO.softDeleteSubjects(id)) {
				System.out.println("Subjects ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
