import java.awt.event.KeyEvent; 
/**
 * Drawable.java 
 * Class extends Occupant, main player of the game  
 * 
 * @author (Anshula Singh) 
 * @version (2/21/17)
 */
public class Explorer extends Occupant {
	private String name;
	private Maze maze; 
	
	
	public Explorer (Square location, Maze maze, String name) {
		super(location);
		this.maze = maze;
		this.name = name;
		maze.lookAround(location);
	}
	
	public String name() {
		//query for name
		return name; 
	}
	public void move(int key) {
		int keyRow = location().row();
		int keyCol = location().col(); 
		 
		if (key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP) {
			keyRow = keyRow -1;
			if (!location().wall(Square.UP)) {
				moveTo(maze.getSquare(keyRow, keyCol)); 
				
			}
		}
		if (key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN) {
			keyRow = keyRow +1;
			if (!location().wall(Square.DOWN)) {
				moveTo(maze.getSquare(keyRow, keyCol)); 
					
				}
			}
		if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT) {
			keyCol = keyCol -1;
			if (!location().wall(Square.LEFT)) {
				moveTo(maze.getSquare(keyRow, keyCol)); 
					
				}
			}
		if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT) {
			keyCol = keyCol +1;
			if (!location().wall(Square.RIGHT)) {
				moveTo(maze.getSquare(keyRow, keyCol)); 
					
				}
			}
		}
		
	
	
	public void moveTo (Square s) {
		super.moveTo(s);
		s.enter();
		maze.lookAround(s);
		
		
	}
}