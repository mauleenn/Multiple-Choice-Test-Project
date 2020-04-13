import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Canvas;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class MainFrame extends JFrame {
	
	private TeacherView teacherView;
	
	public MainFrame() {
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher View");
		lblNewLabel.setBounds(324, 17, 87, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Questions");
		btnNewButton.setBounds(293, 415, 161, 49);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Questions");
		btnNewButton_1.setBounds(293, 68, 161, 49);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit Questions");
		btnNewButton_2.setBounds(293, 180, 161, 49);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Questions");
		btnNewButton_3.setBounds(293, 305, 161, 50);
		getContentPane().add(btnNewButton_3);
		
				
	}
}
