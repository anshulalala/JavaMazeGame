/**
 * DrawableSquare.java
 * 
 * Class draws the squares 
 * 
 * @Author Anshula Singh
 *@version (2/21/17)
 */

public class DrawableSquare extends Square implements Drawable{


    public DrawableSquare(boolean up, boolean right, boolean down,
        boolean left, int row, int col){
        
            super(up, right, down, left, row, col);
    }
    
    public void draw(){
    	
    }
}