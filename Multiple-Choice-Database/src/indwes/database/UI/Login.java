package indwes.database.UI;

import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame loginPageFrame;
	private JTextField passwordTxtField;

	// Getter and Setter for accessing to this window
	public JFrame getLoginPageFrame() {
		return loginPageFrame;
	}

	public void setLoginPageFrame(JFrame loginPageFrame) {
		this.loginPageFrame = loginPageFrame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.getLoginPageFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLoginPageFrame(new JFrame());
		getLoginPageFrame().setTitle("Login");
		getLoginPageFrame().setBounds(100, 100, 519, 323);
		getLoginPageFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getLoginPageFrame().getContentPane().setLayout(null);
		
		

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(80, 65, 90, 15);
		getLoginPageFrame().getContentPane().add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(83, 113, 87, 15);
		getLoginPageFrame().getContentPane().add(passwordLabel);

		JTextField usernameTxtField = new JTextField();
		usernameTxtField.setBounds(212, 57, 192, 31);
		getLoginPageFrame().getContentPane().add(usernameTxtField);
		usernameTxtField.setColumns(10);
		
		passwordTxtField = new JPasswordField();
		((JPasswordField) passwordTxtField).setEchoChar('#');
		passwordTxtField.setBounds(212, 120, 192, 31);
		getLoginPageFrame().getContentPane().add(passwordTxtField);
		passwordTxtField.setColumns(10);
		
		JCheckBox studentChkBox = new JCheckBox("Student");
		studentChkBox.setBounds(70, 161, 90, 23);
		getLoginPageFrame().getContentPane().add(studentChkBox);
		studentChkBox.setSelected(false);
		
		JCheckBox teacherChkBox = new JCheckBox("Teacher");
		teacherChkBox.setBounds(164, 157, 129, 31);
		getLoginPageFrame().getContentPane().add(teacherChkBox);
		teacherChkBox.setSelected(false);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
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
		btnLogin.setBounds(108, 214, 117, 25);
		getLoginPageFrame().getContentPane().add(btnLogin);
		
		// If the user does not have an account,
		// they will be taken to the "Sign Up"
		// page.
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateAccount window = new CreateAccount();
				window.getCreateAccountFrame().setVisible(true);
			}
		});
		btnSignUp.setBounds(278, 214, 117, 25);
		getLoginPageFrame().getContentPane().add(btnSignUp);
		
		
	}
}