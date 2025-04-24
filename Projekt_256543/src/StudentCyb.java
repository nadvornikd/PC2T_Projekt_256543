import java.util.*;

public class StudentCyb extends Student{

	String course = "CYB";
	
	StudentCyb(int id, String name, String surname, int birthYear, String course) {
		super(id, name, surname, birthYear, course);
	}
	
	public static int hashName(String name) {
		return name.hashCode();
	}
	
	public static int hashSurname(String surname) {
		return surname.hashCode();
	}
	
	
	public static String setNameCyb(String name) {
		name = Integer.toString(hashName(name));
		return name;
	}
	
	
	public static String setSurnameCyb(String surname) {
		surname = Integer.toString(hashSurname(surname));
		return surname;
	}
	
	public String getCourse() {
		return course;
	}

}
