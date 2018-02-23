//� A+ Computer Science  -  www.apluscompsci.com
//Name - Jaden Taylor 
//Date - 1/19/17
//Class - 3rd
//Lab  - Parameter Reference

public class ArrayTools
{
	//instance variables and constructors could be present, but are not necessary
	
	//sumSection will return the sum of the numbers 
	//from start to stop, not including stop
	public static int sumSection(int[] numArray, int start, int stop)
	{
		int sum=0;
		for(int j=start;j<stop;j++)
		{
			sum=sum+numArray[j];
		}
		return sum;
	}
	
	//countVal will return a count of how many times val is present in numArray
	public static int countVal(int[] numArray, int val)
	{
		int count=0;
		for(int j=0; j<numArray.length;j++)
		{
			if(numArray[j]==val)
			{
				count++;
			}
		}

		return count;
	}
}