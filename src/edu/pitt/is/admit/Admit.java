package edu.pitt.is.admit;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import static java.nio.file.StandardCopyOption.*;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

/**
 * Main class
 * @author Dmitriy Babichenko
 *
 */
public class Admit {
	private JFrame admitFrame;
	private JComboBox cboModelList;
	private JButton btnUploadApplicantList;
	private JButton btnAddModel;
	private JPanel modelPanel;
	private JPanel applicantsPanel;
	private JPanel singleApplicantPanel;
	private JButton btnCheckAdmit;
	private JComboBox cboGender;
	private JComboBox cboCollege1;
	private JComboBox cboDegree1;
	private JComboBox cboMajor1;

	private JComboBox cboCollege2;
	private JComboBox cboDegree2;
	private JComboBox cboMajor2;

	private JComboBox cboCollege3;
	private JComboBox cboDegree3;
	private JComboBox cboMajor3;
	
	
	private JTextField txtModelName;
	private JButton btnUploadModelFile;
	
	private JFileChooser fcModelFileChooser;
	private JFileChooser fcApplicantFileChooser;
	private JLabel lblAge;
	private JTextField txtAge;
	private JLabel lblVerbalScore;
	private JTextField txtVerbalScore;
	private JLabel lblQuantitativeScore;
	private JTextField txtQuantitativeScore;
	private JLabel lblGender;
	private JLabel lblCollege2;
	private JTextField txtGpa2;
	private JTextField txtGpa1;
	private JTextField txtGpa3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admit window = new Admit();
					window.admitFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String[] collegeRankings;
		String[] degrees = CsvReader.getListFromFile("data/degrees.csv");
		String[] majors = CsvReader.getListFromFile("data/majors.csv");
		String[] genders = {"M", "F"};
		Arrays.sort(majors);
		admitFrame = new JFrame();
		admitFrame.setBounds(100, 100, 600, 600);
		admitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		admitFrame.getContentPane().setLayout(null);
		
		fcModelFileChooser = new JFileChooser();
		FileNameExtensionFilter modelFilter = new FileNameExtensionFilter("GeNIe Network Files","xdsl");
		fcModelFileChooser.setFileFilter(modelFilter);
		
		fcApplicantFileChooser = new JFileChooser();
		FileNameExtensionFilter applicantFilter = new FileNameExtensionFilter("Comma Separated Values","csv");
		fcApplicantFileChooser.setFileFilter(applicantFilter);
		
		modelPanel = new JPanel();
		modelPanel.setLayout(null);
		modelPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		modelPanel.setBounds(20, 20, 560, 60);
		admitFrame.getContentPane().add(modelPanel);
		
		applicantsPanel = new JPanel();
		applicantsPanel.setLayout(null);
		applicantsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		applicantsPanel.setBounds(20, 100, 560, 60);
		admitFrame.getContentPane().add(applicantsPanel);
		
		singleApplicantPanel = new JPanel();
		singleApplicantPanel.setLayout(null);
		singleApplicantPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		singleApplicantPanel.setBounds(20, 180, 560, 380);
		admitFrame.getContentPane().add(singleApplicantPanel);
		
		JLabel lblApplicantInformation = new JLabel("Applicant Information");
		lblApplicantInformation.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblApplicantInformation.setBounds(10, 10, 185, 20);
		singleApplicantPanel.add(lblApplicantInformation);
		
		lblAge = new JLabel("Age at matriculation:");
		lblAge.setBounds(20, 46, 150, 20);
		singleApplicantPanel.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(163, 42, 67, 28);
		singleApplicantPanel.add(txtAge);
		txtAge.setColumns(10);
		
		lblVerbalScore = new JLabel("Verbal score:");
		lblVerbalScore.setBounds(20, 114, 150, 20);
		singleApplicantPanel.add(lblVerbalScore);
		
		txtVerbalScore = new JTextField();
		txtVerbalScore.setColumns(10);
		txtVerbalScore.setBounds(163, 110, 67, 28);
		singleApplicantPanel.add(txtVerbalScore);
		
		lblQuantitativeScore = new JLabel("Quantitative score:");
		lblQuantitativeScore.setBounds(20, 150, 150, 20);
		singleApplicantPanel.add(lblQuantitativeScore);
		
		txtQuantitativeScore = new JTextField();
		txtQuantitativeScore.setColumns(10);
		txtQuantitativeScore.setBounds(163, 146, 67, 28);
		singleApplicantPanel.add(txtQuantitativeScore);
		
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(20, 82, 150, 20);
		singleApplicantPanel.add(lblGender);
		
		lblCollege2 = new JLabel("College Ranking 2:");
		lblCollege2.setBounds(289, 42, 150, 20);
		singleApplicantPanel.add(lblCollege2);
		
		cboGender = new JComboBox(genders);
		cboGender.setBounds(163, 78, 67, 27);
		singleApplicantPanel.add(cboGender);
		
		cboCollege2 = new JComboBox();
		cboCollege2.setBounds(419, 39, 122, 27);
		singleApplicantPanel.add(cboCollege2);
		
		JLabel lblMajor2 = new JLabel("Major 2:");
		lblMajor2.setBounds(289, 77, 150, 20);
		singleApplicantPanel.add(lblMajor2);
		
		cboMajor2 = new JComboBox(majors);
		cboMajor2.setBounds(419, 74, 122, 27);
		singleApplicantPanel.add(cboMajor2);
		
		JLabel lblDegree2 = new JLabel("Degree 2:");
		lblDegree2.setBounds(289, 110, 150, 20);
		singleApplicantPanel.add(lblDegree2);
		
		cboDegree2 = new JComboBox(degrees);
		cboDegree2.setBounds(419, 107, 122, 27);
		singleApplicantPanel.add(cboDegree2);
		
		JLabel lblGpa2 = new JLabel("GPA 2:");
		lblGpa2.setBounds(289, 150, 150, 20);
		singleApplicantPanel.add(lblGpa2);
		
		txtGpa2 = new JTextField();
		txtGpa2.setColumns(10);
		txtGpa2.setBounds(419, 146, 67, 28);
		singleApplicantPanel.add(txtGpa2);
		
		JLabel lblCollege1 = new JLabel("College Ranking 1:");
		lblCollege1.setBounds(20, 202, 150, 20);
		singleApplicantPanel.add(lblCollege1);
		
		cboCollege1 = new JComboBox();
		cboCollege1.setBounds(157, 199, 122, 27);
		singleApplicantPanel.add(cboCollege1);
		
		JLabel lblMajor1 = new JLabel("Major 1:");
		lblMajor1.setBounds(20, 237, 150, 20);
		singleApplicantPanel.add(lblMajor1);
		
		cboMajor1 = new JComboBox(majors);
		cboMajor1.setBounds(157, 234, 122, 27);
		singleApplicantPanel.add(cboMajor1);
		
		JLabel lblDegree1 = new JLabel("Degree 1:");
		lblDegree1.setBounds(20, 270, 150, 20);
		singleApplicantPanel.add(lblDegree1);
		
		cboDegree1 = new JComboBox(degrees);
		cboDegree1.setBounds(157, 267, 122, 27);
		singleApplicantPanel.add(cboDegree1);
		
		JLabel lblGpa1 = new JLabel("GPA 1:");
		lblGpa1.setBounds(20, 310, 150, 20);
		singleApplicantPanel.add(lblGpa1);
		
		txtGpa1 = new JTextField();
		txtGpa1.setColumns(10);
		txtGpa1.setBounds(157, 306, 67, 28);
		singleApplicantPanel.add(txtGpa1);
		
		JLabel lblCollege3 = new JLabel("College Ranking 3:");
		lblCollege3.setBounds(289, 205, 150, 20);
		singleApplicantPanel.add(lblCollege3);
		
		cboCollege3 = new JComboBox();
		cboCollege3.setBounds(419, 202, 122, 27);
		singleApplicantPanel.add(cboCollege3);
		
		JLabel lblMajor3 = new JLabel("Major 3:");
		lblMajor3.setBounds(289, 240, 150, 20);
		singleApplicantPanel.add(lblMajor3);
		
		cboMajor3 = new JComboBox(majors);
		cboMajor3.setBounds(419, 237, 122, 27);
		singleApplicantPanel.add(cboMajor3);
		
		JLabel lblDegree3 = new JLabel("Degree 3:");
		lblDegree3.setBounds(289, 273, 150, 20);
		singleApplicantPanel.add(lblDegree3);
		
		cboDegree3 = new JComboBox(degrees);
		cboDegree3.setBounds(419, 270, 67, 27);
		singleApplicantPanel.add(cboDegree3);
		
		JLabel lblGpa3 = new JLabel("GPA 3:");
		lblGpa3.setBounds(289, 313, 150, 20);
		singleApplicantPanel.add(lblGpa3);
		
		txtGpa3 = new JTextField();
		txtGpa3.setColumns(10);
		txtGpa3.setBounds(419, 309, 67, 28);
		singleApplicantPanel.add(txtGpa3);
		
		btnCheckAdmit = new JButton("To admit or not to admit?  That is the question...");
		btnCheckAdmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processApplicant();
			}
		});
		btnCheckAdmit.setBounds(196, 345, 345, 29);
		singleApplicantPanel.add(btnCheckAdmit);
		
		
		JLabel lblModel = new JLabel("Select model:");
		lblModel.setBounds(10, 20, 160, 20);
		modelPanel.add(lblModel);
		
		JLabel lblApplicantList = new JLabel("Upload applicant list:");
		lblApplicantList.setBounds(10, 15, 160, 30);
		applicantsPanel.add(lblApplicantList);
		
		
		cboModelList = new JComboBox(listFilesForFolder("models/", "xdsl"));
		cboModelList.setBounds(110, 15, 270, 30);
		modelPanel.add(cboModelList);
		
		btnUploadApplicantList = new JButton("Upload and Analyze");
		btnUploadApplicantList.setBounds(168, 16, 200, 30);
		btnUploadApplicantList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fcApplicantFileChooser.showOpenDialog(admitFrame);
				File selectedFile = fcApplicantFileChooser.getSelectedFile();
				// System.out.println(selectedFile.getAbsolutePath());
				if(selectedFile != null){
					File targetFile = new File("applicants/" + selectedFile.getName());
					try {
						if(targetFile.exists()){
							targetFile.delete();
						}
						Files.copy(selectedFile.toPath(), targetFile.toPath());
						processApplicants(selectedFile.getName());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		applicantsPanel.add(btnUploadApplicantList);
		
		btnAddModel = new JButton("Add model");
		btnAddModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// initModelUpload();
				int returnVal = fcModelFileChooser.showOpenDialog(admitFrame);
				File selectedFile = fcModelFileChooser.getSelectedFile();
				// System.out.println(selectedFile.getAbsolutePath());
				if(selectedFile != null){
					File targetFile = new File("models/" + selectedFile.getName());
					try {
						Files.copy(selectedFile.toPath(), targetFile.toPath());
						cboModelList.addItem(selectedFile.getName());
						JOptionPane.showMessageDialog(admitFrame, "Succesfully uploaded model");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnAddModel.setBounds(380, 15, 120, 30);
		modelPanel.add(btnAddModel);
		
		
		
		
	}
	
	private String[] listFilesForFolder(String folderPath, String extension) {
		File sourceFolder = new File(folderPath);
		ArrayList<String> fileList = new ArrayList<String>();
	    for (final File fileEntry : sourceFolder.listFiles()) {
	    	if(fileEntry.getName().indexOf("." + extension) != -1){
	    		fileList.add(fileEntry.getName());
	    	}
	    }
	    String[] ret = new String[fileList.size()];
	    fileList.toArray(ret);
	    return ret;
	}

	
	private void processApplicants(String fileName){
		String applicantFilePath = "applicants/" + fileName;
		String modelFilePath = "models/" + cboModelList.getSelectedItem().toString();
		String rangesFilePath = "config/" + cboModelList.getSelectedItem().toString() + ".xml";
		
		ArrayList<String[]> applicantList = CsvReader.processApplicantFile(applicantFilePath);
		
		RangeManager rm = new RangeManager(rangesFilePath);
		Inference inf = new Inference(modelFilePath, applicantList, rm);
	}
	
	private void processApplicant(){
		String modelFilePath = "models/" + cboModelList.getSelectedItem().toString();
		String rangesFilePath = "config/" + cboModelList.getSelectedItem().toString() + ".xml";
		
		RangeManager rm = new RangeManager(rangesFilePath);
		// Need a better way to generate IDs for applicants and to store log data for future research.
		Applicant applicant = new Applicant("", rm);
		
		
		Inference inf = new Inference(modelFilePath, applicant, rm);
		
	}
}
