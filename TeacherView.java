package indwes.database.UI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherView {

	private JFrame teacherViewFrame;
	private JTable table;
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
	public TeacherView() {
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
		
	}
}
