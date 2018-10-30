
package solutions.exercise1;

import java.util.*;

import org.sopra.api.Scenario;
import org.sopra.api.exercises.ExerciseSubmission;
import org.sopra.api.exercises.exercise1.ScenarioUtil;
import org.sopra.api.model.EnergyNode;
import org.sopra.api.model.Graph;
import org.sopra.api.model.PlayfieldElement;
import org.sopra.api.model.PlayfieldElement.ElementType;
import org.sopra.api.model.PowerLine;
import org.sopra.api.model.PowerLineType;
import org.sopra.api.model.consumer.Consumer;
import org.sopra.api.model.consumer.ControllableConsumer;
import org.sopra.api.model.producer.ControllableProducer;
import org.sopra.api.model.producer.Producer;

/**
 * This class implements auxiliary methods to get the main informations on the current scenario and graph object.
 * 
 * @author Jordan Lischka, Niklas Ramm, Leonard Buchta 
 * @version 1.0.0
 */
public class ScenarioUtilImpl implements ExerciseSubmission, ScenarioUtil {
	/**
	 * This function returns a list object that contain all PlayfieldElements from the given ElementType.
	 * 
	 * @param type
	 * 			Type of the searching landscape (beach, sea, mountain, grass, river)
	 * 
	 * @param scenario
	 * 			Is the data type of the game. Each scenario contains a play field with EnergyNodes and land model,
	 * 			
	 * @return 	List with all elements of the searched type
	 */
	@Override
	public List<PlayfieldElement> getPlayfieldElementsByType(Scenario scenario, ElementType type) {
		if (scenario == null || type == null) {
			//check for null parameters
				throw new IllegalArgumentException("Parameter is not allowed to be null."); //NullPointerException
				//if at least 1 parameter is null, then throw the exception
			}
		List<PlayfieldElement> ret = new ArrayList<PlayfieldElement>();
		
		for (int x = 0; x < scenario.getPlayfield().getHorizontalSize(); x++) {
		//Iterate over the whole play field in horizontal direction (x-axes)
			for (int y = 0; y < scenario.getPlayfield().getVerticalSize(); y++) {
				//Iterate over the whole play field in vertical direction (y-axes)
				PlayfieldElement element = scenario.getPlayfield().getPlayfieldElement(x,y);
				//Take the play field element by the iterated position (x,y)
				if (element.getElementType() == type) {
				//check if the element type is the same as the searched one
					ret.add(element);
					//if it is the same, then add the current play field element to the result list
				}
			}
		}
		return ret;
		// give the result back
	}
	
	
	
	/**
	 * This function returns a list object that contains all nodes from type ControllableProducer.
	 * ControllableProducer are BioGasFiredPowerPlant, CoalFiredPowerPlant, NuclearPowerPlant, GasFiredPowerPlant
	 * 
	 * @param graph 
	 * 			Graph consists of consumer and producer (nodes) that are connected by power lines (edges).
	 * 
	 * @return List with elements of type ControllableProducer 
	 */
	@Override
	public List<ControllableProducer> getControllableProducers(Graph<EnergyNode, PowerLine> graph) {
	    if(graph == null)
	    	throw new IllegalArgumentException("Parameter is not allowed to be null.");
	    
	    List  <ControllableProducer> nodesFromTypeCP = new ArrayList <ControllableProducer>();
	    
	    Set <EnergyNode> nodes = new HashSet <EnergyNode>(graph.getNodes());
	    
	    for (Iterator<EnergyNode> i = nodes.iterator(); i.hasNext();) {
	    	EnergyNode eNode = i.next();
	    	
	    	if(eNode instanceof ControllableProducer) {
	    		nodesFromTypeCP.add((ControllableProducer) eNode);
	    	}
	    }
	    return nodesFromTypeCP;
	}
	
	/**
	 * This functions returns a list object that contain all nodes from data type ControllableConsumer
	 * ControllableConsumer are all types of IndustrialParks
	 * 
	 * @param graph 
	 * 			Graph consists of consumer and producer (nodes) that are connected by power lines (edges).
	 * 
	 * @return List from type ControllableConsumer 
	 */
	
	@Override
	public List<ControllableConsumer> getControllableConsumers(Graph<EnergyNode, PowerLine> graph) {
		if(graph == null)
	    	throw new IllegalArgumentException("Parameter is not allowed to be null.");
		
		List <ControllableConsumer> nodesFromTypeCC = new ArrayList <ControllableConsumer>();
		
		Set <EnergyNode> nodes = new HashSet <EnergyNode>(graph.getNodes());
		
		for (Iterator<EnergyNode> i = nodes.iterator(); i.hasNext();) {
	    	EnergyNode eNode = i.next();
	    	
	    	if(eNode instanceof ControllableConsumer) {
	    		nodesFromTypeCC.add((ControllableConsumer) eNode);
	    	}
	    }
		return nodesFromTypeCC;
	}
	
	/**
	 * This function returns a list object that contain all nodes from type Producer.
	 * 
	 * @param graph 
	 * 			Graph consists of consumer and producer (nodes) that are connected by power lines (edges).
	 * 
	 * @return List from type Producer 
	 */
	@Override
	public List<Producer> getProducers(Graph<EnergyNode, PowerLine> graph) {
		if(graph == null)
			throw new IllegalArgumentException("Parameter is not allowed to be null.");
		
		List <Producer> nodesFromTypeP = new ArrayList<Producer>();
		
		Set <EnergyNode> nodes = new HashSet <EnergyNode>(graph.getNodes());
		for (Iterator<EnergyNode> i = nodes.iterator(); i.hasNext();) {
	    	EnergyNode eNode = i.next();
	    	
	    	if(eNode instanceof Producer) {
	    		nodesFromTypeP.add((Producer) eNode);
	    	}
	    }
		return nodesFromTypeP;
	}
	
	/**
	 * This function returns a list object that contain all nodes from data type Consumer.
	 * 
	 * @param graph 
	 * 			Graph consists of consumer and producer (nodes) that are connected by power lines (edges).
	 * 
	 * @return List from type Consumer 
	 */
	@Override
	public List<Consumer> getConsumers(Graph<EnergyNode, PowerLine> graph) {
		if(graph == null)
			throw new IllegalArgumentException("Parameter is not allowed to be null.");
		
		List <Consumer> nodesFromTypeC = new ArrayList<Consumer>();
		
		Set <EnergyNode> nodes = new HashSet <EnergyNode>(graph.getNodes());
		
		for (Iterator<EnergyNode> i = nodes.iterator(); i.hasNext();) {
	    	EnergyNode eNode = i.next();
	    	
	    	if(eNode instanceof Consumer) {
	    		nodesFromTypeC.add((Consumer) eNode);
	    	}
	    }
		return nodesFromTypeC;
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

	/**
	 * This function returns a list object, that contain all edges (PowerLine) from the given PowerLineType.
	 * 
	 * @param graph 
	 * 			Graph consists of consumer and producer (nodes) that are connected by power lines (edges).
	 * 
	 * @param type 
	 * 			Type of the searching PowerLine, it exists three types: High_Voltage, Medium_Voltage, Low_Voltage
	 * 
	 * @return List from given PowerLineType
	 */
	@Override
	public List<PowerLine> getPowerLinesByType(Graph<EnergyNode, PowerLine> graph, PowerLineType type) {
		if(graph == null || type == null)
			throw new IllegalArgumentException("Parameter is not allowed to be null.");
		
		List <PowerLine> edgesFromTyp = new ArrayList<PowerLine>();
		
		Set <PowerLine> edges = new HashSet <PowerLine>(graph.getEdges());
		
		for (Iterator<PowerLine> i = edges.iterator(); i.hasNext();) {
	    	PowerLine pLine = i.next();
	    	
	    	if(pLine.getType() == type) {
	    		edgesFromTyp.add(pLine); 
	    	}
	    }
		return edgesFromTyp;
	}

	
}


/**
 * Fragen:
 * 
 * 1) muss für die Methode getPlayfieldElementsByType eine Test-Methode implementiert werden, wenn ja was ist das Scenario.
 * 
 * 2) muss bei den Test methoden eine throws Exception declaration (an Methodenkopf) angehänt werden ? wenn ja , was macht die (unterscied zu ohne). 
 */
