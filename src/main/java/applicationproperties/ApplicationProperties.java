package applicationproperties;

public class ApplicationProperties {
	private static final String STUDENT_MENU = ""
			+"**************************\n"
			+ "Menu\n"
            + "1.Add Student\n" 
			+ "2.Get Students\n"
			+ "3.Soft Delete Student\n"
			+ "4.Hard Delete Student\n"
			+ "5.Update Student By Id\n"; 
			
	private static final String TEACHER_MENU = ""	
			+"**************************\n"
			+ "Menu\n"
			+ "1.Add Teacher\n" 
			+ "2.Get Teachers\n"
			+ "3.Soft Delete Teacher\n"
			+ "4.Hard Delete Teacher\n"
			+ "5.Update Teacher By Id\n";
	
	private static final String GROUP_MENU = ""
			+"**************************\n"
			+ "Menu\n"
            + "1.Add Group\n" 
			+ "2.Get Groups\n"
			+ "3.Soft Delete Group\n"
			+ "4.Hard Delete Group\n"
			+ "5.Update Group By Id\n"; 
	
	private static final String SUBJECTS_MENU = ""
			+"**************************\n"
			+ "Menu\n"
            + "1.Add Subjects\n" 
			+ "2.Get Subjects\n"
			+ "3.Soft Delete Subjects\n"
			+ "4.Hard Delete Subjects\n"
			+ "5.Update Subjects By Id\n"; 
	
	private static final String GENERAL_MENU = ""
			+"**************************\n"
			+ "Menu\n"
            + "1.Student Operations\n" 
			+ "2.Teacher Operations\n"
			+ "3.Group Operations\n"
			+ "4.Subjects Operations\n";

	
    private static final String SERIA_NUM_EXCEPTION = "Daxil etdiyiniz melumat 7simvoldan ibaret olmalidir:";

	public static String getSeriaNumExceptionMessage() {
		return SERIA_NUM_EXCEPTION;
	}

	public static void printStudentMenu() {
		System.out.println(STUDENT_MENU);
    }
	
	public static void printTeacherMenu() {
		System.out.println(TEACHER_MENU);
    }
	
	public static void printGroupMenu() {
		System.out.println(GROUP_MENU);
	}
	
	public static void printSubjectsMenu() {
		System.out.println(SUBJECTS_MENU);
	}
	
	public static void printGeneralMenu() {
		System.out.println(GENERAL_MENU);

	}
}
