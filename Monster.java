/**
 * Monster.java 
 * Class extends randomoccupant class, randomly moves about  
 * 
 * @author (Anshula Singh) 
 * @version (2/21/17)
 */
public class Monster extends RandomOccupant {
	
	public Monster (Maze maze) {
		super(maze);
		
	}
	public Monster (Maze maze, long seed) {
		super(maze, seed); 
		
	}
	public Monster (Maze maze, Square location) {
		super(maze, location); 
		
	}
}