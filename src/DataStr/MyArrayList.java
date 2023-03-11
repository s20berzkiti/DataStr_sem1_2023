package DataStr;

public class MyArrayList {
	private char[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6; //konstante
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	//bez argumentu konstruktors
	public MyArrayList() {
		elements = new char[arraySize]; //masivs ar 6 šūnām
	}
	//args constructor
	public MyArrayList(int inputArraySize) {
		if(inputArraySize > 0) {
			arraySize = inputArraySize;
		}
		
		elements = new char[arraySize];
	}
	
	//isEmpty function
	public boolean isEmpty() {
		/*long if-else
		if(elementCounter == 0) {
			return true;
		}
		else {
			return false;
		}
		*/
		//short if-else
		//kopejais (if izteiksme)       ? ko darit true gadijuma : ko darit false gadijuma;
		//return     (elementCounter == 0)? true                   : false;
		return     (elementCounter == 0);
	}
	
	//isFull function
	public boolean isFull() {
		return (elementCounter == arraySize);
			
	}

}
