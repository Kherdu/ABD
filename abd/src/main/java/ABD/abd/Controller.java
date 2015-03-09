package ABD.abd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;


public class Controller {

	
	private Scanner in;
	private User u;
	private UserInterface ui;
	
	public Controller(){
		
		
		
	}
	/*
	 * Interface generator
	 * 
	 * First login, then show user window, otherwise show error
	 * Can create new users
	 */
	public void run(){
		/*
		JFrame win= new JFrame();
		win= ui.Loginwindow();
		*/
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/practica1_715","root", "");
				Statement st = con.createStatement()) {
				try (ResultSet rs =
				st.executeQuery("SELECT Usuario FROM usuario")) {
				while (rs.next()) {
				System.out.println(rs.getString("Usuario"));
					}
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

	
	
	
	
}
