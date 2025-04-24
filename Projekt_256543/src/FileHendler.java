import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHendler {
	
	public void createFile(String file) {
		try {
			File myObj = new File(file);
		    if (myObj.createNewFile()) {
		    System.out.println("File created: " + myObj.getName());
		    } 
		    else {
		    	System.out.println("File already exists.");
		    }
		} 
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public void writeToFile(int id, String name, String surname, int year, String course, ArrayList<Integer> marks, String file) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(id+","+name+","+surname+","+year+","+course+","+marks);
			writer.close();
			System.out.println("File closed");
		}
		catch (IOException e){
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		
	}
	
	public String readFromFile(String file) {
		String in = "";
		File filName = new File(file);
		Scanner reader;
		try {
			reader = new Scanner(filName);
			while (reader.hasNextLine()) {
				in = reader.nextLine();
			}
			reader.close();	
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		
		}	
		return in;
	}
	
}
