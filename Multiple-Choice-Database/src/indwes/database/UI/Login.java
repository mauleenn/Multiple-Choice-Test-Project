package indwes.database.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conn.PostgresConn;
import net.proteanit.sql.DbUtils;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login {

	private JFrame loginPageFrame;
	private JTextField passwordTxtField;
	private JTextField IDTxtField;

	// Getter and Setter for accessing to this window
	public JFrame getLoginPageFrame() {
		return loginPageFrame;
	}

	public void setLoginPageFrame(JFrame loginPageFrame) {
		this.loginPageFrame = loginPageFrame;
		loginPageFrame.getContentPane().setBackground(SystemColor.activeCaption);
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
	Connection connection = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	public Login() {
		initialize();
		connection = PostgresConn.connect(); // Connecting to the database
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLoginPageFrame(new JFrame());
		getLoginPageFrame().setTitle("Login");
		getLoginPageFrame().setBounds(100, 100, 553, 426);
		getLoginPageFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getLoginPageFrame().getContentPane().setLayout(null);

		// Username label & text field
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(125, 101, 90, 15);
		getLoginPageFrame().getContentPane().add(usernameLabel);

		JTextField usernameTxtField = new JTextField();
		usernameTxtField.setColumns(10);
		usernameTxtField.setBounds(222, 97, 166, 23);
		getLoginPageFrame().getContentPane().add(usernameTxtField);

		// ID label & text field
		JLabel IDLabel = new JLabel("ID:");
		IDLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		IDLabel.setForeground(Color.WHITE);
		IDLabel.setBounds(125, 61, 42, 15);
		getLoginPageFrame().getContentPane().add(IDLabel);

		IDTxtField = new JTextField();
		IDTxtField.setBounds(222, 57, 166, 23);
		getLoginPageFrame().getContentPane().add(IDTxtField);
		IDTxtField.setColumns(10);

		// Password label & text field
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(125, 146, 87, 15);
		getLoginPageFrame().getContentPane().add(passwordLabel);

		passwordTxtField = new JPasswordField();
		((JPasswordField) passwordTxtField).setEchoChar('#');
		passwordTxtField.setBounds(222, 142, 167, 23);
		getLoginPageFrame().getContentPane().add(passwordTxtField);
		passwordTxtField.setColumns(10);

		// Student checkbox
		JCheckBox studentChkBox = new JCheckBox("Student");
		studentChkBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
		studentChkBox.setBackground(SystemColor.activeCaption);
		studentChkBox.setForeground(SystemColor.text);
		studentChkBox.setBounds(138, 182, 71, 23);
		getLoginPageFrame().getContentPane().add(studentChkBox);
		studentChkBox.setSelected(false);

		// Teacher checkbox
		JCheckBox teacherChkBox = new JCheckBox("Teacher");
		teacherChkBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
		teacherChkBox.setBackground(SystemColor.activeCaption);
		teacherChkBox.setForeground(Color.WHITE);
		teacherChkBox.setBounds(217, 178, 78, 31);
		getLoginPageFrame().getContentPane().add(teacherChkBox);
		teacherChkBox.setSelected(false);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = IDTxtField.getText();
				int id = Integer.parseInt(ID);
				String username = usernameTxtField.getText();
				String password = passwordTxtField.getText();

				if (username.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a username!");
				} else if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a password!");
				}
				else if(!studentChkBox.isSelected() && !studentChkBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "You MUST ");
				}
				// If the user checks the 'teacher' checkbox,
				// they are lead to the teacher view
				if (teacherChkBox.isSelected()) {
					try {
						Connection conn = PostgresConn.connect();
						PreparedStatement preparedstm = conn.prepareStatement("SELECT * FROM teacher_login WHERE id=? AND username=? AND password=?");

						preparedstm.setInt(1, id);
						preparedstm.setString(5, username);
						preparedstm.setString(2, password);

						preparedstm.executeQuery();

					} catch (Exception e) {
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(null, "Success!");
					TeacherView window = new TeacherView();
					window.getTeacherViewFrame().setVisible(true);
				}
				// If the user checks the 'student' checkbox,
				// they are lead to the student view
				if (studentChkBox.isSelected()) {
					try {

						Connection conn = PostgresConn.connect();
						PreparedStatement preparedstmA = conn.prepareStatement("SELECT * FROM user_login WHERE id=? AND username=? AND password=?");

						preparedstmA.setInt(1, id);
						preparedstmA.setString(5, username);
						preparedstmA.setString(2, password);

						preparedstmA.executeQuery();

					} catch (Exception e) {
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(null, "Success!");
					StudentView window = new StudentView();
					window.getStudentViewFrame().setVisible(true);
				}

			}
		});
		btnLogin.setBounds(138, 218, 117, 25);
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
		btnSignUp.setBounds(279, 218, 117, 25);
		getLoginPageFrame().getContentPane().add(btnSignUp);

	}

	public void login() {

		try {

			String id = (IDTxtField.getText());
			int ID = Integer.parseInt(id);
			String password = passwordTxtField.getText();

			Connection conn = PostgresConn.connect();
			PreparedStatement preparedstm = conn
					.prepareStatement("SELECT * FROM public.user_login WHERE id=? AND password=?");

			ResultSet rs = preparedstm.executeQuery();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
