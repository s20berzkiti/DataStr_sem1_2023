package Service;

import java.util.Arrays;

import DataStr.MyArrayList;
import DataStr.SortingType;

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
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
				
	}
}
