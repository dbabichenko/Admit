package edu.pitt.is.admit;

import java.util.ArrayList;

/**
 * Represents a set of discrete ranges for a continuous variables
 * @author Dmitriy Babichenko
 *
 */
public class Range {
	private String rangeID; // ID of a range
	private ArrayList<State> stateList; // List of states (each state represents a min/max of a discrete range)
	
	/**
	 * Class constructor
	 * @param _id ID of a variable from BN model
	 */
	public Range(String _id){
		stateList = new ArrayList<State>();
		this.rangeID = _id;
	}
	
	/** 
	 * Getter for rangeID
	 * @return Name of a variable in BN 
	 */
	public String getRangeID(){
		return this.rangeID;
	}
	
	/**
	 * Getter for stateList
	 * @return List of states / discrete ranges for a given variable
	 */
	public ArrayList<State> getStateList(){
		return this.stateList;
	}
	
	/**
	 * Adds state / discrete range to a variable
	 * @param state
	 */
	public void addState(State state){
		this.stateList.add(state);
	}
}
