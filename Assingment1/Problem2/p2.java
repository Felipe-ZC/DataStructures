
/*********************************************************************
Purpose/Description: 
This program searches a matrix of size n for all occurrences of a specific 
number. The input matrix must have individual row and column be strong 
decreasing sequences. The algorithm starts at the bottom left element of 
the matrix and moves along testing each number. 

Then it searches the matrix diagonally, which means that in the worst case
the algorithm would have to search the entire matrix thus giving it a 
complexity of O(n).

Author’s Panther ID: 5159067
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

public class p2
{
	public static void main(String[] args)
	{
		// Test array
		int[][] testArr = 
		{
			{26,25,17},
			{16,7,5},
			{7,4,3}
		};

		int number = 7;
		System.out.println("The number " + number + " was found " + findNum(testArr,number)
			+ " time(s) in the matrix.");
	}

	public static int findNum(int[][] arr,int num)
	{	
		/*
		Start looking for the number in the bottom
		left portion of the Matrix
		*/
		int row = arr.length - 1;
		int col = 0;

		// The number of times num appears in arr
		int occurences = 0;

		//System.out.println("The size is: " + arr.length);

		/*
		Look for number in the whole matrix
		while staying in its boundaries.
		*/
		while(col < arr.length && row >= 0)
		{	
			// If the number has been found...
			if(arr[row][col] == num)
			{
				// Increment the number of occurrences
				occurences += 1;
				/*
				Go up one row, since there are no repeats
				we proceed to the next row. 
				*/
				--row;
			}
		    // If the number has not been found...
			else if(num > arr[row][col])
			{	
				// Too low, move on to the next row. 
				--row;
			}
			else
			{	// Too high, move on to the next column
				++col;
			}
		}
		return occurences;
	}
}