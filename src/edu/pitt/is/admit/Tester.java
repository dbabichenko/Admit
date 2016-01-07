package edu.pitt.is.admit;

import java.util.Map;
import java.util.Set;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeManager rm = new RangeManager("config/discreteranges.xml");
		/*
		Map<String, Range> ranges = rm.getDiscreteRangeList();
		Set<String> keys = ranges.keySet();
		for(String key : keys){
			System.out.println(ranges.get(key).getRangeID());
			for(State s : ranges.get(key).getStateList()){
				System.out.println("\t" + s.getStateId() + " : " + s.getMin() + " - " + s.getMax());
			}
		}
		
		
		// Inference inf = new Inference("models/pc(05)_08_25_2015.xdsl");
		System.out.println(ranges.get("AGE_AT_MATRICULATION").getRangeID());
		*/
		
		rm.getStateFromValue("gpa3", 1.1);
		
	}

}
