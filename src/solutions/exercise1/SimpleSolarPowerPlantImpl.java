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
	 * @return x- and y-coordinate of the SolarPowerPlant and the String "SolarPowerPlant"
	 */
	@Override
	public String getProducerName() {	//funktion ist im interface exercise.exercise1.SimpleProducer beschrieben
		int x = super.getXPos();
		int y = super.getYPos();
		
		return x+" "+y+" : SolarPowerPlant";		//ist das so gemeint ? siehe docs / Aufgabenstellung
	}
	
	
	
}