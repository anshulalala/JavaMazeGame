import java.util.*;
/**
 * Maze.java 
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author (Anshula Singh) 
 * @version (2/21/17)
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
	  this.squares = squares;  
      this.rows = rows;
      this.cols = cols;
      randOccupants = new ArrayList<RandomOccupant>(); 
		
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
  
   public RandomOccupant getRandomOccupant(int index) {
	   return randOccupants.get(index);
	   }
   public int getNumRandOccupants() {
	   return randOccupants.size();
	   }
	
   // COMMANDS
   
   public void addRandomOccupant(RandomOccupant ro) {  
	   randOccupants.add(ro); 
   }
	
   public void setExplorer(Explorer e) {
	   explorer = e;
	   }
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      for(int i = 0; i < randOccupants.size(); i++) {
    	  (randOccupants.get(i)).move(); 
      }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
	  if(foundAllTreasures() == true){
          return EXPLORER_WIN;
      }
	  
      for(int i = 0; i < randOccupants.size(); i++){
          if((randOccupants.get(i)) instanceof Monster){
              if(((Monster)randOccupants.get(i)).location() == explorer.location()) {
                    return MONSTER_WIN;
              }
          }
      }
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
      int count = 0;
      int begin = 0;
        
      for(int i = 0; i < randOccupants.size(); i++){
            if(randOccupants.get(i) instanceof Treasure){
                begin++;
                if(((Treasure)randOccupants.get(i)).found() == true ) {
                   count++;
                }
            }
      }
      if(count != begin){
            foundAll = false;
      }
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
     
      if(!s.wall(Square.UP)){
    	  (getSquare(row-1,col)).setInView(true);
    	  }
      if(!s.wall(Square.RIGHT)){
    	  (getSquare(row,col+1)).setInView(true);
    	  }
      if(!s.wall(Square.DOWN)){
    	  (getSquare(row+1,col)).setInView(true);
    	  }
      if(!s.wall(Square.LEFT)){
    	  (getSquare(row,col-1)).setInView(true);
    	  }
      
      
      if(!s.wall(Square.UP)){
          if(!getSquare(row-1,col).wall(Square.LEFT)){
       
                 (getSquare(row-1,col-1)).setInView(true);
           }
      }
      if(!s.wall(Square.LEFT)){
           if(!getSquare(row,col-1).wall(Square.UP)){
           
                 (getSquare(row-1,col-1)).setInView(true);
           }
       
      }
 
      if(!s.wall(Square.UP)){
    	  
    	  if(!getSquare(row-1,col).wall(Square.RIGHT)){
    		  
    		  	getSquare(row-1,col+1).setInView(true);
          }
      }  
      if(!s.wall(Square.RIGHT)){
    		  
    	  if(!getSquare(row,col+1).wall(Square.UP)){
    	      
    	    	getSquare(row-1,col+1).setInView(true);
    	         }
    	      }
      
      if(!s.wall(Square.DOWN)){
    	  
      
          if(!getSquare(row+1,col).wall(Square.LEFT)){
               
        	    getSquare(row+1,col-1).setInView(true);
          }
       }
      
      if(!s.wall(Square.LEFT)){
          
    	  if(!getSquare(row,col-1).wall(Square.DOWN)){
             
    		    getSquare(row+1,col-1).setInView(true);
          }
       }
        
       if(!s.wall(Square.RIGHT)){
          
    	  if(!getSquare(row,col+1).wall(Square.DOWN)){
             
    		    getSquare(row+1,col+1).setInView(true);
          }
       }
       
       if(!s.wall(Square.DOWN)){
          
    	  if(!getSquare(row+1,col).wall(Square.RIGHT)){
             
    		    getSquare(row+1,col+1).setInView(true);
          }
       }
      }
     
      
    	  /*if( getSquare(row,col+1).wall(s.UP) == false){
       
    		  (getSquare(row-1,col+1)).setInView(true);
    	  }
       
    	  if( getSquare(row,col+1).wall(s.DOWN) == false){
       
    		  (getSquare(row+1,col+1)).setInView(true);
    	  }
      }
 */
      /*if(s.wall(s.DOWN) == false){
    	  (getSquare(row+1,col)).setInView(true);
       
    	  if( getSquare(row+1,col).wall(s.LEFT) == false){
       
    		  (getSquare(row+1,col-1)).setInView(true);
    	  }
       
    	  if( getSquare(row+1,col).wall(s.RIGHT) == false){
       
    		  (getSquare(row+1,col+1)).setInView(true);
    	  }
      }
 
      if(s.wall(s.LEFT) == false){
 
    	  (getSquare(row,col-1)).setInView(true);
 
    	  if( getSquare(row,col-1).wall(s.UP) == false){
       
    		  (getSquare(row-1,col-1)).setInView(true);
    	  }
       
    	  if( getSquare(row,col-1).wall(s.DOWN) == false){
       
    		  (getSquare(row+1,col-1)).setInView(true);
    	  }
 
 
      }

   }
      */
   
   /*  if (!s.wall(Square.UP)) {
      	Square topMaze = getSquare(row-1, col);
      	topMaze.setInView(true);
      	if (!topMaze.wall(Square.RIGHT)) {
       		Square topRow = getSquare(topMaze.row(), topMaze.col() + 1);
       		topRow.setInView(true);
       	}
       	if(!topMaze.wall(Square.LEFT)) {
       		Square topB = getSquare(topMaze.row(), topMaze.col() - 1);
       		topB.setInView(true); 
       }
       
       if (!s.wall(Square.DOWN)) {
      	Square downMaze = getSquare(row+1, col);
      	downMaze.setInView(true);
      	if (!downMaze.wall(Square.RIGHT)) {
       		Square bottom = getSquare(downMaze.row(), downMaze.col() + 1);
       		bottom.setInView(true);
       	}
       	if (!downMaze.wall(Square.LEFT)){
       		Square bottomB = getSquare(downMaze.row(), downMaze.col() - 1);
       		bottomB.setInView(true); 
       }
       
       if (!s.wall(Square.RIGHT)) {
      	Square rightMaze = getSquare(row, col+1);
      	rightMaze.setInView(true);
      	if (!rightMaze.wall(Square.UP)) {
       		Square right = getSquare(rightMaze.row() - 1, rightMaze.col());
       		right.setInView(true);
       	}
       	if (!rightMaze.wall(Square.DOWN)) {
       		Square rightB = getSquare(rightMaze.row() + 1, rightMaze.col());
       		rightB.setInView(true);
       	}
       }
       
       if (!s.wall(Square.LEFT)) {
      	Square leftMaze = getSquare(row, col-1);
      	leftMaze.setInView(true);
      	if (!leftMaze.wall(Square.UP)) {
       		Square left = getSquare(leftMaze.row() - 1, leftMaze.col());
       		left.setInView(true);
       	}
         if (!leftMaze.wall(Square.DOWN)) {
         	Square left2 = getSquare(leftMaze.row() + 1, leftMaze.col());
             left2.setInView(true);
       } }  }}
      
       }
    
    
    */
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   } 
}

