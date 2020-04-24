package indwes.database.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conn.PostgresConn;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class CreateTest {

	private JFrame createTestFrame;
	//JPanel panel = new JPanel();
 static JComboBox comboBoxQ1 = new JComboBox();
 static JComboBox comboBoxQ2 = new JComboBox();
 static JComboBox comboBoxQ3 = new JComboBox();
 
 
static JComboBox comboBoxA1 = new JComboBox();
	public String objectName;
	public String objectType;

	// Getter and Setter for getting to this window
	public JFrame getCreateTestFrame() {
		return createTestFrame;
	}

	public void setCreateTestFrame(JFrame createTestFrame) {
		this.createTestFrame = createTestFrame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					CreateTest window = new CreateTest();
					window.getCreateTestFrame().setVisible(true);
					FillCombo();
					FillComboAnswers();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	 static Connection connection = PostgresConn.connect();
	Statement stmt = null;
	PreparedStatement pstmt = null;

	public CreateTest() {
		connection = PostgresConn.connect();
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setCreateTestFrame(new JFrame());
		getCreateTestFrame().setTitle("Take a test");
		getCreateTestFrame().setBounds(100, 100, 808, 1001);
		getCreateTestFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getCreateTestFrame().getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Take a Test");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(305, 34, 236, 16);
		createTestFrame.getContentPane().add(lblNewLabel);

		//JComboBox comboBoxQ1 = new JComboBox();
		comboBoxQ1 = new JComboBox();
		comboBoxQ1.setBounds(31, 147, 693, 28);
		createTestFrame.getContentPane().add(comboBoxQ1);

		comboBoxA1 = new JComboBox();
		comboBoxA1.setBounds(31, 247, 693, 28);
		createTestFrame.getContentPane().add(comboBoxA1);

		JLabel questionLBL = new JLabel("Question 1:");
		questionLBL.setFont(new Font("Tahoma", Font.BOLD, 15));
		questionLBL.setBounds(326, 102, 122, 16);
		createTestFrame.getContentPane().add(questionLBL);

		JLabel answerLBL = new JLabel("Your Answer");
		answerLBL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerLBL.setBounds(326, 218, 96, 16);
		createTestFrame.getContentPane().add(answerLBL);

		JLabel questionLBL2 = new JLabel("Question 2:");
		questionLBL2.setFont(new Font("Tahoma", Font.BOLD, 15));
		questionLBL2.setBounds(326, 317, 122, 16);
		createTestFrame.getContentPane().add(questionLBL2);

		comboBoxQ2 = new JComboBox();
		comboBoxQ2.setBounds(31, 362, 693, 28);
		createTestFrame.getContentPane().add(comboBoxQ2);

		JLabel answerLBL2 = new JLabel("Your Answer");
		answerLBL2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerLBL2.setBounds(326, 433, 96, 16);
		createTestFrame.getContentPane().add(answerLBL2);

		JComboBox comboBoxA2 = new JComboBox();
		comboBoxA2.setBounds(31, 462, 693, 28);
		createTestFrame.getContentPane().add(comboBoxA2);

		JLabel questionLBL3 = new JLabel("Question 3:");
		questionLBL3.setFont(new Font("Tahoma", Font.BOLD, 15));
		questionLBL3.setBounds(326, 535, 122, 16);
		createTestFrame.getContentPane().add(questionLBL3);

		comboBoxQ3 = new JComboBox();
		comboBoxQ3.setBounds(31, 580, 693, 28);
		createTestFrame.getContentPane().add(comboBoxQ3);

		JLabel answerLBL3 = new JLabel("Your Answer");
		answerLBL3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerLBL3.setBounds(326, 651, 96, 16);
		createTestFrame.getContentPane().add(answerLBL3);

		JComboBox comboBoxA3 = new JComboBox();
		comboBoxA3.setBounds(31, 680, 693, 28);
		createTestFrame.getContentPane().add(comboBoxA3);

	}
private static void FillCombo() {
	try {
		String sql = "select * from questions";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String question = rs.getString("question");
			comboBoxQ1.addItem(question);
			comboBoxQ2.addItem(question);
			comboBoxQ3.addItem(question);
			
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}
}
private static void FillComboAnswers() {
	try {
		String sql = "select correct_answer, wrong_answer1, wrong_answer2, wrong_answer3 from answers";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String answer = rs.getString("correct_answer");
		//	String answer = rs.getString("correct_answer");
			comboBoxA1.addItem(answer);
			
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}
}
	

}
