package edu.pitt.is.admit;

import java.util.Hashtable;
import java.util.Map;
import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * @author Dmitriy Babichenko
 * Manages discrete ranges for variables used in the Bayesian network models.  Bayesian models used by this application
 * use discretized variables - states in node representing originally continuous variables in the BN model have ranges associated with them.
 * In order to update beliefs in nodes that originally represented continuous variables this class matches each value with a range and returns
 * a state whose range matches the provided variable value.    
 */
public class RangeManager {
	private Map<String, Range> discreteRangeList; // Complete list of all ranges in the BN model
	private String filePath; // Relative path to a BN model
	
	/**
	 * Class constructor
	 * @param path Relative path to a BN model
	 */
	public RangeManager(String path){
		this.filePath = path;
		discreteRangeList = new Hashtable<String, Range>();
		// Read ranges from a configurations file associated with BN model
		readDiscreteRanges();
	}

	/**
	 * Reads a configuration file that describes discrete ranges for continuous variables used in 
	 * BN Model. Configuration files are in XML format.
	 */
	private void readDiscreteRanges(){
		try {	
			// Read the configuration file (XML format)
			File inputFile = new File(this.filePath);
			DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			// Grab the root element
			NodeList rangeList = doc.getElementsByTagName("range");
			
			// Iterate through nodes in XML config file
			// Each node represents a variables in BN model
			for (int i = 0; i < rangeList.getLength(); i++) {
				Element range = (Element) rangeList.item(i); 
				Range r = new Range(range.getAttribute("id"));
				
				// Iterate through states.  Each state represents a discrete range
				NodeList stateList = range.getElementsByTagName("state");
				for(int j = 0; j < stateList.getLength(); j++){
					Element state = (Element) stateList.item(j);
					State s = new State(state.getAttribute("id"), state.getAttribute("min"), state.getAttribute("max"));
					r.addState(s);
				}
				discreteRangeList.put(r.getRangeID(), r);
				//System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Iterates through states of a given variables until finds a range 
	 * where provided value falls between the range's min and max.
	 * @param rangeID ID/Name of a variable
	 * @param val Value of a continuous variable for which we need to find a corresponding discrete range.
	 * @return Matched state ID for provided variable.
	 */
	public String getStateFromValue(String rangeID, double val){
		Range r = discreteRangeList.get(rangeID);
		for(State s : r.getStateList()){
			if(s.getMin() < val && s.getMax() >= val){
				// System.out.println("\t" + s.getStateId() + " : " + s.getMin() + " - " + s.getMax());
				return s.getStateId();
			}
			
		}
		return "";
	}
	
	/**
	 * Getter
	 * @return a list of all discrete ranges provided in the configuration file.
	 */
	public Map<String, Range> getDiscreteRangeList(){
		return this.discreteRangeList;
	}
}
