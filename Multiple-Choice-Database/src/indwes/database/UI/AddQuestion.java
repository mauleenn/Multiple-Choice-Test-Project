package indwes.database.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
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
	public AddQuestion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setAddQuestionFrame(new JFrame());
		getAddQuestionFrame().setTitle("Add Question");
		getAddQuestionFrame().setBounds(100, 100, 808, 520);
		getAddQuestionFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getAddQuestionFrame().getContentPane().setLayout(null);
		
		JLabel questionLabel = new JLabel("Question:");
		questionLabel.setBounds(37, 49, 70, 15);
		getAddQuestionFrame().getContentPane().add(questionLabel);
		
		questionTxtField = new JTextField();
		questionTxtField.setBounds(116, 24, 589, 65);
		getAddQuestionFrame().getContentPane().add(questionTxtField);
		questionTxtField.setColumns(10);
		
		JLabel answerOneLabel = new JLabel("Answer #1:");
		answerOneLabel.setBounds(37, 142, 93, 15);
		getAddQuestionFrame().getContentPane().add(answerOneLabel);
		
		JLabel answerTwoLabel = new JLabel("Answer #2:");
		answerTwoLabel.setBounds(37, 199, 93, 15);
		getAddQuestionFrame().getContentPane().add(answerTwoLabel);
		
		JLabel answerThreeLabel = new JLabel("Answer #3:");
		answerThreeLabel.setBounds(37, 258, 93, 15);
		getAddQuestionFrame().getContentPane().add(answerThreeLabel);
		
		JLabel answerFourLabel = new JLabel("Answer #4:");
		answerFourLabel.setBounds(37, 316, 93, 15);
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
		
		
		// Checkboxes that determine if an answer is correct
		JCheckBox answerOneCheckBox = new JCheckBox();
		answerOneCheckBox.setBounds(672, 138, 35, 23);
		getAddQuestionFrame().getContentPane().add(answerOneCheckBox);
		
		JCheckBox answerTwoCheckBox = new JCheckBox();
		answerTwoCheckBox.setBounds(672, 195, 35, 23);
		getAddQuestionFrame().getContentPane().add(answerTwoCheckBox);
		
		JCheckBox answerThreeCheckBox = new JCheckBox();
		answerThreeCheckBox.setBounds(672, 254, 35, 23);
		getAddQuestionFrame().getContentPane().add(answerThreeCheckBox);
		
		JCheckBox answerFourCheckBox = new JCheckBox();
		answerFourCheckBox.setBounds(672, 312, 35, 23);
		getAddQuestionFrame().getContentPane().add(answerFourCheckBox);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When this button is pressed, the question 
				// should be added to the database and we should
				// see a "success" message.
			}
		});
		submitButton.setForeground(Color.BLACK);
		submitButton.setBackground(Color.LIGHT_GRAY);
		submitButton.setBounds(351, 386, 117, 25);
		getAddQuestionFrame().getContentPane().add(submitButton);
		
		
		
		
	}
}