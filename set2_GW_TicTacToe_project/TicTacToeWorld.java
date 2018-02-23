//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color; 
import info.gridworld.grid.Grid;
import info.gridworld.world.World;
import info.gridworld.grid.Location;
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
      setMessage("Welcome to TIC TAC TOE!  - -  Click a spot - "+whosTurn+" turn.");   	  	
   }

	//this method is called when a mouse click occurs
	//this method will draw Xs and Os at the location clicked
   public boolean locationClicked(Location loc)
   {
		Grid<Piece> grid = getGrid();
		if(grid==null)
			return false;
		
		//if the game is over, clear the board and get ready to play a new game
		if(gameOver==true)
		{
			//clear the board
		
		
			return false;      	
		}
		
		
		//this section will draw an X or an O
		Piece piece = grid.get(loc);      
		if(whosTurn.equals("X")&&piece==null)
		{
			add(loc,new Piece("X",Color.RED));
			whosTurn="O";
		}
		else if(whosTurn.equals("O")&&piece==null)
		{            
		
		
		
		}      
		
		
		
		return true;      
   }

  //this method will be called each time the step button is pressed
   public void step()
   {
   	
   	
   }   

	//this method will determine if someone has won the game
   public String getWinner()
   {
   	Grid<Piece> grid = getGrid();
   	if(grid==null)
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
		
		
		//check for vertical winner
		
		
		
		
	
		//check for diagonal winner












	   if(isWorldFull() && winner.length()==0){
		   winner =  "cat's game - no winner!\n\n";
		}
		else if(!isWorldFull() && winner.length()==0){
			winner="no winner";
		}
		return winner;
   }
   
   //this method will determine if the board if full of Xs and Os
   public boolean isWorldFull()
   {
		//getOccupiedLocations might prove handy





   	return true;
   }   
   
 	//this method will clear the board of all Xs and Os
   public void resetWorld()
   {
 
 
 
 
 
 
   }   
}