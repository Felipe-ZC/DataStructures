
/*********************************************************************
Purpose/Description: This program finds the last survivor in an array.
It does this by iterating k times through the array and removing the
last element iterated through. The program runs recursively, each time
performing the same operation (iterating k times, removing last element
iterated through) with a new array. 

Author’s Panther ID: (Felipe Zuniga) 5159067
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

public class p2
{	
	public static void main(String[] args)
	{
		int[] testArray = {1,2,3,4,5,6,7};
		p2 driver = new p2(testArray);
		driver.printLastSurvivor(testArray,testArray.length,3,0);
	}

	// Holds the original array
	int[] theArray;
	// Holds length of original array
	int orgArrayLen;

	// Constructor
	public p2(int[] arr)
	{
		theArray = arr;
		orgArrayLen = theArray.length;
	}

	// Determine 
	public void printLastSurvivor(int[] arr, int n, int k, int start)
	{	
		// Base case
		if(n == 1)
		{	
			System.out.println("The last survivor is: " + arr[0]);
			if(arr[0] >= theArray[orgArrayLen/2])
			{
				System.out.println("The last survivor is in the right half of the array");
			}
			else if(arr[0] <= theArray[orgArrayLen/2])
			{
				System.out.println("The last survivor is in the left half of the array");
			}
			return;
		}
		else
		{	
			// Used to iterate through the integer array arr.
			int iterator = start;
			// Used to count number of elements iterated through
			int counter = 0;
			// Holds the current element being iterated through
			int currElement = 0;
			// Holds a resized version of the array arr
			int[] newArray;
			// While we have iterated through less than k elements...
			while(counter < k)
			{
				// Check for out of bounds
				if(iterator >= n)
				{	
					iterator = 0;
				}
				counter += 1; 
				// Get current element
				currElement = arr[iterator];
				// Increase iterator
				iterator += 1;
			}

			// Remove kth element from arr
			newArray = removeElement(currElement,arr);
			// Perform same operations on the new array
			printLastSurvivor(newArray,newArray.length,k,iterator-1);
		}
	}

	/*
	Removes element specified from the array, and
	returns a resized integer array. Does not remove
	the element if the array has a length of 1. 
	*/
	public int[] removeElement(int element, int[] array)
	{	
		// Set length for resized array 
		int newLength = array.length - 1;
		int[] resizedArray = new int[newLength];
		// Used to iterate through resizedArray
		int counter = 0;
		// Get element to remove
		int remove = element;

		// Return the same array if its length is 1
		if(array.length <= 1)
		{
			return array;
		}
		else
		{
			/* 
			*/
			for (int i = 0; i < array.length ; ++i) 
			{	
				/*
				Place all elements of array into 
				resizedArray except array[kth-1].
				*/
				if(array[i] != remove)
				{	
					resizedArray[counter] = array[i];
					// Do not increase counter past newLength
					if(counter < newLength)
					{
						counter += 1;
					}
				}
			}
		}
		return resizedArray;
	}
}
