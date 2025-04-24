import java.util.*;

public class StudentTLI extends Student{

	private String course = "TLI";

	StudentTLI(int id, String name, String surname, int birthYear, String course) {
		super(id, name, surname, birthYear, course);
	}
	Character[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
			"-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--", "-..-", "-.--","--..","/"}; 
	public static HashMap<Character, String> translator = new HashMap<>(); {
		for(int i = 0; i < chars.length; i++) {
			translator.put(chars[i], morse[i]);
		}
	}
	public static String nameToMorse(String name) {
		
		StringBuilder morseName = new StringBuilder();
		name = name.toLowerCase();
		
		for(Character c : name.toCharArray()) {
			morseName.append(translator.get(c));
			morseName.append('/');
		}
		return morseName.toString().trim();
	}
	
	public static String surnameToMorse(String surname) {
		
		StringBuilder morseName = new StringBuilder();
		surname = surname.toLowerCase();
		
		for(Character c : surname.toCharArray()) {
			morseName.append(translator.get(c));
			morseName.append('/');
		}
		return morseName.toString().trim();
	}
	
	public static String setNameTli(String name) {
		name =  nameToMorse(name);
		return name;
	}
	
	public static String setSurnameTli(String surname) {
		surname =  surnameToMorse(surname);
		return surname;
	}
	
	public String getCourse() {
		return course;
	}
	
}

