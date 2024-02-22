package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class likitha {

	private JFrame frame;
	private JTextField tb1;
	private JTextField p1;
	private JTextField tb2;
	private JTextField p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					likitha window = new likitha();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public likitha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton b1 = new JButton("sign in");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user =tb1.getText();
				String password =p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","mrec");
					PreparedStatement stn =con.prepareStatement("select user,password from user where user=? and password=?");
					stn.setString(1, user);
					stn.setString(2, password);
					ResultSet rs=stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(b1, "valid user");
					}
					else
					{
						JOptionPane.showMessageDialog(b1, "invalid user");
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.setBounds(57, 201, 112, 23);
		frame.getContentPane().add(b1);
		
		JLabel lblNewLabel = new JLabel("user");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel.setBounds(44, 57, 73, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPswd = new JLabel("pswd");
		lblPswd.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblPswd.setBounds(44, 110, 73, 26);
		frame.getContentPane().add(lblPswd);
		
		JLabel lblNewLabel_1 = new JLabel("user");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_1.setBounds(259, 62, 73, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPswd_1 = new JLabel("pswd");
		lblPswd_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblPswd_1.setBounds(259, 115, 73, 26);
		frame.getContentPane().add(lblPswd_1);
		
		JButton b2 = new JButton("sign up");
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		b2.setBounds(278, 205, 112, 23);
		frame.getContentPane().add(b2);
		
		tb1 = new JTextField();
		tb1.setBounds(109, 59, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		p1 = new JTextField();
		p1.setColumns(10);
		p1.setBounds(109, 112, 86, 20);
		frame.getContentPane().add(p1);
		
		tb2 = new JTextField();
		tb2.setColumns(10);
		tb2.setBounds(326, 59, 86, 20);
		frame.getContentPane().add(tb2);
		
		p2 = new JTextField();
		p2.setColumns(10);
		p2.setBounds(326, 112, 86, 20);
		frame.getContentPane().add(p2);
	}
}
