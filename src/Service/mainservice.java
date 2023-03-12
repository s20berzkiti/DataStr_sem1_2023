package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import DataStr.MyArrayList;
import DataStr.SortingType;
import model.Student;
import model.Faculty;

public class mainservice {

	public static void main(String[] args) {
		MyArrayList charList = new MyArrayList();
		try {
			charList.add('a'); //a
			charList.add('f'); //a f
			charList.add('b'); // a f b
			charList.add('z', 0); //z a f b
			
			charList.print();
			System.out.println(charList.howManyElements()); //4
			charList.remove(1); //z f b
			charList.print();
			System.out.println(charList.retrieve(1)); //f
			System.out.println("Search: " + charList.search('b'));//true
			
			charList.add('d'); //z f b d
			charList.add('z'); //z f b d z
			charList.add('a'); //z f b d z a
			charList.add('z'); //z f b d z a z  increase() will be called
			System.out.println(Arrays.toString(charList.retrieveNextNeighbours('z'))); //f a
			System.out.println(charList.sort(SortingType.ASC));
			charList.print();
			charList.makeEmpty();
			//charList.print();
			charList.add('d'); //d
			charList.print();
			
			System.out.println("----------");
			MyArrayList fileList = getArrayElementsFromFile("recourses/numbers.txt");
			
			fileList.print();
			fileList.add('z');
			fileList.remove(2);
			fileList.print();
			
			MyArrayList<String> stringList = new MyArrayList<>();
			stringList.add("Karīna");
			stringList.add("Jānis");
			stringList.add("Žanis", 0);
			stringList.print();
			stringList.remove(1);
			stringList.print();
			
			MyArrayList<Student> studentList = new MyArrayList<>();
			studentList.add(new Student("Jais", "Brzins", Faculty.EPF, "123456-123456"));
			studentList.add(new Student("Laine", "Juka", Faculty.ITF, "123456-123455"));
			studentList.add(new Student("Jas", "Bns", Faculty.TSF, "654321-123456"));
			studentList.print();
			studentList.add(new Student("Gatis", "Nejaukais", Faculty.ITF, "123412-123412"));
			studentList.print();
			System.out.println(Arrays.toString(studentList.sort(SortingType.DESC)));
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static MyArrayList getArrayElementsFromFile(String path) throws FileNotFoundException{
		
		File myFile = new File(path);
		FileInputStream myInputStream = new FileInputStream(myFile);
		Scanner myScanner = new Scanner(myInputStream);
		MyArrayList listFromFile = new MyArrayList();
		
		while(myScanner.hasNextLine()) {
			String line = myScanner.nextLine();
			char element = line.charAt(0);
			listFromFile.add(element);
			
		}
		myScanner.close();
		return listFromFile;
		
		
	}
}
