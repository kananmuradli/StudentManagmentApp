package studentmanagmentapp.service;

import java.util.List;
import java.util.Scanner;
import studentmanagment.model.Teacher;
import studentmanagmentapp.dao.TeacherDAO;

public class TeacherServiceImpl implements TeacherService {
	
	private TeacherDAO teacherDAO;

	public TeacherServiceImpl(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public boolean addTeachers() {
		boolean isAdded = false;
		Scanner sc = new Scanner(System.in);

		System.err.println("Elave edeceyiniz muellim sayini daxil edin");
		int teacherCount = sc.nextInt();

		for (int i = 0; i < teacherCount; i++) {
			Teacher teacher = new Teacher();
			System.out.println("Muellimin adi");
			teacher.setName(sc.next());
			System.out.println("Muellimin soyadi");
			teacher.setSurname(sc.next());
			System.out.println("Muellimin yashini daxil edin");
			teacher.setAge(sc.nextInt());
			System.out.println("Muellimin seriya nomresi");
			teacher.setSeriaNum(sc.next());

			isAdded = teacherDAO.saveTeacher(teacher);
		}
		return isAdded;
	}

		@Override
		public Teacher getTeacherById() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Mellimin id-sini daxil edin");
			Teacher teacher = teacherDAO.getTeacherById(sc.nextLong());
			return teacher;
		}

		@Override
		public void printTeacher(Teacher teacher) {
			System.out.println(teacher.getId() + " - " + teacher.getName() + " " + teacher.getSurname() + " "
					+ teacher.getAge() + " " + teacher.getSeriaNum());
		}			

	@Override
	public void printTeachers() {
		List<Teacher> teachers = teacherDAO.getTeachers();
		for (Teacher teacher : teachers) {
			printTeacher(teacher);
		}

	}
	
	@Override
	public void updateTeacherById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deyishiklik etmek istediyiniz mellimi sechin");
		Teacher teacherFromDb = teacherDAO.getTeacherById(sc.nextLong());
		printTeacher(teacherFromDb);

		while (true) {
			System.out.println("Deyishiklik etmek istediyiniz melumati sechin");
			System.out.println("1.Ad\n2.Soyad\n3.Yash\n4.Seria Nomresi\n 0-EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {
				case 1:
					System.out.println("Yeni adi daxil edin");
					teacherFromDb.setName(sc.next());
					break;
				case 2:
					System.out.println("Yeni soyadi daxil edin");
					teacherFromDb.setSurname(sc.next());
					break;
				case 3:
					System.out.println("Yeni yashi daxil edin");
					teacherFromDb.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("Yeni Seria Nomresini daxil edin");
					teacherFromDb.setSeriaNum(sc.next());
					break;
				}
				teacherDAO.updateTeacherById(teacherFromDb);
			} else {
				
				break;
			}

		}
	}
	
	@Override
	public void hardDeleteTeacher() {
		System.out.println("Silmek istediyiniz muellimin ID-sini daxil edin");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (teacherDAO.hardDeleteTeacher(id)) {
				System.out.println("Mellim ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void softDeleteTeacher() {
		System.out.println("Silmek istediyiniz Muellimin ID-sini daxil edin");
		Scanner sc = new Scanner(System.in);
		try {
			Long id = sc.nextLong();
			if (teacherDAO.softDeleteTeacher(id)) {
				System.out.println("Muellim ugurla silindi");
			} else {
				System.out.println("Xeta bash verdi");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}



}
