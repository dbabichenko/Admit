package edu.pitt.is.admit;

/**
 * This class represents an applicant to the MSIS program at the 
 * School of Information Sciences.
 * @author Dmitriy Babichenko
 *
 */
public class Applicant {
	private String id;
	private String firstName;
	private String lastName;
	private String collegeRank1;
	private String collegeRank2;
	private String collegeRank3;
	private String major1;
	private String major2;
	private String major3;
	private String gpa1;
	private String gpa2;
	private String gpa3;
	private String degree1;
	private String degree2;
	private String degree3;
	private String ageAtSisMatriculation;
	private String gpaAtGraduation;
	private String gender;
	private String verbalScore;
	private String quantatativeScore;
	
	private RangeManager rangeManager;

	/**
	 * Class constructor
	 * @param applicantData List of applicant properties represented as a String[] array
	 * @param rm Range manager object - a list of all discrete ranges from the BN model
	 */
	public Applicant(String[] applicantData, RangeManager rm){
		rangeManager = rm;
		
		this.id = applicantData[0]; // ID
		this.setFirstName(applicantData[1]); // First Name
		this.setLastName(applicantData[2]);
		this.setAgeAtSisMatriculation(applicantData[3]);
		this.setGender(applicantData[4]);
		this.setVerbalScore(applicantData[5]);
		this.setQuantatativeScore(applicantData[6]);
		this.setCollegeRank1(applicantData[7]);
		this.setGpa1(applicantData[8]);
		this.setDegree1(applicantData[9]);
		this.setMajor1(applicantData[10]);
		
	}
	
	/**
	 * Class constructor
	 * @param applicantID ID of an applicant
	 * @param rm Range manager object - a list of all discrete ranges from the BN model
	 */
	public Applicant(String applicantID, RangeManager rm){
		rangeManager = rm;
		this.id = applicantID; // ID
	}

	/**
	 * Getter for college rank 1
	 * @return rank for college/university that awarded applicant's first degree prior to application to SIS. 
	 */
	public String getCollegeRank1() {
		return collegeRank1;
	}

	/**
	 * Setter for college rank 1
	 * @param collegeRank1 rank for college/university that awarded applicant's first degree prior to application to SIS.
	 */
	public void setCollegeRank1(String collegeRank1) {
		this.collegeRank1 = collegeRank1;
	}

	/**
	 * Getter for college rank 2
	 * @return rank for college/university that awarded applicant's second degree prior to application to SIS. 
	 */
	public String getCollegeRank2() {
		return collegeRank2;
	}

	/**
	 * Setter for college rank 2
	 * @param collegeRank2 rank for college/university that awarded applicant's second degree prior to application to SIS.
	 */
	public void setCollegeRank2(String collegeRank2) {
		this.collegeRank2 = collegeRank2;
	}

	/**
	 * Getter for college rank 3
	 * @return rank for college/university that awarded applicant's third degree prior to application to SIS. 
	 */
	public String getCollegeRank3() {
		return collegeRank3;
	}

	/**
	 * Setter for college rank 3
	 * @param collegeRank3 rank for college/university that awarded applicant's third degree prior to application to SIS.
	 */
	public void setCollegeRank3(String collegeRank3) {
		this.collegeRank3 = collegeRank3;
	}

	
	public String getMajor1() {
		return major1;
	}

	public void setMajor1(String major1) {
		this.major1 = major1;
	}

	public String getMajor2() {
		return major2;
	}

	public void setMajor2(String major2) {
		this.major2 = major2;
	}

	public String getMajor3() {
		return major3;
	}

	public void setMajor3(String major3) {
		this.major3 = major3;
	}

	public String getGpa1() {
		return gpa1;
	}

	public void setGpa1(String gpa1) {
		if(gpa1.equalsIgnoreCase("")){
			this.gpa1 = "";
		}
		else{
			this.gpa1 = rangeManager.getStateFromValue("gpa1", Double.parseDouble(gpa1));
		}
	}

	public String getGpa2() {
		return gpa2;
	}

	public void setGpa2(String gpa2) {
		if(gpa2.equalsIgnoreCase("")){
			this.gpa2 = "";
		}
		else{
			this.gpa2 = rangeManager.getStateFromValue("gpa2", Double.parseDouble(gpa2));
		}
	}

	public String getGpa3() {
		return gpa3;
	}

	public void setGpa3(String gpa3) {
		if(gpa3.equalsIgnoreCase("")){
			this.gpa3 = "";
		}
		else{
			this.gpa3 = rangeManager.getStateFromValue("gpa3", Double.parseDouble(gpa3));
		}
	}

	public String getDegree1() {
		return degree1;
	}

	public void setDegree1(String degree1) {
		this.degree1 = degree1;
	}

	public String getDegree2() {
		return degree2;
	}

	public void setDegree2(String degree2) {
		this.degree2 = degree2;
	}

	public String getDegree3() {
		return degree3;
	}

	public void setDegree3(String degree3) {
		this.degree3 = degree3;
	}

	public String getAgeAtSisMatriculation() {
		return ageAtSisMatriculation;
	}

	public void setAgeAtSisMatriculation(String ageAtSisMatriculation) {
		if(ageAtSisMatriculation.equalsIgnoreCase("")){
			this.ageAtSisMatriculation = "";
		}
		else{
			this.ageAtSisMatriculation = rangeManager.getStateFromValue("matriculationAge", Double.parseDouble(ageAtSisMatriculation));
		}
	}

	public String getGpaAtGraduation() {
		return gpaAtGraduation;
	}

	public void setGpaAtGraduation(String gpaAtGraduation) {
		this.gpaAtGraduation = gpaAtGraduation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public String getVerbalScore() {
		return verbalScore;
	}

	public void setVerbalScore(String verbalScore) {
		if(verbalScore.equalsIgnoreCase("")){
			this.verbalScore = "";
		}
		else{
			this.verbalScore = rangeManager.getStateFromValue("verbalGRE", Double.parseDouble(verbalScore));
		}
	}

	public String getQuantatativeScore() {
		return quantatativeScore;
	}

	public void setQuantatativeScore(String quantatativeScore) {
		if(quantatativeScore.equalsIgnoreCase("")){
			this.quantatativeScore = "";
		}
		else{
			this.quantatativeScore = rangeManager.getStateFromValue("quantatativeGRE", Double.parseDouble(quantatativeScore));
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
