package indwes.database.UI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import conn.PostgresConn;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

public class CreateAccount {

	private JFrame createAccountFrame;
	private JTextField IDTxtField;
	private JPasswordField passwordTxtField;
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField usernameTxtField;

	// Getter and Setter for accessing this window
	public JFrame getCreateAccountFrame() {
		return createAccountFrame;
	}

	public void setCreateAccountFrame(JFrame createAccountFrame) {
		this.createAccountFrame = createAccountFrame;
		createAccountFrame.getContentPane().setBackground(SystemColor.activeCaption);
		createAccountFrame.getContentPane().setForeground(Color.DARK_GRAY);
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

	// Database
	Connection connection = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	public CreateAccount() {
		connection = PostgresConn.connect(); // Connecting to the database
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setCreateAccountFrame(new JFrame());
		getCreateAccountFrame().setTitle("Register");
		getCreateAccountFrame().setBounds(100, 100, 553, 426);
		getCreateAccountFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getCreateAccountFrame().getContentPane().setLayout(null);

		// ID label & text field
		JLabel IDLabel = new JLabel("ID # (7 digits):");
		IDLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		IDLabel.setForeground(Color.WHITE);
		IDLabel.setBounds(115, 145, 101, 15);
		createAccountFrame.getContentPane().add(IDLabel);

		IDTxtField = new JTextField();
		IDTxtField.setColumns(10);
		IDTxtField.setBounds(215, 142, 166, 23);
		createAccountFrame.getContentPane().add(IDTxtField);

		// First name label & text field
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		firstNameLabel.setForeground(Color.WHITE);
		firstNameLabel.setBounds(115, 56, 90, 15);
		createAccountFrame.getContentPane().add(firstNameLabel);

		firstNameTxtField = new JTextField();
		firstNameTxtField.setColumns(10);
		firstNameTxtField.setBounds(215, 52, 166, 23);
		createAccountFrame.getContentPane().add(firstNameTxtField);

		// Last name label & text field
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setBounds(115, 99, 90, 15);
		createAccountFrame.getContentPane().add(lastNameLabel);

		lastNameTxtField = new JTextField();
		lastNameTxtField.setColumns(10);
		lastNameTxtField.setBounds(215, 96, 166, 23);
		createAccountFrame.getContentPane().add(lastNameTxtField);

		// Username label & text field
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(115, 188, 90, 15);
		createAccountFrame.getContentPane().add(usernameLabel);

		usernameTxtField = new JTextField();
		usernameTxtField.setColumns(10);
		usernameTxtField.setBounds(215, 185, 166, 23);
		createAccountFrame.getContentPane().add(usernameTxtField);

		// Password label & text field
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(115, 229, 90, 15);
		createAccountFrame.getContentPane().add(passwordLabel);

		passwordTxtField = new JPasswordField();
		passwordTxtField.setColumns(10);
		passwordTxtField.setEchoChar('*');
		passwordTxtField.setBounds(215, 218, 166, 23);
		createAccountFrame.getContentPane().add(passwordTxtField);

		// Student checkbox
		JCheckBox studentChkBox = new JCheckBox("Student");
		studentChkBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
		studentChkBox.setBackground(SystemColor.activeCaption);
		studentChkBox.setForeground(SystemColor.text);
		studentChkBox.setBounds(183, 263, 90, 23);
		createAccountFrame.getContentPane().add(studentChkBox);
		studentChkBox.setSelected(false);

		// Teacher checkbox
		JCheckBox teacherChkBox = new JCheckBox("Teacher");
		teacherChkBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
		teacherChkBox.setBackground(SystemColor.activeCaption);
		teacherChkBox.setForeground(Color.WHITE);
		teacherChkBox.setBounds(110, 259, 79, 31);
		createAccountFrame.getContentPane().add(teacherChkBox);
		teacherChkBox.setSelected(false);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				String firstName = firstNameTxtField.getText();
				String lastName = lastNameTxtField.getText();

				String ID = IDTxtField.getText();
				int id = Integer.parseInt(ID);
				String username = usernameTxtField.getText();
				String password = passwordTxtField.getText();

				if (username.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a username!");
				} else if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a password!");
				} else if (firstName.contentEquals("") || lastName.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "You must enter your name!");
				} else if (checkUsernameForStudent(username)) {
					JOptionPane.showMessageDialog(null, "This username already exists!");
				} else if (checkIDNumberForStudent(id)) {
					JOptionPane.showMessageDialog(null, "This username already exists!");
				} else if (checkUsernameForTeacher(username)) {
					JOptionPane.showMessageDialog(null, "This username already exists!");
				} else if (checkIDNumberForTeacher(id)) {
					JOptionPane.showMessageDialog(null, "This username already exists!");
				} else {

					if (studentChkBox.isSelected()) {
						try {

							Connection conn = PostgresConn.connect();
							PreparedStatement preparedstm = conn
									.prepareStatement("INSERT INTO user_login(id, password, f_name, l_name, username)"
											+ " VALUES (?, ?, ?, ?, ?)");

							preparedstm.setInt(1, id);
							preparedstm.setString(2, password);
							preparedstm.setString(3, firstName);
							preparedstm.setString(4, lastName);
							preparedstm.setString(5, username);

							preparedstm.executeUpdate();

						} catch (Exception e) {
							System.out.println(e);
						}

						JOptionPane.showMessageDialog(null, "Student successfully registered!");
						StudentView window = new StudentView();
						window.getStudentViewFrame().setVisible(true);
					}

					if (teacherChkBox.isSelected()) {
						try {
							Connection conn = PostgresConn.connect();
							PreparedStatement preparedstmA = conn.prepareStatement(
									"INSERT INTO teacher_login(id, password, f_name, l_name, username)"
											+ " VALUES (?, ?, ?, ?, ?)");

							preparedstmA.setInt(1, id);
							preparedstmA.setString(2, password);
							preparedstmA.setString(3, firstName);
							preparedstmA.setString(4, lastName);
							preparedstmA.setString(5, username);

							preparedstmA.executeUpdate();
							conn.close();

						} catch (Exception e) {
							System.out.println(e);
						}
						JOptionPane.showMessageDialog(null, "Teacher successfully registered!");
						TeacherView window = new TeacherView();
						window.getTeacherViewFrame().setVisible(true);
					}
				}
			}
		});
		btnRegister.setBounds(193, 292, 117, 31);
		createAccountFrame.getContentPane().add(btnRegister);
		
		
		// When this button is pressed, the user will
		// go back to the login page.
		JButton backtoLoginButton = new JButton("Go Back to Login ");
		backtoLoginButton.setBackground(SystemColor.controlShadow);
		backtoLoginButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		backtoLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login window = new Login();
				window.getLoginPageFrame().setVisible(true);
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
		toolBar.setBackground(SystemColor.inactiveCaption);
		toolBar.setBounds(0, 0, 558, 31);
		createAccountFrame.getContentPane().add(toolBar);
		toolBar.add(exitButton);
		toolBar.addSeparator(new Dimension(10, 10));
		toolBar.add(backtoLoginButton);
		
	}

	// ************************************************************
	// STUDENT: Checking if the username is already in the database
	// ************************************************************
	public boolean checkUsernameForStudent(String username) {

		PreparedStatement preparedstm;
		ResultSet resultset;
		boolean check = false;

		String query = "SELECT * FROM user_login WHERE username =?";

		try {
			Connection conn = PostgresConn.connect();
			preparedstm = conn.prepareStatement(query);
			preparedstm.setString(1, username);

			resultset = preparedstm.executeQuery();

			if (resultset.next()) {
				check = true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return check;
	}

	// ************************************************************
	// TEACHER: Checking if the username is already in the database
	// ************************************************************
	public boolean checkUsernameForTeacher(String username) {

		PreparedStatement preparedstm;
		ResultSet resultset;
		boolean check = false;

		String query = "SELECT * FROM teacher_login WHERE username =?";

		try {
			Connection conn = PostgresConn.connect();
			preparedstm = conn.prepareStatement(query);
			preparedstm.setString(1, username);

			resultset = preparedstm.executeQuery();

			if (resultset.next()) {
				check = true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return check;
	}

	// ********************************************************
	// STUDENT: Checking if the ID # is already in the database
	// ********************************************************
	public boolean checkIDNumberForStudent(int id) {

		PreparedStatement preparedstm;
		ResultSet resultset;
		boolean check = false;

		String query = "SELECT * FROM user_login WHERE id =?";

		try {
			Connection conn = PostgresConn.connect();
			preparedstm = conn.prepareStatement(query);
			preparedstm.setInt(1, id);

			resultset = preparedstm.executeQuery();

			if (resultset.next()) {
				check = true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return check;
	}

	// ********************************************************
	// TEACHER: Checking if the ID # is already in the database
	// ********************************************************
	public boolean checkIDNumberForTeacher(int id) {

		PreparedStatement preparedstm;
		ResultSet resultset;
		boolean check = false;

		String query = "SELECT * FROM teacher_login WHERE id =?";

		try {
			Connection conn = PostgresConn.connect();
			preparedstm = conn.prepareStatement(query);
			preparedstm.setInt(1, id);

			resultset = preparedstm.executeQuery();

			if (resultset.next()) {
				check = true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return check;
	}

}
