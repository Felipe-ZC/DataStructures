/*********************************************************************
Purpose/Description: This program determines if two lists are disjoint
and prints the symmertric difference between them.

Author’s Panther ID: (Felipe Zuniga) 5159067
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/
import java.util.*;

public class p1
{
	public static void main(String[] args)
	{
		List<Integer> testList = new ArrayList<>();
		List<Integer> testList2 = new ArrayList<>();

		// ------------------- Test Case for disjoint ------------------- 

		// Add numbers 1-5 to testList
		for (int i = 1; i <= 5 ; ++i) 
		{
			testList.add(i);
		}
		// Add numbers 5-9 to testList2
		for (int i = 2; i <= 10 ; ++i) 
		{
			testList2.add(i);
		}

		// Print lists
		System.out.println("L1: " + testList.toString() +
				"\nL2: " + testList2.toString());

		// Output result of disjoint
		if(disjoint(testList,testList2))
		{
			System.out.println("Disjoint");
		}
		else
		{
			System.out.println("Not disjoint");
		}

		// ------------------- Test case for symDifference ------------------- 

		List<Integer> differenceList = new ArrayList<>();
		symDifference(testList,testList2,differenceList);
		// Print difference list
		System.out.println("Symmetric Difference: " + differenceList.toString());
	}

	/*
	Write explanation later, CHECK FOR ORDER!
	*/
	public static <AnyType extends Comparable<? super AnyType>>
	boolean disjoint(List<AnyType> L1, List<AnyType> L2)
	{	
		// Used to iterate through l1
		Iterator<AnyType> lit = L1.iterator();
		// Used to iterate through l2
		Iterator<AnyType> lit2 = L2.iterator();

		// Holds elments in L1
		AnyType l1Element = null;
		// Holds elements in L2
		AnyType l2Element = null;

		// Holds number of iterations
		int counter = 0;

		while(lit.hasNext() && lit2.hasNext())
		{	
			counter += 1;
			// If this is the first iteration...
			if(counter == 1)
			{
				// Get the first element from both lists
				l1Element = lit.next();
				l2Element = lit2.next();
			}
			else
			{
				// Compare elements from l1 and l2
				// If the elements are the same...
				if(l1Element.compareTo(l2Element) == 0)
				{	
					// The lists are not disjoint
					return false;
				}
				// If the element from l1 is greater than the element from l2...
				else if(l1Element.compareTo(l2Element) > 0)
				{	
					// Check for end of list
					if(lit2.hasNext())
						// Iterate through l2
						l2Element = (AnyType)lit2.next();
				}
				// If the element from l1 is less than the element from l2...
				else if(l1Element.compareTo(l2Element) < 0)
				{	
					// Check for end of list
					if(lit.hasNext())
						// Iterate through l1
						l1Element = (AnyType)lit.next();
				}
			}
		}

		// Compare last elements for equality
		if(l1Element.compareTo(l2Element) == 0)
			return false;
		// Method has not returned false, this means the lists are disjoint
		return true;
	}

	public static <AnyType extends Comparable<? super AnyType>>
	void symDifference(List<AnyType> L1, List<AnyType> L2,
	List<AnyType> Difference)
	{
		// Used to iterate through L1
		Iterator<AnyType> lit = L1.iterator();
		// Used to iterate through L2
		Iterator<AnyType> lit2 = L2.iterator();

		// Check if lists are disjoint
		// If the lists are disjoint...
		if(disjoint(L1,L2))
		{
			// Add all elements from L1 to Difference
			while(lit.hasNext())
			{
				Difference.add(lit.next());
			}
			// Add all elements for L2 to Difference
			while(lit2.hasNext())
			{
				Difference.add(lit2.next());
			}
			// No more operations are needed
			return;
		}
		// The lists are not disjoint...
		else
		{	
			// Holds the intersection between L1 and L2
			List<AnyType> intersection = new ArrayList<>();
			// Get first element from l1
			AnyType l1Element = null;
			// Get first element from l2
			AnyType l2Element = null;
			// Counts the number of iterations
			int counter = 0;

			// Iterate through L1
			while(lit.hasNext() && lit2.hasNext())
			{	
				counter += 1;
				// If this is the first iteration...
				if(counter == 1)
				{
					// Get first element from both lists
					l1Element = lit.next();
					l2Element = lit2.next();
				}
				else
				{				
					// Compare elements from l1 and l2
					// If the elements are the same...
					if(l1Element.compareTo(l2Element) == 0)
					{	
						// Add equal element to intersection list
						intersection.add(l1Element);
						// Iterate through the first list if possible
						if(lit.hasNext())
							l1Element = lit.next();
						if(lit2.hasNext())
							l2Element = lit2.next();
				
					}
					// If the element from l1 is greater than the element from l2...
					else if(l1Element.compareTo(l2Element) > 0)
					{	
						// Check for end of list
						if(lit2.hasNext())
							// Iterate through l2
							l2Element = (AnyType)lit2.next();
					}
					// If the element from l1 is less than the element from l2...
					else if(l1Element.compareTo(l2Element) < 0)
					{	
						// Check for end of list
						if(lit.hasNext())
							// Iterate through l1
							l1Element = (AnyType)lit.next();
					}
				}
			}

			// Check if last elements are equal to each other
			if(l1Element.compareTo(l2Element) == 0)
				intersection.add(l1Element);

			// Reinitialize iterators
			lit = L1.iterator();
			lit2 = L2.iterator();

			// Used to iterate through intersection
			Iterator<AnyType> intersectionIt = intersection.iterator();
			// Holds elements from the intersection list
			AnyType intersectionElement = null;
			l1Element = null;
			counter = 0;


			/*
			 Get all elements from L1 that are not in the intersection list
			 and add to Difference.
			*/
			 while(lit.hasNext())
			 {	
			 	counter += 1;
			 	// If this is the first iteration...
			 	if(counter == 1)
			 	{	
			 		// Get first element from L1
			 		l1Element = lit.next();
			 		// Get first element from intersection
			 		intersectionElement = intersectionIt.next();
			 	}
			 	else
			 	{
			 		if(l1Element.compareTo(intersectionElement) == 0)
			 		{
			 			// Iterate both lists
			 			l1Element = lit.next();
			 			if(intersectionIt.hasNext())
			 				intersectionElement = intersectionIt.next();
			 		}
			 		else if(l1Element.compareTo(intersectionElement) > 0)
			 		{
			 			// Itereate interseciont list
			 			if(intersectionIt.hasNext())
			 				intersectionElement = intersectionIt.next();
			 			else
			 				Difference.add(l1Element);
			 				l2Element = lit2.next();
			 		}
			 		else if(l1Element.compareTo(intersectionElement) < 0)
			 		{	
			 			Difference.add(l1Element);
			 			// Iterate L1
			 			l1Element = lit.next();
			 		}
			 	}
			 }

			 // Reinitialize intersection iterator
			 intersectionIt = intersection.iterator();
			 intersectionElement = null;
			 l2Element = null;
			 counter = 0;

			 /*
			 Get all elements from L2 that are not in the intersection list
			 and add to Difference.
			*/
			 while(lit2.hasNext())
			 {	
			 	counter += 1;
			 	// If this is the first iteration...
			 	if(counter == 1)
			 	{	
			 		// Get first element from L2
			 		l2Element = lit2.next();
			 		// Get first element from intersection
			 		intersectionElement = intersectionIt.next();
			 	}
			 	else
			 	{
			 		if(l2Element.compareTo(intersectionElement) == 0)
			 		{
			 			// Iterate both lists
			 			l2Element = lit2.next();
			 			if(intersectionIt.hasNext())
			 				intersectionElement = intersectionIt.next();
			 		}
			 		else if(l2Element.compareTo(intersectionElement) > 0)
			 		{
			 			// Itereate interseciont list
			 			if(intersectionIt.hasNext())
			 				intersectionElement = intersectionIt.next();
			 			else
			 				Difference.add(l2Element);
			 				l2Element = lit2.next();
			 		}
			 		else if(l2Element.compareTo(intersectionElement) < 0)
			 		{	
			 			Difference.add(l2Element);
			 			// Iterate L1
			 			l2Element = lit2.next();
			 		}
			 	}
			 }
		}
	}
}