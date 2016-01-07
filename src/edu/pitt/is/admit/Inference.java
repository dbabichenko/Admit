package edu.pitt.is.admit;

import java.util.ArrayList;

import smile.Network;

public class Inference {
	private Network net;
	private String networkPath;
	private ArrayList<String[]> applicantList;
	private RangeManager rangeManager;
	
	public Inference(String netPath, ArrayList<String[]> applicants, RangeManager rm){
		this.networkPath = netPath;
		this.applicantList = applicants;
		this.rangeManager = rm;
		// Create new network
		net = new Network();
		net.readFile(networkPath);
		net.updateBeliefs();
		
		// Update beliefs for each applicant
		int i = 0;
		for(String[] applicantData : applicantList){
			if(i > 0){
				Applicant applicant = new Applicant(applicantData, this.rangeManager);
				// System.out.println(applicant.getFirstName() + " : " + applicant.getAgeAtSisMatriculation() + " : " + applicant.getGpa1());
				updateApplicantBeliefs(applicant);
			}
			i++;
		}
		
	}
	
	public Inference(String netPath, Applicant applicant, RangeManager rm){
		
	}
	
	private void updateApplicantBeliefs(Applicant applicant){
		net.setEvidence("collegeRank", applicant.getCollegeRank1());
		net.setEvidence("majorCategory", applicant.getMajor1());
		net.setEvidence("gpaZscore", applicant.getGpa1());
		net.updateBeliefs();
		double[] outcomeValues = net.getNodeValue("gpaAtGraduation");
		System.out.println("Forecast: " + outcomeValues[outcomeValues.length - 1]);
	}
}
