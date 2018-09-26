/**
 * Drawable.java 
 * Class extends RandOccupant, thing that explorer wants to find  
 * 
 * @author (Anshula Singh) 
 * @version (2/21/17)
 */
public class Treasure extends RandomOccupant {
	
	private boolean treasureFound; 
	
	public Treasure(Maze maze) {
		super(maze);
		treasureFound = false;
		super.location().setTreasure(this);
	}
	
	public Treasure (Maze maze, long seed) {
		super(maze, seed);
		treasureFound = false;
		super.location().setTreasure(this);
	}
	
	public Treasure (Maze maze, Square location) {
		super(maze, location);
		treasureFound = false;
		location.setTreasure(this);
	}
    
	public boolean found() {
		return treasureFound; 
	}

	
	public void setFound() {
		this.treasureFound = true;
		
	}
	public void move() {
		
	}
	
}