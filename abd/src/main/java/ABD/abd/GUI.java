package ABD.abd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextPane;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * @wbp.nonvisual location=261,349
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Bienvenido");
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 450, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		/**
		 * TextField and Label for User Name
		 * */
		textField = new JTextField();
		textField.setBounds(166, 22, 199, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		lblNewLabel.setBounds(33, 22, 112, 22);
		frame.getContentPane().add(lblNewLabel);
		
		
		/**
		 * PassField and Label for User Password
		 * */
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 63, 199, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(33, 63, 112, 22);
		frame.getContentPane().add(lblContrasea);
		
		
		
		/**
		 * Accept button; get UserName and Pass field and log in, opening the user window and closing this one
		 * 
		 * */
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//change later
				String user = textField.getText();
				char[] pass = passwordField.getPassword();
				
				String passw = pass.toString();
				
				
				//testing, delete later
				JFrame textPane = new JFrame();
				textPane.setBounds(100, 100, 450, 197);

				JLabel test = new JLabel(user + " " +passw);
				textPane.add(test);
				
				textPane.setVisible(true);
			
				System.out.println(user + " " + passw);
				//check
				
				//open new window --> execute game/app/crosswordApp.run()
				
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(78, 114, 123, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		/**
		 * 
		 * Not registred users; close this window and open a window to create the account
		 * 
		 * */
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNuevoUsuario.setBounds(242, 114, 123, 23);
		frame.getContentPane().add(btnNuevoUsuario);
		
		
	}
}
