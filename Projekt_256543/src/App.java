import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Students schoolDatabase = new Students();
		FileHendler file = new FileHendler();
		int action;
		boolean run = true;
		int id;
		int mark;
		int amount;
		float avgMarkTLI;
		float avgMarkCYB;
		while(run) {
			System.out.println("Choose action:");
			System.out.println("1 -- Create database");
			System.out.println("2 -- Add student");
			System.out.println("3 -- Add mark for student");
			System.out.println("4 -- Delete student");
			System.out.println("5 -- Info about student");
			System.out.println("6 -- Start students Ability");
			System.out.println("7 -- Info about all students");
			System.out.println("8 -- Sort students by surname");
			System.out.println("9 -- Info about average course mark");
			System.out.println("10 -- Amount of students in eachh course");
			System.out.println("11 -- Save student to dosument");
			System.out.println("12 -- Load student from document");
			System.out.println("13 -- End app");
			try {
				action=sc.nextInt();
				switch(action) {	
					case 1:
						schoolDatabase = new Students();
						System.out.println("Database created");
						break;
					case 2:
						schoolDatabase.setStudent();
						break;
					case 3:
						System.out.println("Students id: ");
						id = sc.nextInt();
						System.out.println("Mark: ");
						mark = sc.nextInt();
						if (mark >= 1 && mark <=5) {
							try {
								schoolDatabase.setMark(id, mark);
							}
							catch(NullPointerException e){
								System.out.println("Write correct index");
							}
						}
						else {
							System.out.println("Your mark is out of bounds");
						}
						break;
					case 4:
						System.out.println("Students id: ");
						id = sc.nextInt();
						schoolDatabase.deleteStudent(id);
						System.out.println("Deleted");
						break;
					case 5:
						System.out.println("Students id:");
						id = sc.nextInt();
						Student studentInfo = null;
						try {
							studentInfo = schoolDatabase.getStudent(id);
							System.out.println("Name: " + studentInfo.getName() + ", Surname: " + studentInfo.getSurname() + ", Birth year: " + studentInfo.getYear() + ", Mark avg.: " + studentInfo.getMarkAvg());
						}
						catch(NullPointerException e){
							System.out.println("Write correct index");
						}
						break;
					case 6:
						System.out.println("Students id:");
						try {
							id = sc.nextInt();
							studentInfo = schoolDatabase.getStudent(id);
							if (studentInfo.getCourse() == "TLI") {
								String name = StudentTLI.setNameTli(studentInfo.getName());
								String surname = StudentTLI.setSurnameTli(studentInfo.getSurname());
								studentInfo.setName(name);
								studentInfo.setSurname(surname);
								System.out.println("New name: "+name+", New surname: "+surname);
							}
							else if (studentInfo.getCourse() == "CYB") {
								String name = StudentCyb.setNameCyb(studentInfo.getName());
								String surname = StudentCyb.setSurnameCyb(studentInfo.getName());
								studentInfo.setName(name);
								studentInfo.setSurname(surname);
								System.out.println("New name: "+name+", New surname: "+surname);
							}
						}
						catch(NullPointerException e){
							System.out.println("Write correct index");
						}
						break;
					case 7:
						for(int i = 0; i < schoolDatabase.getSize(); i++) {
							studentInfo = null;
							studentInfo = schoolDatabase.getStudent(i);
							System.out.println("Name: " + studentInfo.getName() + ", Surname: " + studentInfo.getSurname() + ", Birth year: " + studentInfo.getYear() + ", Mark avg.: " + studentInfo.getMarkAvg());
						}
						break;
					case 8:
						System.out.println("TLI: ");
						for (Entry<String, Student> entry : schoolDatabase.StudentsDatabaseTLI.entrySet()) {
							studentInfo = entry.getValue();
							System.out.println("Name: " + studentInfo.getName() + ", Surname: " + studentInfo.getSurname() + ", Birth year: " + studentInfo.getYear() + ", Mark avg.: " + studentInfo.getMarkAvg());
						}
						System.out.println("CYB: ");
						for (Entry<String, Student> entry : schoolDatabase.StudentsDatabaseCYB.entrySet()) {	
							studentInfo = entry.getValue();
							System.out.println("Name: " + studentInfo.getName() + ", Surname: " + studentInfo.getSurname() + ", Birth year: " + studentInfo.getYear() + ", Mark avg.: " + studentInfo.getMarkAvg());
						}
						break;
					case 9: 
						avgMarkTLI = 0;
						for (Entry<Integer, Student> entry : schoolDatabase.StudentsDatabase.entrySet()) {
							studentInfo = entry.getValue();
							if(studentInfo.getCourse().equals("TLI")) {
								avgMarkTLI += studentInfo.getMarkAvg();
							}
						}
						avgMarkTLI = avgMarkTLI/schoolDatabase.getSizeTLI();
						System.out.println("TLI: " + avgMarkTLI);
						avgMarkCYB = 0;
						for (Entry<Integer, Student> entry : schoolDatabase.StudentsDatabase.entrySet()) {
							studentInfo = entry.getValue();
							if(studentInfo.getCourse().equals("CYB")) {
								avgMarkCYB += studentInfo.getMarkAvg();
							}
						}
						avgMarkCYB = avgMarkCYB/schoolDatabase.getSizeCYB();
						System.out.println("CYB: " + avgMarkCYB);
						break;
					case 10:
						System.out.println("TLI: "+schoolDatabase.getSizeTLI());
						System.out.println("CYB: "+schoolDatabase.getSizeCYB());
						break;
					case 11:
						System.out.println("File name: ");
						String fileName = sc.next();
						System.out.println("Student id: ");
						id = sc.nextInt();
						try {
							studentInfo = schoolDatabase.getStudent(id);
							file.createFile(fileName);
							file.writeToFile(id, studentInfo.getName() , studentInfo.getSurname(), studentInfo.getYear(), studentInfo.getCourse(), studentInfo.marks, fileName);
						}
						catch(NullPointerException e){
							System.out.println("Write correct index");
						}	
						break;
					case 12:
						System.out.println("File name: ");
						String fileName2 = sc.next();
						try {
							String[] in = file.readFromFile(fileName2).split(",", 6);
							int idR = Integer.parseInt(in[0]);
							String nameR = in[1];
							String surnameR = in[2];
							int yearR = Integer.parseInt(in[3]);
							String courseR = in[4];
							String markR = in[5];
							schoolDatabase.loadStudent(idR, nameR, surnameR, yearR, courseR);
							markR = markR.replaceAll("[\\[\\]\\s]", "");
							String[] split = markR.split(",");
							int[] marking = new int[split.length];
							for (int i = 0; i < split.length; i++) {
							    marking[i] = Integer.parseInt(split[i]);
							    schoolDatabase.setMark(idR, marking[i]);
							}
						}
						catch(NumberFormatException e) {
							System.out.println("Empty file");
						}
						break;
					case 13:
						run = false;
						break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Write a number");
				break;
				
			}
		}
	}

}
