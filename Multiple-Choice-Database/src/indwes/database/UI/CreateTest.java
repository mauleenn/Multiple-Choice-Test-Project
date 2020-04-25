package indwes.database.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import conn.PostgresConn;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CreateTest {

	private JFrame createTestFrame;
	// JPanel panel = new JPanel();
	static JComboBox comboBoxQ1 = new JComboBox();
	static JComboBox comboBoxQ2 = new JComboBox();
	static JComboBox comboBoxQ3 = new JComboBox();

	static JComboBox comboBoxA1 = new JComboBox();
	static JComboBox comboBoxA2 = new JComboBox();
	static JComboBox comboBoxA3 = new JComboBox();
	static JComboBox comboBoxA4 = new JComboBox();

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
					FillComboAnswersA();
					FillComboAnswersB();
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
		getCreateTestFrame().setBounds(100, 100, 808, 769);
		getCreateTestFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getCreateTestFrame().getContentPane().setLayout(null);

		// Take a Test Label
		JLabel lblNewLabel = new JLabel("Take a Test");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(305, 34, 236, 16);
		createTestFrame.getContentPane().add(lblNewLabel);

		// ******************************************
		// QUESTION/ANSWER #1: Label and combo-box
		// ******************************************

		JLabel questionLBL = new JLabel("Question 1:");
		questionLBL.setFont(new Font("Tahoma", Font.BOLD, 15));
		questionLBL.setBounds(326, 102, 122, 16);
		createTestFrame.getContentPane().add(questionLBL);

		JLabel answerLBL = new JLabel("Your Answer");
		answerLBL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerLBL.setBounds(326, 218, 96, 16);
		createTestFrame.getContentPane().add(answerLBL);

		comboBoxQ1 = new JComboBox();
		comboBoxQ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Do something
			}
		});
		comboBoxQ1.setBounds(31, 147, 693, 28);
		createTestFrame.getContentPane().add(comboBoxQ1);

		comboBoxA1 = new JComboBox();
		comboBoxA1.setBounds(31, 247, 693, 28);
		createTestFrame.getContentPane().add(comboBoxA1);

		// ******************************************
		// QUESTION/ANSWER #2: Label and combo-box
		// ******************************************

		JLabel questionLBL2 = new JLabel("Question 2:");
		questionLBL2.setFont(new Font("Tahoma", Font.BOLD, 15));
		questionLBL2.setBounds(326, 317, 122, 16);
		createTestFrame.getContentPane().add(questionLBL2);

		JLabel answerLBL2 = new JLabel("Your Answer");
		answerLBL2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerLBL2.setBounds(326, 433, 96, 16);
		createTestFrame.getContentPane().add(answerLBL2);

		comboBoxQ2 = new JComboBox();
		comboBoxQ2.setBounds(31, 362, 693, 28);
		createTestFrame.getContentPane().add(comboBoxQ2);

		comboBoxA2 = new JComboBox();
		comboBoxA2.setBounds(31, 462, 693, 28);
		createTestFrame.getContentPane().add(comboBoxA2);

		// ******************************************
		// QUESTION/ANSWER #3: Label and combo-box
		// ******************************************

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

		comboBoxA3 = new JComboBox();
		comboBoxA3.setBounds(31, 680, 693, 28);
		createTestFrame.getContentPane().add(comboBoxA3);

		// When this button is pressed, the user will
		// go back to the l		
		JButton createTestButton = new JButton("Create Test!");
		createTestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sorry :( We didn't get it.");
			}
		});
		createTestButton.setBounds(335, 679, 85, 21);
		createTestFrame.getContentPane().add(createTestButton);
		JButton backtoLoginButton = new JButton("Go Back to Teacher View ");
		backtoLoginButton.setBackground(SystemColor.controlShadow);
		backtoLoginButton.setFont(new Font("Times New Roman", Font.BOLD, 13));

		backtoLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TeacherView window = new TeacherView();
				window.getTeacherViewFrame().setVisible(true);
			}
		});
		JButton exitButton = new JButton("  Exit   ");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("Dialog", Font.BOLD, 13));
		exitButton.setBackground(SystemColor.controlShadow);

		// Toolbar with the 'exit' button and the 'login' button
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		toolBar.setBounds(0, 0, 994, 31);
		createTestFrame.getContentPane().add(toolBar);
		toolBar.add(exitButton);
		toolBar.addSeparator(new Dimension(10, 10));
		toolBar.add(backtoLoginButton);

	}

	private static void FillCombo() {
		try {
			String sql = "select * from questions";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
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

			String sql = "SELECT * FROM answers INNER JOIN questions ON answers.id=questions.id WHERE answers.id=questions.id";
			PreparedStatement pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String answer = rs.getString("correct_answer");
				String wanswer1 = rs.getString("wrong_answer1");
				String wanswer2 = rs.getString("wrong_answer2");
				String wanswer3 = rs.getString("wrong_answer3");

				// Answer #1
				comboBoxA1.addItem(wanswer1);
				comboBoxA1.addItem(wanswer2);
				comboBoxA1.addItem(answer);
				comboBoxA1.addItem(wanswer3);

				comboBoxA1 = comboBoxQ1;

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void FillComboAnswersA() {
		try {

			String sql = "SELECT * FROM answers INNER JOIN questions ON answers.id=questions.id WHERE answers.id=questions.id";
			PreparedStatement pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String answer = rs.getString("correct_answer");
				String wanswer1 = rs.getString("wrong_answer1");
				String wanswer2 = rs.getString("wrong_answer2");
				String wanswer3 = rs.getString("wrong_answer3");

				// Answer #1
				comboBoxA2.addItem(wanswer1);
				comboBoxA2.addItem(wanswer2);
				comboBoxA2.addItem(answer);
				comboBoxA2.addItem(wanswer3);

				comboBoxA2 = comboBoxQ2;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void FillComboAnswersB() {
		try {

			String sql = "SELECT * FROM answers INNER JOIN questions ON answers.id=questions.id WHERE answers.id=questions.id";
			PreparedStatement pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String answer = rs.getString("correct_answer");
				String wanswer1 = rs.getString("wrong_answer1");
				String wanswer2 = rs.getString("wrong_answer2");
				String wanswer3 = rs.getString("wrong_answer3");

				// Answer #3
				comboBoxA3.addItem(wanswer1);
				comboBoxA3.addItem(wanswer2);
				comboBoxA3.addItem(wanswer3);
				comboBoxA3.addItem(answer);

				comboBoxA3 = comboBoxQ3;

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
