//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics; 
import java.awt.Font;

public class Piece implements Nameable
{
	private String name;
	private Color textColor;
	private Color backColor;
	
	public Piece()
	{
		setName("empty");
		setTextColor(Color.WHITE);
		setBackColor(Color.BLACK);
	}	

	public Piece(String n)
	{
		setName(n);
		setTextColor(Color.WHITE);			
		setBackColor(Color.BLACK);
	}

   public Piece(String n, Color text)
	{
		setName(n);
		setTextColor(Color.WHITE);	
		setBackColor(text);	
	}

   public Piece(String n, Color text, Color back)
	{
		setName(n);
		setTextColor(text);		
		setBackColor(back);
	}

	public void setName(String n)
	{
		name = n;
	}

	public void setBackColor(Color color)
	{
		backColor = color;
	}

	public void setTextColor(Color color)
	{
		textColor = color;
	}
	
	public String getName()
	{
		return name;
	}
	
   public String getText() 
   { 
      return getName(); 
   } 
   	
   public Color getTextColor()
   {
   	return textColor;	
   }
   	
	public Color getColor()
	{
		return backColor;
	}
	
	public String toString()
	{
		return getName() + " " + getTextColor() + " " + getColor();
	}
}