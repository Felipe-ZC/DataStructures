import java.util.ArrayList;
import java.util.List;

public class RadSort
	{	
		public RadSort()
		{
			radixBuckets = new ArrayList<List<Integer>>();
			placeBuckets();
		}
		public void radixSort(int arr[])
		{
			// Counts the number of radix sort iterations
			int passes = 0;
			// Number of digits of the max element in the array
			int maxDigit = findMaxDigit(arr);
			int arrSize = arr.length;
			// Used to iterate through an integers digits
			int currDigit = maxDigit - 1;
			// While some number in arr has a next non zero digit...
			while(passes < maxDigit)
			{	
				// Iterate through arr
				for (int i = 0; i < arrSize ; ++i) 
				{	
					// Get next integer
					int curr = arr[i];
					// Convert to String
					String temp = Integer.toString(curr);
					// If this is the first pass...
					if(passes == 0)
					{
						currDigit = temp.length() - 1;
					}
					else
					{
						currDigit = temp.length() - (passes+1);
					}
					if(currDigit < 0)
					{
						// Add to zero bucket 
						placeInBucket(curr,0);
					}
					else
					{
						// Get next digit
						String nextDigit = "" + temp.charAt(currDigit);
						int nD = Integer.parseInt(nextDigit);
						// Place in correct bucket
						placeInBucket(curr,nD);
					}
					// Repeat for all ints in arr
				}
				/*
				Removes all numbers from buckets and
				places them back into the array.
				*/
				arr = makeNewArr(arr);
				// Increase number of passes
				passes += 1;
				// Clear radix 
				radixBuckets.clear();
				placeBuckets();
			}

			// Print sorted array
			System.out.print("[");
			for (int i = 0; i < arr.length ; ++i) 
			{	
			if(i != (arr.length - 1))
				System.out.print(arr[i] + ",");
			else
				System.out.print(arr[i]);
			}
			System.out.println("]");
		}

		// Places numbers from radix buckets into the specfied array
		private int[] makeNewArr(int[] arr)
		{	
			// Used to iterate through radix buckets
			int radIter = radixBuckets.size() - 1;
			// Used to iterate through new array
			int newIter = 0;
			// Holds new array
			int[] newArr = new int[arr.length];
			// Holds current bucket
			List<Integer> currBucket = new ArrayList<>();
			// Add every element from buckets to new array
			while(radIter >= 0)
			{
				// Get next bucket
				currBucket = radixBuckets.get(radIter);
				// Used to iterate through each digit bucekt
				int bktIter = 0;
				// Check for empty bucket
				if(currBucket.size() != 0)
				{
					// Add all items from current bucket to array
					while(newIter < newArr.length && bktIter < currBucket.size())
					{
						// Get next number from current bucket
						int currNum = currBucket.get(bktIter);
						// Place in new array
						newArr[newIter] = currNum;
						// Advance iterators
						bktIter += 1;
						newIter += 1;
					}
				}
				radIter -= 1;
			}
			return newArr;
		}

		// Adds all items from specified bucket into specified array
		// Places all digit buckets in the radix bucket
		private void placeBuckets()
		{	
			int ctr = 0;
			// Add nine buckets to radix buckets, each index represents a digit
			while(ctr < 10)
			{
				radixBuckets.add(new ArrayList<Integer>());
				ctr += 1;
			}
		}

		private void placeInBucket(int num, int dig)
		{	
			radixBuckets.get(dig).add(num);
		}

		/*
		Finds the number of digits in the max value of
		the specified array. Returns number of digits
		of the highest value in the specified array.
		Complexity: O(n)
		*/
		public int findMaxDigit(int[] array)
		{
			// Find max value in array
			int max = findMax(array);
			// Convert to string
			String asString = Integer.toString(max);
			// Return number of digits
			return asString.length();
		}

		// Calculates and returns the number of digits in an integer
		// Complexity O(1)
		public int findDigits(int num)
		{
			// Convert to String
			String asString = Integer.toString(num);
			// Return number of digits
			return asString.length();
		}

		// Finds the max element in the specified array 
		// Complexity: O(n)
		public int findMax(int[] a)
		{
			// Holds the max value of a
			int maxVal = 0;
			// Iterate through a
			for (int i = 0; i < a.length; ++i) 
			{	
				// If the current element is greater than the max value...
				if(maxVal < a[i])
					// Make this element the max value
					maxVal = a[i];
			}
			return maxVal;
		}

		/*
		Holds integers for each pass the indices 0-9
		of this list represent the digits 0-9, each 
		integer of the array is stored.
		*/
		private List<List<Integer>> radixBuckets;
		// Digit Buckets
		private ArrayList<Integer> zeroBkt;
		private ArrayList<Integer> oneBkt;
		private ArrayList<Integer> twoBkt;
		private ArrayList<Integer> threeBkt;
		private ArrayList<Integer> fourBkt;
		private ArrayList<Integer> fiveBkt;
		private ArrayList<Integer> sixBkt;
		private ArrayList<Integer> sevenBkt;
		private ArrayList<Integer> eightBkt;
		private ArrayList<Integer> nineBkt;

	}