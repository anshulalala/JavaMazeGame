/**
 * Drawable.java 
 * Class creates squares and pixels for the maze 
 * 
 * @author (Anshula Singh) 
 * @version (2/21/17)
 */
public class Square {
	
		//constants 
		public static final int SQUARE_SIZE = 50; //number of pixels per square 
		public static final int UP = 0;
		public static final int RIGHT = 1;
		public static final int DOWN = 2;
		public static final int LEFT = 3;
		
		private boolean[] walls = new boolean[4];
		private int row = 0;
		private int col = 0;
		private Treasure treasure = null;
		private boolean seen = false;
		private boolean inView = false;
		//null treasure reference 
		
		public Square (boolean up, boolean right, boolean down, boolean left, int row, int col) 
		{
			walls[UP] = up;
			walls[RIGHT] = right;
			walls[DOWN] = down;
			walls[LEFT] = left;
			this.row = row;
			this.col = col;
			
		} 
		
		public boolean wall (int direction) {
			//query for wall in given direction 
			return walls[direction]; 
			
			
		}
		public boolean seen() {  
		
			return seen; 
			
		}
		public boolean inView() { 
			
			return inView;
			
		}
		public int row() { 
			return row; 
		}
		public int col() {  
			return col; 
		}
		public Treasure treasure() { 
			return treasure; 
		}
		public int x() {
			//x value of upper left corner of square, use row/col/sq_size
			return (col * SQUARE_SIZE);
			
		}
		public int y() {
			//y value of upper left corner of square
			return (row * SQUARE_SIZE);
		}
		public void setInView (boolean inView) {
			//command to tell square if it is currently in view of explorer
			// should also set seen to true if inview is true
			this.inView = inView; 
			if (inView == true) {
				this.seen = true; 
			}
			
			
		}
		public void setTreasure (Treasure t) {
			//sets treasure ref to the param t
			treasure = t; 
		}
		
		public void enter () {
			if (this.treasure != null) {
				treasure.setFound(); 
			}
			
		}
		
		
		
	}
	

	
