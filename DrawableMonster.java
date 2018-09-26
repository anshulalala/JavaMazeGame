/**
 * DrawableMonster.java
 * 
 * Class draws the monsters 
 * 
 * @Author Anshula Singh
 * @version (2/21/17)
 */
public class DrawableMonster extends Monster implements Drawable {
	public DrawableMonster (Maze maze) {
		super(maze);
	}
	public DrawableMonster(Maze maze, long seed) {
		super(maze, seed); 
	}
	public DrawableMonster(Maze maze, Square location) {
		super(maze, location);
	}
	public void draw() {
		
	}
}