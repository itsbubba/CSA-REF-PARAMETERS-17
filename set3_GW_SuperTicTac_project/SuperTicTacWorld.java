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
  
       	return false;
      }



      return true;	
   }
   
   public Location addPiece(Location loc)
   {
      return null;	
   }
   
   public void step()
   {   	
   }
   
   public boolean isWorldFull()
   {
   	return false;
   }

   public void resetWorld()
   {
   }

   public String getWinner(Location loc)
   {
		return "";
   }
}