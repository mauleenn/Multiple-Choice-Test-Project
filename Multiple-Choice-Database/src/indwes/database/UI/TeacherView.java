package indwes.database.UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import conn.PostgresConn;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
public class TeacherView {

	private JFrame teacherViewFrame;
	private JTable table;
	
	public JFrame getTeacherViewFrame() {
		return teacherViewFrame;
	}
	
	public void setTeacherViewFrame(JFrame teacherViewFrame) {
		this.teacherViewFrame = teacherViewFrame;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherView window = new TeacherView();
					window.teacherViewFrame.setVisible(true);
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
	
	public TeacherView() {
		connection = PostgresConn.connect(); // Connecting to the database
		initialize();
	}

	/**
	 * Initialize the contents of the teacherViewFrame.
	 */
	private void initialize() {
		teacherViewFrame = new JFrame();
		teacherViewFrame.setTitle("Teacher View");
		teacherViewFrame.setBounds(100, 100, 808, 520);
		teacherViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teacherViewFrame.getContentPane().setLayout(null);
		
		JButton viewQuestionsButton = new JButton("View");
		viewQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When the "view" button is pressed, we will
				// be able to view all the questions in the
				// database.
				view();
			}
		});
		viewQuestionsButton.setBounds(655, 37, 117, 31);
		teacherViewFrame.getContentPane().add(viewQuestionsButton);
		
		JButton addQuestionsButton = new JButton("Add");
		addQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When the add button is pressed, a new window 
				// will pop out and it will allow us to add a new
				// question with four answers. The correct answer
				// will be checked. When the teacher is finished
				// adding the new question, they will press "add"
				// then a success message will show up.
				
				AddQuestion window = new AddQuestion();
				window.getAddQuestionFrame().setVisible(true);
			}
		});
		addQuestionsButton.setBounds(268, 37, 117, 31);
		teacherViewFrame.getContentPane().add(addQuestionsButton);
		
		JButton editQuestionsButton = new JButton("Edit");
		editQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When the "edit" button is pressed, a new window
				// will pop out and it will allow us to edit a 
				// question and the four answers listed. We can
				// change the answers and the question. When the 
				// teacher is finished editing the new question, 
				// they will press "submit" then a success message
				// will show up.
				removeEdit();
				AddQuestion window = new AddQuestion();
				window.getAddQuestionFrame().setVisible(true);
			}
		});
		editQuestionsButton.setBounds(526, 37, 117, 31);
		teacherViewFrame.getContentPane().add(editQuestionsButton);
		
		JButton removeQuestionsButton = new JButton("Remove");
		removeQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Teacher has to press on an exisiting question
				// on the table then they press the remove button.
				// When the question is removed from the table,
				// it is also removed from the database.
				remove();
			}
		});
		removeQuestionsButton.setBounds(397, 37, 117, 31);
		teacherViewFrame.getContentPane().add(removeQuestionsButton);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 101, 743, 377);
		teacherViewFrame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// Row names for the table (Question ID, Question Name, and the Correct Answer
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Question ID", "Question Name", "Correct Answer" }));
		
		
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
				toolBar.setBackground(UIManager.getColor("InternalFrame.borderLight"));
				toolBar.setBounds(0, 0, 794, 31);
				teacherViewFrame.getContentPane().add(toolBar);
				toolBar.add(exitButton);
				toolBar.addSeparator(new Dimension(10, 10));
				toolBar.add(backtoLoginButton);
	}

	// *****************************************************
	// VIEW QUESTIONS METHOD
	// *****************************************************
	public boolean view() {
		boolean status = false;
		
		try {
		Connection conn = PostgresConn.connect();
		PreparedStatement preparedstm = conn.prepareStatement("SELECT * FROM questions");
		
		
		
		ResultSet rs = preparedstm.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		status = rs.next();
		conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
		
		}
	
	public void remove() {
		int row = table.getSelectedRow();
		String cell = table.getModel().getValueAt(row, 0).toString();
		
		String sql = "DELETE FROM questions WHERE id = " + cell;
		
	//	DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			JOptionPane.showMessageDialog(teacherViewFrame, "Question removed.");
			updateTable();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void removeEdit() {
		int row = table.getSelectedRow();
		String cell = table.getModel().getValueAt(row, 0).toString();
		
		String sql = "DELETE FROM questions WHERE id = " + cell;
		
	//	DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			updateTable();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void updateTable() {

		try {
			String sql = "select * from questions";
			PreparedStatement pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
	

	
	
	
	
	
	
	
	/*public void edit() {
		String sql = "UPDATE questions SET "
	}
		/*try {
		int SelectedRowIndex = table.getSelectedRow();
		model.removeRow(SelectedRowIndex);
		
		
		} catch(Exception e) {
			System.out.println(e);
		}
		
		/*
		
		try {
		
		connection = PostgresConn.connect();
		pstmt = connection.prepareStatement("DELETE FROM questions WHERE id = ?");

		pstmt.setInt(1, bookID);
		pstmt.executeUpdate();
		connection.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	

		String ID = bookIDTxtField.getText();
		int bookID = Integer.parseInt(ID);

		int row = table.getSelectedRow();
		if (row != -1) {
			int modelRow = table.convertRowIndexToModel(row);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String selected = model.getValueAt(row, 0).toString();
			model.removeRow(modelRow);

			int x = LibraryDao.removeBook(bookID);

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Book has been successfully deleted!");
			}
		}
		clearFields();
	}*/
