import java.util.ArrayList;
/*********************************************************************
 Purpose/Description: Uses Merge sort to sort comparable items in O(nlogn) time. 
 Author’s Panther ID: 5159067
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
public class p1
{
	public static void main(String[] args)
	{
		Comparable[] testArray = {12,234,456,567,12,8,34};
		Comparable[] sortedArray = mergeSort(testArray);
		// Print sorted array
		System.out.println("Unsorted array: " + toString(testArray) +
			"\nSorted array: " + toString(sortedArray));

	}

	public static Comparable[] mergeSort(Comparable[] arr)
	{
		/*
		Holds split arrays, that is holds all elements
		of arr in arrays of length 1. 
		*/
		ArrayList<Comparable[]> arrays = makeArrays(arr);
		// Used to iterate through arrays
		int curr = 0;
		int next = 1;
		/*
		Compare adjacent arrays and merge. Stop when there is
		only one array left in the list. 
		*/
		// While there is more than one element in the array...
		while(arrays.size() > 1)
		{	
			// Get next adjacent arrays
			Comparable[] currArr = arrays.get(curr);
			Comparable[] nextArr = arrays.get(next);
			// Merge adjacent arrays 
			Comparable[] temp = merge(currArr,nextArr);
			/*
			Remove adjacent arrays from the list of arrays.
			Because all elements of the array are shifted one
			index to the left when remove is called, we must
			use the same index to remove the next adjacent array.
			*/
			arrays.remove(curr);
			arrays.remove(curr);
			// Add new merged array to front of list
			arrays.add(curr,temp);
		}
		// Get and return sorted array 
		Comparable[] sortedArray = arrays.get(curr);
		return sortedArray;
	}

	// Converts a comparable array to a string
	public static String toString(Comparable[] a)
	{	
		// Holds array as a String
		String stringArr = "";
		stringArr += "[";
		// Iterate through array, concatenating each element to stringArr
		for (int i = 0; i < a.length; ++i) 
		{	
			// If we are iterating through the last element...
			if(i == a.length - 1)
				// Do not print a comma
				stringArr += a[i];
			else
				stringArr += (a[i] + ",");
		}
		stringArr += "]";
		return stringArr;
	}

	// Combines two sorted arrays and returns the new array.
	private static Comparable[] merge(Comparable[] a, Comparable[] b)
	{	
		// Holds size of new merged array
		int newLen = a.length + b.length;
		// Holds new merged array
		Comparable[] c = new Comparable[newLen];
		// Used to iterate through arrays
		int aCtr = 0; 	
		int bCtr = 0;	
		int cCtr = 0;
		// Halts merge step
		boolean done = false;
		// Merge arrays. 
		while(!done)
		{	
			// If we are done iterating through array a...
			if(aCtr >= a.length)
			{	
				// Copy remaining contents of array b to array c
				while(bCtr < b.length)
				{
					c[cCtr] = b[bCtr];
					bCtr += 1;
					cCtr += 1;
				}
				// Terminate loop
				done = true;
			}
			// If we are done iterating through array b...
			else if(bCtr >= b.length)
			{
				// Copy remaining contents of array a to array c
				while(aCtr < a.length)
				{
					c[cCtr] = a[aCtr];
					aCtr += 1;
					cCtr += 1;
				}
				// Terminate loop
				done = true;				
			}
			else
			{
				// Compare corresponding elements
				int compare = a[aCtr].compareTo(b[bCtr]);
				// If a[aCtr] is greater...
				if(compare > 0)
				{
					// Copy b[bCtr] to array c
					c[cCtr] = b[bCtr];
					// Advance counters
					++bCtr;
					++cCtr;
				}
				else
				{
					// Copy a[aCtr] to array c
					c[cCtr] = a[aCtr];
					// Advance counters
					++aCtr;
					++cCtr;
				}
			}
		} 
		return c;
	}

	/*
	Stores each element in the array into another array of length 1,
	and stores each of these arrays into an arrayList and returns the list. 
	*/
	private static ArrayList<Comparable[]> makeArrays(Comparable[] array)
	{
		// Holds split arrays
		ArrayList<Comparable[]> temp = new ArrayList<>();
		// Iterate through array
		for (int i = 0; i < array.length ; ++i) 
		{	
			/*
			Store each value into a unit array, 
			then add the array into a list. 
			*/
			Comparable[] tempArr = new Comparable[1];
			tempArr[0] = array[i];
			temp.add(tempArr);
		} 
		return temp;
	}
}	
