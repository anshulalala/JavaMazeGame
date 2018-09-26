import java.util.*;
/**
 * Occupant.java 
 * Class that is the parent class for explorer  
 * 
 * @author (Anshula Singh) 
 * @version (2/21/17)
 */


public abstract class Occupant {
	//field instance Var, Square, represents location
	private Square square; 
	public Occupant() {
		
	}
	public Occupant (Square start){
		this.square = start;
		//initialize Occupant location 
	}
	public Square location() {
		return square; 
		
	}
	public void moveTo(Square newLoc) {
		//command to change the Occupants location
		this.square = newLoc; 
	}
}