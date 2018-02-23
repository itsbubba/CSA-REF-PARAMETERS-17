//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color; 
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import info.gridworld.grid.BoundedGrid;

public class TicTacToeWorld extends World<Piece>
{
   private String whosTurn;
   private boolean gameOver;
   	
   public TicTacToeWorld()
   {
   	super(new BoundedGrid<Piece>(3,3));
   	whosTurn="X";
   	gameOver=false;
      setMessage("Welcome to TIC TAC TOE!  - -  Click a spot - "+whosTurn+"'s turn.");   	  	
   }

   public boolean locationClicked(Location loc)
   {
		Grid<Piece> grid = getGrid();
      if(grid == null)
      	return false;
      	
      if(gameOver == true)
      {
      	resetWorld();
      	gameOver = false;
      	setMessage("Click a spot - " + whosTurn + "'s turn.\nClick the step button to check for a winner!");  
      	return true;
      }

      Piece piece = grid.get(loc);      
      if(whosTurn.equals("X") && piece==null)
      {
         add(loc,new Piece("X",Color.WHITE,Color.RED));
         whosTurn="O";
      }
      else if(whosTurn.equals("O") && piece==null)
      {            
         add(loc,new Piece("O",Color.YELLOW,Color.BLUE));
         whosTurn="X";
      }      
      setMessage("Click a spot - " + whosTurn + "'s turn.\nClick the step button to check for a winner!");        
      
      step();
      
      return true;      
   }
   
   public void step()
   {
      Grid<Piece> grid = getGrid();
      if(grid == null)
      	return;
 
      String winner = getWinner();
	   if(! winner.equals("no winner"))
	   {
		   setMessage("And the winner is . . . . "+winner+".\nClick anywhere on the board to play another game!");   
		   gameOver = true;           
      }      	
   }
   
   public boolean isWorldFull()
   {
   	Grid<Piece> grid = getGrid();
   	if(grid == null)
         return false;
         
   	ArrayList<Location> list = grid.getOccupiedLocations();  
   	return (grid.getNumCols()*grid.getNumRows()==list.size());
   }

   public void resetWorld()
   {
   	Grid<Piece> grid = getGrid();
   		  	
   	if(grid == null)
         return;
         
   	ArrayList<Location> list = grid.getOccupiedLocations();   
		for(Location loc : list)
		{
   		grid.remove(loc);			
		}
   }

   public String getWinner()
   {
   	Grid<Piece> grid = getGrid();
   	if(grid == null)
         return "no winner";
         		
		String winner="";
		for (int r = 0; r<grid.getNumRows(); r++)
		{
			Piece row0 = grid.get(new Location(r,0));
			Piece row1 = grid.get(new Location(r,1));
			Piece row2 = grid.get(new Location(r,2));
			
			if(row0==null||row1==null||row2==null) continue;
			
			if(row0.getName().equals(row1.getName())&&row0.getName().equals(row2.getName()))
			{
				winner=row0.getName()+" wins horizontally!";
				break;
			}
		}
		for (int c= 0; c<grid.getNumCols(); c++)
		{
			Piece col0 =grid.get(new Location(0,c));
			Piece col1 =grid.get(new Location(1,c));
			Piece col2 =grid.get(new Location(2,c));
				
			if(col0==null||col1==null||col2==null) continue;
			
			if(col0.getName().equals(col1.getName())&&col0.getName().equals(col2.getName()))
			{
				winner=col0.getName()+" wins vertically!";
				break;
			}
		}
		
		if(winner.equals(""))
		{
			Piece diag0 =grid.get(new Location(0,0));
			Piece diag1 =grid.get(new Location(1,1));
			Piece diag2 =grid.get(new Location(2,2));
				
			if(!(diag0==null||diag1==null||diag2==null)) 
				if(diag0.getName().equals(diag1.getName())&&diag0.getName().equals(diag2.getName()))
				{
					winner=diag0.getName()+" wins diagonally!";
				}
		}
		
		if(winner.equals(""))
		{
			Piece diag0 =grid.get(new Location(2,0));
			Piece diag1 =grid.get(new Location(1,1));
			Piece diag2 =grid.get(new Location(0,2));
				
			if(!(diag0==null||diag1==null||diag2==null)) 
				if(diag0.getName().equals(diag1.getName())&&diag0.getName().equals(diag2.getName()))
				{
					winner=diag0.getName()+" wins diagonally!";
				}
		}

	   if(isWorldFull() && winner.length()==0)
	   {
		   return "cat's game - no winner!";
		}
		else if(!isWorldFull() && winner.length()==0){
			return "no winner";
		}
		return winner;
   }
}