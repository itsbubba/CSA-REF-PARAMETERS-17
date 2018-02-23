//© A+ Computer Science  -  www.apluscompsci.com
//Name - Jaden Taylor 
//Date - 1/19/17
//Class - 3rd
//Lab  - Parameter Reference

import java.util.Scanner;
import static java.lang.System.*;

public class LetterBoxes
{
	//instance variables and constructors could be present, but are not necessary
	
	public static void printBox(char letter, int size)
	{
		for(int x=0;x<size;x++)
		{
			for(int y=0;y<size;y++)
			{
				System.out.print(letter);
			}
			System.out.println();
		}
	
	}
}