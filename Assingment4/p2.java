import java.util.ArrayList;
/*********************************************************************
 Purpose/Description: Uses Radix sort to sort an array of ints in O(n) time. 
 Author’s Panther ID: 5159067
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
public class p2
{	
	public static void main(String[] args)
	{
		int[] testArr = {55,979,2,72,15,6,372,80,42};
		RadSort sort = new RadSort();
		System.out.print("Unsorted: [");
		for (int i = 0; i < testArr.length ; ++i) 
		{	
			if(i != (testArr.length - 1))
				System.out.print(testArr[i] + ",");
			else
				System.out.print(testArr[i]);
		}
		System.out.println("]");
		System.out.print("Sorted: ");
		sort.radixSort(testArr);
	}
}