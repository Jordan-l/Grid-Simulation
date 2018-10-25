package solutions.exercise1;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import org.sopra.api.exercises.ExerciseSubmission;
import org.sopra.api.exercises.exercise1.AbstractScenarioUtilTest;
import org.sopra.api.model.PowerLine;
import org.sopra.api.model.PowerLineType;
import org.sopra.api.model.consumer.Consumer;
import org.sopra.api.model.consumer.ControllableConsumer;
import org.sopra.api.model.producer.ControllableProducer;
import org.sopra.api.model.producer.Producer;

public class ScenarioUtilTest extends AbstractScenarioUtilTest implements ExerciseSubmission{
	
	@BeforeClass
	public static void test_start() {
		System.out.println("Start testing...!");
	}
	
    @Test
	//Declaration that this method is a test method. If you run this class as JUnit Test, only the declared methods will run
	public void testGetPowerLinesByType() {
    	System.out.println("Test getPowerLinesByType");
		// The throws-declaration marks this method, that during the execution, there could be thrown an exception.
		// Usually you use that declaration, if you don't want to handle the exception in this method. The exception
		// will be given to the superior method, that called this method.
		List<PowerLine> highVoltageLines = sut.getPowerLinesByType(graph1, PowerLineType.HIGH_VOLTAGE);
		// Get a list of high voltage power lines
		assertTrue("Number of high voltage lines", highVoltageLines.size()==11);
		// Assert the status after the comma, if the status is not as expected, then return the string before the comma
		List<PowerLine> lowVoltageLines = sut.getPowerLinesByType(graph1, PowerLineType.LOW_VOLTAGE);
		// Get a map of low voltage power lines & booleans
		assertTrue("Number of low voltage lines", lowVoltageLines.size() == 3); //fail();
		// Assert the status after the comma, if the status is not as expected, then return the string before the comma
		List<PowerLine> mediumVoltageLines = sut.getPowerLinesByType(graph1, PowerLineType.MEDIUM_VOLTAGE);
		assertTrue("Number of medium voltage lines", mediumVoltageLines.size()==4);
		// Assert the status after the comma, if the status is not as expected, then return the string before the comma
	}
	
	@Test
	//Declaration that this method is a test method. If you run this class as JUnit Test, only the declared methods will run
	public void testGetPowerLinesByType_Parameters() {
		// The throws-declaration marks this method, that during the execution, there could be thrown an exception.
		// Usually you use that declaration, if you don't want to handle the exception in this method. The exception
		// will be given to the superior method, that called this method.
		try {
		// The keyword try marks a command-block that could throw an exception
			sut.getPowerLinesByType(null, null);
			// Try to call the method with that parameters, from sut (System Under Test)
			fail("no IllegalArgumentException thrown.");
			// If this point is reached, the test will fail!
		} catch (IllegalArgumentException e) {
			// The keyword catch marks a block in which the exception is going to be handled
		}
		try {
		// The keyword try marks a command-block that could throw an exception
			sut.getPowerLinesByType(null, PowerLineType.HIGH_VOLTAGE);
			// Try to call the method with that parameters, from sut (System Under Test)
			fail("no IllegalArgumentException thrown.");
			// If this point is reached, the test will fail!
			
		} catch (IllegalArgumentException e) { //NullPointerException
			// The keyword catch marks a block in which the exception is going to be handled
		}
		try {
		// The keyword try marks a command-block that could throw an exception
			sut.getPowerLinesByType(graph1, null);
			// Try to call the method with that parameters, from sut (System Under Test)
			fail("no IllegalArgumentException thrown.");
			// If this point is reached, the test will fail!
			
		} catch (IllegalArgumentException e) { //NullPointerException
			// The keyword catch marks a block in which the exception is going to be handled
		}
		try {
		// The keyword try marks a command-block that could throw an exception
			sut.getPowerLinesByType(graph1, PowerLineType.HIGH_VOLTAGE);
			// Try to call the method with that parameters, from sut (System Under Test)
			//fail("no IllegalArgumentException thrown.");
			// If this point is reached, the test will fail!
		} catch (IllegalArgumentException e) {
			// The keyword catch marks a block in which the exception is going to be handled
			
		}
	}

	@Test
	public void testGetControllableProducers() {
		System.out.println("Test getControllableProducers");
		List <ControllableProducer> controllableProducer = sut.getControllableProducers(graph1);
		//get list of controllable producer
		assertTrue("Number of controllable producer", controllableProducer.size()== 4);    
	}

	@Test
	public void testGetControllableProducers_Parameters() {
	    try {
	    	sut.getControllableProducers(null);
	    	fail("no IllegalArgumentException thrown.");
	    	
	    } catch (IllegalArgumentException e) {
	    	
	    }
	    try {
	    	sut.getControllableProducers(graph1);
	    	//fail("no IllegalArgumentException thrown.")
	    	
	    } catch (IllegalArgumentException e) {
	    	
	    }
	    
	}

	@Test
	public void testGetControllableConsumers() {
		System.out.println("Test getControllableConsumers");
		List <ControllableConsumer> controllableConsumer = sut.getControllableConsumers(graph1);
		//get list of controllable consumer
		assertTrue("Number of controllable consumer", controllableConsumer.size()== 3);	    
	}

	@Test
	public void testGetControllableConsumers_Parameters() {
	    try {
	    	sut.getControllableConsumers(null);
	    	fail("no IllegalArgumentException thrown.");
	    	
	    } catch(IllegalArgumentException e) {
	    	
	    }
	    try {
	    	sut.getControllableConsumers(graph1);
	    	//fail("no IllegalArgumentException thrown.");
	    	
	    } catch(IllegalArgumentException e) {
	    	
	    }
	    
	}

	@Test
	public void testGetProducers() {
		System.out.println("Test getProducers");
	    List<Producer> producer = sut.getProducers(graph1);
	    //get list of producer
	    assertTrue("Number of producer", producer.size()==10);
	}

	@Test
	public void testGetProducers_Parameters() {
	    try {
	    	sut.getProducers(null);
	    	fail("no IllegalArgumentException thrown.");
	    	
	    } catch (IllegalArgumentException e){
	    	
	    }
	    try {
	    	sut.getProducers(graph1);
	    	//fail("no IllegalArgumentException thrown.");
	    } catch (IllegalArgumentException e){
	    	
	    }
	    
	}

	@Test
	public void testGetConsumers() {
		System.out.println("Test getConsumers");
	    List <Consumer> consumer = sut.getConsumers(graph1);
	    //get list of consumer
	    assertTrue("Number of consumer", consumer.size() == 8); 
	}

	@Test
	public void testGetConsumers_Parameters() {
	    try {
	    	sut.getConsumers(null);
	    	fail("no IllegalArgumentException thrown.");
	    	
	    } catch(IllegalArgumentException e) {
	    	
	    }
	    try {
	    	sut.getConsumers(graph1);
	    	//fail("no IllegalArgumentException thrown.");
	    	
	    } catch(IllegalArgumentException e) {
	    	
	    }
	    
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
	
	@AfterClass
	public static void test_end() {
		System.out.println("Test end!");
	}
}
