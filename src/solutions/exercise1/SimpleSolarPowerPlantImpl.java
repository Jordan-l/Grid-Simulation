package solutions.exercise1;

import org.sopra.api.exercises.ExerciseSubmission;
import org.sopra.api.exercises.exercise1.SimpleProducer;

/**
 * This class implements the structure of a solar power plant 
 * 
 * @author Jordan Lischka, Niklas Ramm, Leonard Buchta 
 * @version 1.0.0
 */
public class SimpleSolarPowerPlantImpl extends SimpleEnergyNodeImpl implements SimpleProducer, ExerciseSubmission {
	/**
	 * Constructor
	 * 
	 * @param x 
	 * 			x-coordinate of the SolarPowerPlant
	 * @param y	
	 * 			y-coordinate of the SolarPowerPlant
	 */
	public SimpleSolarPowerPlantImpl(int x, int y) {
		super(x, y);
		//Super-Constructor
	}

	/**
	 * Get the producer name (Getter Method)
	 * 
	 * @return value of the super type method and the String "SolarPowerPlant"
	 */
	@Override
	public String getProducerName() {
		String superName = super.getName();
		String nameString = superName + " : SolarPowerPlant";
		
		return nameString;
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