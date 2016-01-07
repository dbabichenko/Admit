package edu.pitt.is.admit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Dmitriy Babichenko
 * This is a utility class responsible for processing comma-separated value files (.csv)
 *
 */
public class CsvReader {

	/**
	 * Processes an input file with applicant information.  
	 * Parses each line into a String[] array and stores each array into an ArrayList of applicants 
	 * @param filePath Full physical path to the input file obtained from JFileUploader 
	 * @return ArrayList of applicants (each element of this ArrayList is a String[] array with 
	 * 			a single applicant's information. 
	 */
	public static ArrayList<String[]> processApplicantFile(String filePath) {

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String[]> applicantList = new ArrayList<String[]>();
		try {

			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] applicant = line.split(cvsSplitBy);
				applicantList.add(applicant);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return applicantList;
	}
	
	/**
	 * Assumes that the input file is in comma-separated values (.csv) format.
	 * The input file must only have one column of data. 
	 * @param filePath filePath Full physical path to the input file obtained from JFileUploader
	 * @return A sorted String[] array containing a single applicant's information.
	 */
	public static String[] getListFromFile(String filePath){
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String> tempList = new ArrayList<String>();
		String[] result;
		tempList.add("");
		try {

			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				tempList.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		result = new String[tempList.size()];
		result = tempList.toArray(result);
		Arrays.sort(result);
		return result;
	}
}
