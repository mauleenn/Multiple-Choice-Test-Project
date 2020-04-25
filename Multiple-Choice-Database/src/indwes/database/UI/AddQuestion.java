package indwes.database.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import conn.PostgresConn;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddQuestion {

	private JFrame addQuestionFrame;
	
	private JTextField questionTxtField;
	private JTextField answerOneTxtField;
	private JTextField answerTwoTxtField;
	private JTextField answerThreeTxtField;
	private JTextField answerFourTxtField;

	// Getter and Setter for getting to this window
	public JFrame getAddQuestionFrame() {
		return addQuestionFrame;
	}

	public void setAddQuestionFrame(JFrame addQuestionFrame) {
		this.addQuestionFrame = addQuestionFrame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion window = new AddQuestion();
					window.getAddQuestionFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	public AddQuestion() {
		connection = PostgresConn.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setAddQuestionFrame(new JFrame());
		getAddQuestionFrame().setTitle("Add Question");
		getAddQuestionFrame().setBounds(100, 100, 808, 520);
		getAddQuestionFrame().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getAddQuestionFrame().getContentPane().setLayout(null);
		
		JLabel questionLabel = new JLabel("Question:");
		questionLabel.setBounds(37, 49, 70, 15);
		getAddQuestionFrame().getContentPane().add(questionLabel);
		
		questionTxtField = new JTextField();
		questionTxtField.setBounds(116, 24, 589, 65);
		getAddQuestionFrame().getContentPane().add(questionTxtField);
		questionTxtField.setColumns(10);
		
		JLabel answerOneLabel = new JLabel("Correct Answer:");
		answerOneLabel.setBounds(12, 142, 118, 15);
		getAddQuestionFrame().getContentPane().add(answerOneLabel);
		
		JLabel answerTwoLabel = new JLabel("Wrong Answer 1:");
		answerTwoLabel.setBounds(12, 199, 118, 15);
		getAddQuestionFrame().getContentPane().add(answerTwoLabel);
		
		JLabel answerThreeLabel = new JLabel("Wrong answer 2:");
		answerThreeLabel.setBounds(12, 258, 118, 15);
		getAddQuestionFrame().getContentPane().add(answerThreeLabel);
		
		JLabel answerFourLabel = new JLabel("Wrong answer 3:");
		answerFourLabel.setBounds(12, 316, 118, 15);
		getAddQuestionFrame().getContentPane().add(answerFourLabel);
		
		answerOneTxtField = new JTextField();
		answerOneTxtField.setBounds(137, 140, 527, 26);
		getAddQuestionFrame().getContentPane().add(answerOneTxtField);
		answerOneTxtField.setColumns(10);
		
		answerTwoTxtField = new JTextField();
		answerTwoTxtField.setColumns(10);
		answerTwoTxtField.setBounds(137, 194, 527, 26);
		getAddQuestionFrame().getContentPane().add(answerTwoTxtField);
		
		answerThreeTxtField = new JTextField();
		answerThreeTxtField.setColumns(10);
		answerThreeTxtField.setBounds(137, 253, 527, 26);
		getAddQuestionFrame().getContentPane().add(answerThreeTxtField);
		
		answerFourTxtField = new JTextField();
		answerFourTxtField.setColumns(10);
		answerFourTxtField.setBounds(137, 311, 527, 26);
		getAddQuestionFrame().getContentPane().add(answerFourTxtField);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When this button is pressed, the question 
				// should be added to the database and we should
				// see a "success" message.
				add();
			}
		});
		submitButton.setForeground(Color.BLACK);
		submitButton.setBackground(Color.LIGHT_GRAY);
		submitButton.setBounds(351, 386, 117, 25);
		getAddQuestionFrame().getContentPane().add(submitButton);

	}
	public void add() {

		try {
			String Question = questionTxtField.getText();
			String answer1 = answerOneTxtField.getText();
			String answer2 = answerTwoTxtField.getText();
			String answer3 = answerThreeTxtField.getText();
			String answer4 = answerFourTxtField.getText();
			

				
	        String sql = "insert into questions(question)values(?)";  
	        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
	        ps.setString(1, Question);  
	        ps.execute();  


	        ResultSet rs = ps.getGeneratedKeys();
	        int newId = 0;
	        if (rs.next()) {
	        	 newId = rs.getInt(1);
	        }
	            String answerQuery = "insert into answers(id, correct_answer, wrong_answer1, wrong_answer2, wrong_answer3)values((?),?,?,?,?)";  
		        PreparedStatement answerInsert = connection.prepareStatement(answerQuery);  
		        answerInsert.setInt(1, newId);  
		        answerInsert.setString(2, answer1);
		        answerInsert.setString(3, answer2);
		        answerInsert.setString(4, answer3);
		        answerInsert.setString(5, answer4);
		        answerInsert.executeUpdate();  
		        JOptionPane.showMessageDialog(addQuestionFrame, "Added question and answers");
	        
		        ps.close();
		        rs.close();
		

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}

	
