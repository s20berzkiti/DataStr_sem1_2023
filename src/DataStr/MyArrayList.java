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
	
	public int howManyElements() {
		return elementCounter;
		
	}
	
	//private lai klients netiek klat
	private void increaseArray() {
		//cast uz int lai cuz . or round var izmantot
		int newArraySize = (arraySize > 100)? (int)(arraySize * 1.5) : arraySize * 2;
		
		//long version
		/*if(arraySize < 100) {
			int newArraySize = arraySize * 2;
		}
		else {
			int newArraySize = (int)(arraySize * 1.5);
		}
		*/
		//create new array
		char[] newElements = new char[newArraySize];
		
		//cpoy
		for(int i = 0; i < elementCounter; i++) {
			newElements[i] = elements[i];
		}
		//change reference
		elements = newElements;
		arraySize = newArraySize;
	}
	
	// definition of function
	public void add(char newElement) {
		//verify if the array is full
		if(isFull()) {
			//call an increasearray function
			increaseArray();
		}
		
		// add the new element in array
		// increase element counter
		
		//nosakuma pievienp elementu un tad palielina
		//[++elements] <-- palielona pirms pievieno
		elements[elementCounter++] = newElement;
		
		//elementCounter++;
	}
	
	//deff of add / tas pats nosaukums bet ir cits paramets un parametru skaits
	public void add(char newElement, int index) throws Exception
	{
		//verify the index - is it appropriate
		if(index >= 0 && index <= elementCounter) {
			//verify if the index is equal to element counter --> add()
			if(index == elementCounter) {
				add(newElement);
				
			}
			else {
				//verify isfull
				if(isFull()) {
					increaseArray();
				}
			}
			//copy from the end to the right side using the index
			//for cikls
			for(int i = elementCounter; i > index ; i--) {
				elements[i] = elements[i - 1];
			}
			//add new element in the specified index
			elements[index] = newElement;
		//increase elementCounter
			elementCounter++;
		
			}
		//izmet izņemumu
		else {
			throw (new Exception("wrong index"));
			}
		
	
	
	

		}
}
