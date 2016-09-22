
/*
Implements a Binary Search algorithm to find a number
in a SORTED integer array in O(log n) time.
Assumes array is sorted in ascending order.
*/

public class BinarySearch
{	
	public static void main(String[] args)
	{
		int[] testArray = {4,7,22,30,49,54,78};

		// Search for 7 in the testArray
		int index = search(78,testArray);

		// If the number was found...
		if(index >= 0)
		{
			System.out.println("The number was found at index " + index);
		}
		else
		{
			System.out.println("The number was not found");
		}
	}

	/*
	Uses a binary search algorithm to find the index
	of num in the sorted array arr. Returns the index 
	if the number was found, if not returns -1.

	This method assumes that the array arr is sorted
	in ascending order. 
	*/
	public static int search(int num, int[] arr)
	{	
		// Holds index of the highest value in the array
		int high = arr.length - 1;
		// Holds index of the lowest value in the array
		int low = 0;
		// Holds index of the value between high and low
		int mid = (high+low)/2;

		// Iterate through the array arr
		while(high >= low)
		{
			// If the number was found...
			if(num == arr[mid])
			{	
				// Return index of num
				return mid;
			}
			// If the number is greater than the middle value...
			else if(num > arr[mid])
			{	
				// Ignore all values less than mid

				// Update lowest value
				low = mid + 1;
				// Update middle value
				mid = (high+low)/2;
			}
			// If the number is less than the middle value...
			else if(num < arr[mid])
			{
				// Ignore all values greater than mid

				// Update highest value
				high = mid - 1;
				// Update middle value
				mid = (high+low)/2;
			}
		}
		// The number has not been found, return -1
		return -1;
	}
}