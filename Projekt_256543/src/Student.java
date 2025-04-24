import java.util.ArrayList;

public abstract class Student {
	
	public int id;
	public String name;
	public String surname;
	public int birthYear;
	public String course;
	public ArrayList<Integer> marks = new ArrayList<Integer>();
	
	Student(int id, String name, String surname, int birthYear, String course)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthYear = birthYear;
		this.course = course;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getId() {
		return id;
	}
	
	public int getYear() {
		return birthYear;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setYear(int year) {
		birthYear = year;
	}
	
	public void addMark(int mark) {
		marks.add(mark); 
	}
	
	public float getMarkAvg() {
		float markAvg = 0;
		for (int i = 0; i < marks.size(); i++) {
			markAvg += marks.get(i);
		}
		if (marks.size() != 0) {
			markAvg = markAvg/marks.size();
		}
		else markAvg = 0;
		return markAvg;
	}
	
	public String getCourse() {
		return course;
	}
}
