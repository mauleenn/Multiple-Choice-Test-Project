package indwes.database.UI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount {

	private JFrame createAccountFrame;
	private JTextField usernameTxtField;
	private JPasswordField passwordTxtField;

	// Getter and Setter for accessing this windwo
	public JFrame getCreateAccountFrame() {
		return createAccountFrame;
	}

	public void setCreateAccountFrame(JFrame createAccountFrame) {
		this.createAccountFrame = createAccountFrame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
					window.getCreateAccountFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setCreateAccountFrame(new JFrame());
		getCreateAccountFrame().setTitle("Create Account");
		getCreateAccountFrame().setBounds(100, 100, 504, 322);
		getCreateAccountFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getCreateAccountFrame().getContentPane().setLayout(null);
		
		
	
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(87, 59, 90, 15);
		createAccountFrame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(87, 125, 90, 15);
		createAccountFrame.getContentPane().add(lblPassword);
		
		
		usernameTxtField = new JTextField();
		usernameTxtField.setBounds(215, 50, 166, 34);
		createAccountFrame.getContentPane().add(usernameTxtField);
		usernameTxtField.setColumns(10);
		
		passwordTxtField = new JPasswordField();
		passwordTxtField.setBounds(215, 116, 166, 34);
		createAccountFrame.getContentPane().add(passwordTxtField);
		
		JCheckBox studentChkBox = new JCheckBox("Student");
		studentChkBox.setBounds(70, 161, 90, 23);
		createAccountFrame.getContentPane().add(studentChkBox);
		studentChkBox.setSelected(false);
		
		JCheckBox teacherChkBox = new JCheckBox("Teacher");
		teacherChkBox.setBounds(164, 157, 129, 31);
		createAccountFrame.getContentPane().add(teacherChkBox);
		teacherChkBox.setSelected(false);
		
		JLabel lblCreateAnAccount = new JLabel("Create An Account");
		lblCreateAnAccount.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateAnAccount.setBounds(169, 12, 177, 15);
		createAccountFrame.getContentPane().add(lblCreateAnAccount);
		
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				// If the user checks the "teacher" checkbox, 
				// they will be taken to the Teacher View.
				if(teacherChkBox.isSelected()) {
					TeacherView window = new TeacherView();
					window.getTeacherViewFrame().setVisible(true);
				}
				
				// If the user checks the "student" checkbox, 
				// they will be taken to the Student View.
				else if (studentChkBox.isSelected()) {
					StudentView window = new StudentView();
					window.getStudentViewFrame().setVisible(true);
				}
				else if (usernameTxtField.getText().equals("") || passwordTxtField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You must enter a username or password");
				}
			}
		});
		btnRegister.setBounds(189, 225, 117, 25);
		createAccountFrame.getContentPane().add(btnRegister);
		
		JButton backButton = new JButton("<");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login window = new Login();
				window.getLoginPageFrame().setVisible(true);
			}
		});
		backButton.setBounds(12, 2, 44, 25);
		createAccountFrame.getContentPane().add(backButton);
		
	}
}