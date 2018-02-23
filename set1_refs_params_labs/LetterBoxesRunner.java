//© A+ Computer Science  -  www.apluscompsci.com
//Name - Jaden Taylor 
//Date - 1/19/17
//Class - 3rd
//Lab  - Parameter Reference

import java.util.Scanner;
import static java.lang.System.*;

public class LetterBoxesRunner
{
	public static void main( String args[] )
	{
		LetterBoxes test = new LetterBoxes();
		Scanner keyboard = new Scanner(System.in);
		String choice="";
		do{
			out.print("\nEnter the letter for the box :: ");
			char word = keyboard.next().charAt(0);
			
			out.print("Enter the times to display :: ");
			int times = keyboard.nextInt();
			
			test.printBox(word,times);
			
			System.out.print("\nDo you want to enter more sample input? ");
			choice=keyboard.next();
			
		}while(choice.equals("Y")||choice.equals("y"));		
	}
}