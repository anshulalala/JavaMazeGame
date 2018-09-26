/**
 * DrawableTreasure.java
 *
 * Class that draws the treasure
 * 
 * @author Anshula Singh 
 * @version (2/21/17)
 */

public class DrawableTreasure extends Treasure implements Drawable {


  public DrawableTreasure(Maze maze) {
    super(maze);
  }

  public DrawableTreasure(Maze maze, long seed) {
    super(maze, seed);
  }

  public DrawableTreasure(Maze maze, Square location) {
    super(maze, location);
  }

  public void draw() {
	  
  }
} 