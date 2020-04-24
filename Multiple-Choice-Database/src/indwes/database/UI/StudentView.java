package indwes.database.UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentView {

	private JFrame studentViewFrame;
	private JTable table;
	
	public JFrame getStudentViewFrame() {
		return studentViewFrame;
	}
	
	public void setStudentViewFrame(JFrame studentViewFrame) {
		this.studentViewFrame = studentViewFrame;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView window = new StudentView();
					window.studentViewFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView window = new StudentView();
					window.studentViewFrame.setVisible(true);
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
	public StudentView() {
		connection = PostgresConn.connect();
		initialize();
		select();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		studentViewFrame = new JFrame();
		studentViewFrame.setTitle("Student View");
		studentViewFrame.setBounds(100, 100, 808, 520);
		studentViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentViewFrame.getContentPane().setLayout(null);
		
		
		

		JButton removeQuestionsButton = new JButton("Select");
		removeQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Teacher has to press on an exisiting question
				// on the table then they press the 'select' button.
				// This will open another window in which they can
				// take the test.
				
				CreateTest window = new CreateTest();
				window.getCreateTestFrame().setVisible(true);
			}
		});
		removeQuestionsButton.setBounds(667, 447, 117, 31);
		studentViewFrame.getContentPane().add(removeQuestionsButton);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 58, 743, 377);
		studentViewFrame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// Row names for the table (Question ID, Question Name, and the Correct Answer)
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Test Name", "question id", "answer id","Status", "Grade" }));
	}

	public void select() {
		try {
			
		boolean bool = false;
		
		Connection conn = PostgresConn.connect();
		PreparedStatement preparedstm = conn.prepareStatement("SELECT * FROM public.test");


		ResultSet rs = preparedstm.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		conn.close();
		}
		catch(Exception e) {
		System.out.println(e);
		}
		}
}


		});
	}

	/**
	 * Create the application.
	 */
	public StudentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		studentViewFrame = new JFrame();
		studentViewFrame.setTitle("Student View");
		studentViewFrame.setBounds(100, 100, 808, 520);
		studentViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentViewFrame.getContentPane().setLayout(null);
		
		
		

		JButton removeQuestionsButton = new JButton("Select");
		removeQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Teacher has to press on an exisiting question
				// on the table then they press the 'select' button.
				// This will open another window in which they can
				// take the test.
			}
		});
		removeQuestionsButton.setBounds(667, 447, 117, 31);
		studentViewFrame.getContentPane().add(removeQuestionsButton);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 58, 743, 377);
		studentViewFrame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// Row names for the table (Question ID, Question Name, and the Correct Answer)
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Test Name", "Status", "Grade" }));
	}

}
