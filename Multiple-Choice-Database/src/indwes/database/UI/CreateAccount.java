  
package indwes.database.UI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import conn.PostgresConn;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollBar;

public class CreateTest extends JPanel {
	public CreateTest() {
	} static // Your class name 
	//Connection connection;
	

	JLabel question1Lbl = new JLabel(""); 
	static JLabel answer1Lbl = new JLabel(""); 
	public static void main(String[] args) {
		
		JFrame TestFrame = new JFrame("Take A Test");
		TestFrame.setSize(867, 806);
		TestFrame.setLocation(300, 200);
		TestFrame.getContentPane().setLayout(null);
		
		JLabel Testlbl = new JLabel("This is a Test!");
		Testlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		Testlbl.setBounds(311, 39, 142, 27);
		TestFrame.getContentPane().add(Testlbl);
		
		//JLabel question1Lbl = new JLabel("Q #1");
		question1Lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		question1Lbl.setBounds(89, 191, 646, 64);
		TestFrame.getContentPane().add(question1Lbl);
		
		JLabel qLbl1 = new JLabel("Question 1:");
		qLbl1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		qLbl1.setBounds(89, 151, 268, 27);
		TestFrame.getContentPane().add(qLbl1);
		
	//	JLabel answer1Lbl = new JLabel("Answer 1");
		answer1Lbl.setBounds(89, 268, 350, 16);
		TestFrame.getContentPane().add(answer1Lbl);
		
		JLabel answerLbl2 = new JLabel("Answer 2");
		answerLbl2.setBounds(89, 297, 350, 16);
		TestFrame.getContentPane().add(answerLbl2);
		
		JLabel answer3Lbl = new JLabel("Answer 3");
		answer3Lbl.setBounds(89, 326, 350, 16);
		TestFrame.getContentPane().add(answer3Lbl);
		
		JLabel lblAnswer_1_1 = new JLabel("Answer 4");
		lblAnswer_1_1.setBounds(89, 355, 350, 16);
		TestFrame.getContentPane().add(lblAnswer_1_1);
		TestFrame.setVisible(true);

		Connection connection = PostgresConn.connect();
	
		int id = 3;
				try {
					
					String qSql = "select question from questions where id=3";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(qSql);
					while(rs.next()) {
						question1Lbl.setText(rs.getString("question"));
					}
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					
					String aSql = "select answer from answers where id=3";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(aSql);
					while(rs.next()) {
						answer1Lbl.setText(rs.getString("answer"));
					}
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



	}
}
