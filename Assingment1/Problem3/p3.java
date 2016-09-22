/*********************************************************************
Purpose/Description: 

By altering the initial conditions of the Fibonacci 
series (Lucas(0) = 2, Lucas(1) = 1) we obtain the 
Lucas Numbers. These two series of numbers are related
by the following formula:

		Ln = Fn−1 + Fn+1 (1)

Using this relation, we can find the nth Lucas number
indirectly by using a O(log n) Fibonacci Algorithm.

The Fibonacci algorithm that will be used to compute
the nth Lucas number is Matrix exponentiation. By
rasing the matrix A:

	{1 1}
	{1 0}

If we raise Matrix a to the nth -1 power 
and multiply it by a vector:

v = [f(1),f(0)] = [1,0] (Second and first fib. number) (2)

We get:

A^(n-1) * v = [f(n),f(n-1)] (Nth and (n-1) fib. num) (3)

By combining this with relation (1) we can find the nth
Lucas number by finding the nth - 1 fib. and nth + 1 fib.
number. 

Finding the nth Fibonacci number is done in O(log n) time. Finding
the Lucas number is in O(2) time as only an addition is needed to
find them. The total complexity for this algorithm is O(log n)

Author’s Panther ID: 5159067
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/
import java.math.BigInteger;

public class p3
{
	public static void main(String[] args)
	{	
		int num = 2150000;
		System.out.println("Lucas(" 
			+ num + ") = " + findLucas(num));
	}

	/*
	Returns nth Lucas number, does this by using matrix
	exponentiation to find the fn-1 and fn+1 Fibonacci 
	numbers. Then the program adds these numbers together
	returning the nth Lucas number.
	*/
	public static BigInteger findLucas(int n)
	{	

		if(n == 0)
		{
			return (BigInteger.ONE.add(BigInteger.ONE));
		}
		else if(n == 1)
		{
			return BigInteger.ONE;
		}
		else
		{
			BigInteger[] aMatrix = {BigInteger.ONE,BigInteger.ONE,BigInteger.ONE,BigInteger.ZERO};
			BigInteger[] vVector = {BigInteger.ONE,BigInteger.ZERO};

			// Get f(n-1)
			BigInteger[] fibNumbers = multiplyMat(matPow(aMatrix,(n-1)),vVector);

			/*
			The array contains two elements:
			{Fn,Fn-1}, we only need the last 
			element
			*/
			BigInteger fMinusOne = fibNumbers[1];

			// Get f(n+1)
			int temp = n +1;
			fibNumbers = multiplyMat(matPow(aMatrix,(temp-1)),vVector);
			BigInteger fPlusOne = fibNumbers[0];

			// The sum of fn-1 and fn+1 is athe nth lucas number
			return (fMinusOne.add(fPlusOne));
		}
	}

	/*
	Performs matrix multiplication, returns the product as
	an array of BigIntegers. 
	*/
	public static BigInteger[] multiplyMat(BigInteger[] m, BigInteger[] v)
	{
		// If v is a vector...
		if(v.length == 2)
		{
			// First product
			BigInteger x = m[0].multiply(v[0]);
			BigInteger y = m[1].multiply(v[1]);
			BigInteger sum1 = x.add(y);

			// Second product
			BigInteger w = m[2].multiply(v[0]);
			BigInteger z = m[3].multiply(v[1]);
			BigInteger sum2 = w.add(z);

			// Return product as an array of BigIntegers
			BigInteger[] product = {sum1,sum2};
			return product;
		}
		// If v is a matrix of size 4...
		else
		{
			// First product
			BigInteger w = m[0].multiply(v[0]);
			BigInteger x = m[1].multiply(v[2]);
			BigInteger sum1 = w.add(x);

			// Second product
			BigInteger y = m[0].multiply(v[1]);
			BigInteger z = m[1].multiply(v[3]);
			BigInteger sum2 = y.add(z);

			// Third product
			BigInteger i = m[2].multiply(v[0]);
			BigInteger j = m[3].multiply(v[2]);
			BigInteger sum3 = i.add(j);

			// Fourth product
			BigInteger k = m[2].multiply(v[1]);
			BigInteger l = m[3].multiply(v[3]);
			BigInteger sum4 = k.add(l);

			// Return product as an array of BigIntegers
			BigInteger[] product = {sum1,sum2,sum3,sum4};
			return product;
		}
	}

	/*
	Raises a matrix to the nth power, takes in a 
	matrix "mat" and the power "pow". Returns an array
	of BigIntegers.
	*/ 
	public static BigInteger[] matPow(BigInteger[] mat, int pow)
	{
		// If the power is 1...
		if(pow == 1)
		{
			// Return the matrix
			return mat;
		}
		// If the power is even...
		else if( (pow%2) == 0 )
		{	
			// Return mat ^ 2 and reduce power by half
			return matPow(multiplyMat(mat,mat),((int)Math.floor(pow/2)));
		}
		// If the power is odd and not equal to 1...
		else
		{	
			return multiplyMat(mat,matPow(multiplyMat(mat,mat),((int)Math.floor(pow/2))));
		}
	}
}