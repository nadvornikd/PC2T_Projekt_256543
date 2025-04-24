import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Students {

	public Students()
	{
		sc=new Scanner(System.in);
		StudentsDatabase = new HashMap<>();
		StudentsDatabaseTLI = new TreeMap<>();
		StudentsDatabaseCYB = new TreeMap<>();
	}
	
	public void setStudent(){
		System.out.println("Type students course(TLI/CYB): ");
		String course = sc.next();
		System.out.println("Type students name: ");
		String name = sc.next();
		System.out.println("Type students surname: ");
		String surname = sc.next();
		System.out.println("Type students birth year: ");
		int year = sc.nextInt();
		if (course.equals("TLI")){
			String Course = "TLI";
			StudentsDatabase.put(id, new StudentTLI(id,name,surname,year,Course));
			StudentsDatabaseTLI.put(surname, new StudentTLI(id,name,surname,year,Course));
			idTLI += 1;
			id += 1;
		}
		else if (course.equals("CYB")) {
			String Course = "CYB";
			StudentsDatabase.put(id, new StudentCyb(id,name,surname,year,Course));
			StudentsDatabaseCYB.put(surname, new StudentCyb(id,name,surname,year,Course));
			idCYB += 1;
			id += 1;
		}
		else {
			System.out.println("Wrong course");
		}
		
	}
	
	public void loadStudent(int id, String name, String surname, int year, String course) {
		if (course.equals("TLI")){
			String Course = "TLI";
			StudentsDatabase.put(id, new StudentTLI(id,name,surname,year,Course));
			StudentsDatabaseTLI.put(surname, new StudentTLI(id,name,surname,year,Course));
			idTLI += 1;
			id += 1;
		}
		else if (course.equals("CYB")) {
			String Course = "CYB";
			StudentsDatabase.put(id, new StudentCyb(id,name,surname,year,Course));
			StudentsDatabaseCYB.put(surname, new StudentCyb(id,name,surname,year,Course));
			idCYB += 1;
			id += 1;
		}
		else {
			System.out.println("Wrong course");
		}
	}
	
	public void setMark(int id, int mark)
	{
		StudentsDatabase.get(id).addMark(mark);
	}
	
	public void deleteStudent(int id) {
		StudentsDatabase.remove(id);
	}
	
	public Student getStudent(int id) {
		return StudentsDatabase.get(id);
	}
	
	public int getSize() {
		return id;
	}
	
	public float getSizeTLI() {
		return idTLI;
	}
	
	public float getSizeCYB() {
		return idCYB;
	}
	
	private Scanner sc;
	public Map <Integer, Student> StudentsDatabase;
	public Map <String, Student> StudentsDatabaseTLI;
	public Map <String, Student> StudentsDatabaseCYB;
	private int id = 0;
	private float idTLI = 0;
	private float idCYB = 0;
}
