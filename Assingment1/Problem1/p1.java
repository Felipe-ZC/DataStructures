/*********************************************************************
Purpose/Description:

Uses a recursive tree to find all possible sums in an array.

Author’s Panther ID: 5159067
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/
public class p1
{
	public static void main(String[] args)
	{
		int[] test = {1,2,3};
		/*
		To find all possible sums,
		start at zero.
		*/
		recursiveSum(test,0,0);
	}

	public static void recursiveSum(int[] intArray, int start, int sum)
	{	
		// Stop when starting value is equal to the size of the array
		if(start == intArray.length)
		{	
			// Print value 
			System.out.println(sum);
			return;
		}

		// Add elements in array
		int val = intArray[start] + sum;

		// Find the sum of all elements in array
		recursiveSum(intArray,start+1,val);
		// Find all possible sums of elements in array
		recursiveSum(intArray,start+1,sum);
	}
}