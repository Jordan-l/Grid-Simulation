package solutions.exercise1;


import org.sopra.api.exercises.ExerciseSubmission;
import org.sopra.api.exercises.exercise1.SimpleEnergyNode;


/**
 * Class description: *missing*
 * 
 * @author Jordan Lischka, Niklas Ramm, Leonard Buchta 
 * @version 1.0.0
 */
abstract class SimpleEnergyNodeImpl implements SimpleEnergyNode, ExerciseSubmission{
	
	/**
	 * x-coordinate of the EnergyNode
	 */
	final private int x;
	
	/**
	 * y-coordinate of the EnergyNode
	 */
	final private int y; 
	
	/**
	 * energy level of the EnergyNode
	 */
	protected int energyLevel;
	
	/**
	 * Constructor
	 * 
	 * @param x 
	 * 			x-coordinate of the EnergyNode
	 * @param y	
	 * 			y-coordinate of the EnergyNode
	 */
	protected SimpleEnergyNodeImpl(int x, int y) {
		this.x = x;
		this.y = y;
		this.energyLevel = 0;
	}
	
	/**
	 * Get the energyLevel of the EnergyNode (Getter Method)
	 * 
	 * @return energyLevel of the EnergyNode - int 
	 */
	@Override
	public int getEnergyLevel() {
		return this.energyLevel;
	}
	/**
	 * Get the name of the EnergyNode (Getter Method)
	 * 
	 * @return "EnergyNode" - String
	 */
	@Override
	public String getName() {
		return "EnergyNode";
	}
	/**
	 * Get the x-coordinate of the EnergyNode (Getter Method)
	 * 
	 * @return x-coordinate of the EnergyNode - int
	 */
	@Override
	public int getXPos() {
		return this.x;
	}
	
	/**
	 * Get the y-coordinate of the EnergyNode (Getter Method)
	 * 
	 * @return y-coordinate of the EnergyNode - int
	 */
	@Override
	public int getYPos() {
		return this.y;
	}
	/**
	 * Set the energyLevel (Setter Method)
	 * 
	 * @param energyLevel  
	 * 			EnergyLevel of the EnergyNode - int
	 */
	@Override
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
		
	}
	/**
	 * This function returns the a unique team identifier, format: G<xx>T<yy> xx represent the group number and yy represent the team number
	 * 
	 * @return unique team identifier - String
	 */
	@Override
	public String getTeamIdentifier() {
		return "G08T03";
	}
	
}