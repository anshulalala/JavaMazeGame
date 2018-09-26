/**
 * Drawable.java 

 * Class extends Occupant, but also extended by treas/monster for more playability  
 * 
 * @author (Anshula Singh) 
 * @version (2/21/17)
 */
import java.util.Random;

public abstract class RandomOccupant extends Occupant {
	private Random rand = new Random(); 
	private Maze maze; 
	
	
	public RandomOccupant(Maze maze) {
	   this.maze = maze; 
	   
	   int row = rand.nextInt(maze.rows());
	   int col = rand.nextInt(maze.cols());
	   
	   moveTo(maze.getSquare(row, col));
	
	}
	public RandomOccupant(Maze maze, long seed) {
	   this.maze = maze; 
	   rand = new Random(seed);
		
	   int row = rand.nextInt(maze.rows());
	   int col = rand.nextInt(maze.cols());
		   
	   moveTo(maze.getSquare(row, col));
		
		
	}
	public RandomOccupant(Maze maze, Square location) {
		this.maze = maze;
		moveTo(location); 
		}
	public void move() {
		Square square = this.location();
		boolean a = true; 
		
		
		while (a == true) {
			int wallNum = rand.nextInt(4);
		   
		   if (wallNum == Square.UP) {
			   if (square.wall(Square.UP) == false) {
			   moveTo(maze.getSquare(square.row()-1, square.col()));
			   a = false;
			   }
			    
		   }
		   
		   else if (wallNum == Square.RIGHT) {
			   if (square.wall(Square.RIGHT) == false) {
			   moveTo(maze.getSquare(square.row(), square.col()+1));
			   a = false;
			   }
			    
		   }
		   
		   else if (wallNum == Square.DOWN) {
			   if (square.wall(Square.DOWN) == false) {
			   moveTo(maze.getSquare(square.row()+1, square.col()));
			   a = false;
			   }
			    
		   }
		   
		   else if (wallNum == Square.LEFT) {
			   if (square.wall(Square.LEFT) == false) {
			   moveTo(maze.getSquare(square.row(), square.col()-1));
			   a = false;
			   }
			    
		   }
		}
		
		
		
	}
 }