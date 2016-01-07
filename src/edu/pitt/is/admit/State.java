package edu.pitt.is.admit;

/**
 * Represents a single discrete range of a continuous variable from a BN model.
 * Each range is associated with a state from an XML representation of a BN model.
 * @author Dmitriy Babichenko
 *
 */
public class State {
	private String stateID; // ID of a state, matches that of a corresponding state in BN model
	private double min; // Lower bound of the range
	private double max; // Upper bound of the range
	
	/**
	 * Class constructor
	 * @param _id ID of a state, matches that of a corresponding state in BN model
	 * @param _min Lower bound of the range
	 * @param _max Upper bound of the range
	 */
	public State(String _id, String _min, String _max){
		this.stateID = _id;
		
		// If it is the lower bound of a continuous variable and does not have a minimum value,
		// set the value to  Double.MIN_VALUE
		if(_min.equals("")){
			this.min = Double.MIN_VALUE;
		}
		else{
			this.min = Double.parseDouble(_min);
		}
		
		// If it is the upper bound of a continuous variable and does not have a maximum value,
		// set the value to  Double.MAX_VALUE
		if(_max.equals("")){
			this.max = Double.MAX_VALUE;
		}
		else{
			this.max = Double.parseDouble(_max);
		}
	}

	/**
	 * Getter for stateID
	 * @return ID of a state, matches that of a corresponding state in BN model
	 */
	public String getStateId() {
		return stateID;
	}

	/**
	 * Getter for range minimum
	 * @return Lower bound of the range
	 */
	public double getMin() {
		return min;
	}

	/**
	 * Getter for range maximum
	 * @return Upper bound of the range
	 */
	public double getMax() {
		return max;
	}
}
