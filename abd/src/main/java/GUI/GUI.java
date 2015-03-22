package GUI;

import java.awt.EventQueue;

import javax.sql.DataSource;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import mappers.UsuarioMapper;
import ABD.abd.User;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private UsuarioMapper um;
	private User user;

	/**
	 * @wbp.nonvisual location=261,349
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {

		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/Practica1_715");
		cpds.setUser("UsuarioP1");
		cpds.setPassword("");

		cpds.setAcquireRetryAttempts(1);
		cpds.setAcquireRetryDelay(1);
		final DataSource ds = cpds;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					GUI window = new GUI(ds);
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
	public GUI(final DataSource ds) {
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
		 * Accept button; get UserName and Pass field and log in, opening the
		 * user window and closing this one
		 * 
		 * */

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// change later
				UserMenu nug;
				String user = textField.getText();
				char[] pass = passwordField.getPassword();

				String passw = new String(pass);

				System.out.println(user + " " + passw);
				// check

				um = new UsuarioMapper(ds);

				User aux = um.findById(user);

				if (aux == null) {
					System.out.println("Usuario incorrecto");
					// this should be changed to notification window instead of
					// console message
				} else {

					if (aux.getNick().equalsIgnoreCase(user)
							&& aux.getPass().equals(passw)) {
						frame.setVisible(false);

						nug = new UserMenu(ds, aux);

					} else
						System.out.println("Contraseña incorrecta");
					// this should be changed to notification window instead of
					// console message
				}

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
		 * Not registred users; close this window and open a window to create
		 * the account
		 * 
		 * */

		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = textField.getText();
				char[] pass = passwordField.getPassword();

				String passw = new String(pass);

				um = new UsuarioMapper(ds);

				User aux = um.findById(user);

				if (aux == null) {
					aux = new User(user, passw);
					um.insert(aux);
				} else
					System.out.println("Usuario ya en uso");

			}
		});
		btnNuevoUsuario.setBounds(242, 114, 123, 23);
		frame.getContentPane().add(btnNuevoUsuario);

	}

}
