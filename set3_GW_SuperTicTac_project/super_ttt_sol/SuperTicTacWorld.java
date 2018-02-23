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

public class SuperTicTacWorld extends World<Piece>
{
   private String whosTurn;
   private boolean gameOver;
   private String winner;
   	
   public SuperTicTacWorld()
   {
   	super(new BoundedGrid<Piece>(6,7));
   	winner="no winner";
   	whosTurn="X";
   	gameOver=false;
      setMessage("Welcome to Super TIC TAC World!  - -  Click a spot - "+whosTurn+"'s turn.");   	  	
   }

   public boolean locationClicked(Location loc)
   {
		Grid<Piece> grid = getGrid();
      if(grid == null)
      	return false;
      	
      if(grid.get(loc)!=null)
      	return false;
      	
      if(gameOver == true)
      {
      	resetWorld();
      	gameOver = false;
      	winner = "no winner";
      	setMessage("Click a spot - " + whosTurn + "'s turn.\nClick the step button to check for a winner!");  
	     	return true;
      }
      Location addLoc = addPiece(loc);
      if(addLoc==null)      
      	return false;
      getWinner(addLoc);
      step();
      return true;	
   }
   
   public Location addPiece(Location loc)
   {
   	Grid<Piece> grid = getGrid();
   	if(grid==null)
         return null;

      Piece piece = grid.get(loc);
      int col = loc.getCol();
      int row = grid.getNumRows()-1;
      Location addLoc = new Location(row, col);
      while(grid.isValid(addLoc)&&grid.get(addLoc)!=null)
      {
      	row--;
      	addLoc = new Location(row, col);
      }
      
      if(row == -1)
      	return null;
      	
      if(whosTurn.equals("X") && piece==null)
      {
         add(addLoc,new Piece("X",Color.WHITE,Color.RED));
         whosTurn="O";
      }
      else if(whosTurn.equals("O") && piece==null)
      {            
         add(addLoc,new Piece("O",Color.YELLOW,Color.BLUE));
         whosTurn="X";
      }      
      setMessage("Click a spot - " + whosTurn + "'s turn.\nClick the step button to check for a winner!");        
      
      return addLoc;	
   }
   
   public void step()
   {
      Grid<Piece> grid = getGrid();
      if(grid == null)
      	return;
 
	   if(!winner.equals("no winner"))
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

   public String getWinner(Location loc)
   {
   	Grid<Piece> grid = getGrid();
   	if(grid == null)
         return "no winner";
         		
		String name = grid.get(loc).getName();
		int dir = 0;		
		for (int x=1; x<=8; x++)
		{
			Piece pc;
			Location newLoc = loc;	
			int r = 0;
			for (r = 1; r<=3; r++)
			{
				newLoc = newLoc.getAdjacentLocation(dir);
				if(!grid.isValid(newLoc))
					break;
					
				pc = grid.get(newLoc);
				if(pc == null) break;

				if(name.equals(pc.getName()))
				{
					winner=name+"wins!";
				}
				else
					break;
			}
			
			if(r==4){
				break;
			}
			winner = "no winner";
			dir = dir + 45;
		}	
			
	   if(isWorldFull() && winner.length()==0)
	   {
		   return "the board is full - no winner!";
		}
		else if(!isWorldFull() && winner.length()==0){
			return "no winner";
		}
		return winner;
   }
}