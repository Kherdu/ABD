package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sql.DataSource;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import ABD.abd.Crossword;
import ABD.abd.UIController;
import ABD.abd.User;
import mappers.ActivosMapper;
import mappers.CrosswordMapper;
import mappers.UsuarioMapper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

import java.awt.Color;

public class CrosswordSearchGUI  {

	private JFrame frame;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	private JButton btnBuscar;
	private CrosswordMapper cwm;
	private DefaultListModel list;
	private JList listField;
	private DataSource ds;
	private UsuarioMapper um;
	private User us;
	private ActivosMapper am;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CrosswordSearchGUI(CrosswordMapper c, DataSource ds, ActivosMapper a, User u) {
	
		cwm=c;
		ds = ds;
		am = a;
		us = u;
		
		
		
		

		frame = new JFrame();
		frame.setBounds(100, 100, 772, 482);
		frame.getContentPane().setLayout(null);
		
		 btnBuscar = new JButton("Buscar");
		
		btnBuscar.setBounds(231, 38, 111, 29);
		frame.getContentPane().add(btnBuscar);
		
		textField = new JTextField();
		textField.setBounds(35, 38, 183, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		list=new DefaultListModel();
		ArrayList<Crossword> resultados= cwm.findAll();
		System.out.println(resultados.toString());
		for (Crossword i: resultados){
			list.addElement(i);
		}
		
		listField = new JList(list);
		listField.setBackground(Color.WHITE);
		listField.setToolTipText("Selecciona el crucigrama a añadir");
		listField.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		frame.getContentPane().add(listField);
		
		JButton btnAdd = new JButton("btnAñadir");
		btnAdd.setBounds(465, 41, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		listField = new JList();
		listField.setBounds(104, 105, 450, 297);
	
		
		frame.setVisible(true);
		
		btnBuscar.addMouseListener(new MouseAdapter() {
		
			
			public void mouseClicked(MouseEvent arg0) {
				String e = textField.getText();
				ArrayList<Crossword> resultados= new ArrayList<Crossword>();
				//for now it just only can search for exact match... cant implement search with LIKE instead of WHERE
				/*for(Crossword i: resultados){
				if (!list.contains(i))
				list.addElement(i);
				
			}*/
				Crossword resultado=new Crossword();
				
		
				 
				DefaultListModel lista = new DefaultListModel();
				
				resultados=cwm.findCrosswordsByTitle(e);
				for(Crossword i: resultados){
					i.setUser(us);
					System.out.println(i.toString());
					lista.addElement(i);
					//am.insert(i);
				}
				
				
				
				listField.setModel(lista);
				frame.getContentPane().add(listField);
				frame.repaint();
			}
		});
		
		
		
	}
}

