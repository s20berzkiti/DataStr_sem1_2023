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
	
	//deffine the delete function
	public void remove(int index) throws Exception {
		//check if there is smthn to delete / is empty
		if(isEmpty()) {
			throw (new Exception("Nothing to delete"));
		}
		
		//verify the index - is it not appropriate
		if(index < 0 || index >= elementCounter) {
			throw (new Exception("Wrong index"));
			
		}
		// when deleting copy to the left side / copy from index to end
				// initialize the last element with NUL symbol (int value is 0)
			
		for(int i = index; i < elementCounter - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[elementCounter-1] = 0; //NUL symbol
		
		// decrease elementCounter
		elementCounter--;
		
		//optimized --> elements[--elementCounter] = 0;
			
		}
	
	// define function retrieve
	public char retrieve(int index) throws Exception{
		//check if there is smthn to retrieve / is empty
		if(isEmpty()) {
			throw (new Exception("Nothing to retrieve"));
			}
		//verify index
		if(index < 0 || index >= elementCounter) {
			throw (new Exception("Wrong index"));
			
		}
		//atgriež elementu pec indeksa
		return elements[index];
	}
	
	//define function search
	public boolean search(char inputElement) {
		//does element exist
		for(int i = 0; i < elementCounter; i++) {
			if(elements[i] == inputElement) { 
				return true;
			}
		}
		return false;
		
	}
	
	// retrieve next neightbour
	public char[] retrieveNextNeighbours(char inputElement) throws Exception {
		//true case
		if(search(inputElement)) {
			int howManySearchedElements = 0;
			for(int i = 0; i < elementCounter; i++) {
				if(elements[i] == inputElement) {
					howManySearchedElements++;
				}
			}
			//check in case the input element is the last in the row (doesnt have a neighbour)
			if(elements[elementCounter-1] == inputElement) {
				howManySearchedElements--;
			}
			
			char[] nextNeighbours = new char[howManySearchedElements];
			
			int indexForNeighbours = 0;
			for(int i = 0; i < elementCounter-1; i++) {
				if(elements[i] == inputElement) {
					nextNeighbours[indexForNeighbours] = elements[i + 1];
					indexForNeighbours++;
				}
			}
			return nextNeighbours;
		}
		//false case
		else {
			throw (new Exception("Input element is not found"));
		}
	}
	
	//sort / bubble sort
	public char[] sort(SortingType type) throws Exception {
		
		if(isEmpty()) {
			throw (new Exception("Nothing to delete"));
		}
		else {
			char[] sortArray = new char[elementCounter];
			
			for(int i = 0; i < elementCounter; i++) {
				sortArray[i] = elements[i];
			}
			//ascending order
			if(type == SortingType.ASC) {
				for(int i = 0; i < elementCounter; i++) {
					for(int j = 0; j < elementCounter; j++) {
						if(sortArray[i] < sortArray[j]) {
							//maina vietam ar tmp
							char temp = sortArray[i];
							sortArray[i] = sortArray[j];
							sortArray[j] = temp;
						}
					}
				}
			}
			//descending array
			else if(type == SortingType.DESC) {
				for(int i = 0; i < elementCounter; i++) {
					for(int j = 0; j < elementCounter; j++) {
						if(sortArray[i] > sortArray[j]) {
							//maina vietam ar tmp
							char temp = sortArray[i];
							sortArray[i] = sortArray[j];
							sortArray[j] = temp;
						}
					}
				}
			}
			
			else {
				throw (new Exception("Sorting type is wrong"));
			}
			
			return sortArray;
		}
			
	}
	
	//print
	public void print() throws Exception{
		if(isEmpty()) {
			throw (new Exception("Tukss"));
		}
		for(int i = 0; i < elementCounter; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	
	//make empty
	public void makeEmpty() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elementCounter = 0;
		elements = new char[arraySize];
		//run the garbage collector
		System.gc();
		
		}
		
	}
	