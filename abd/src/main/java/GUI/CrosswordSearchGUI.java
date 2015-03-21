package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import mappers.CrosswordMapper;

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
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CrosswordSearchGUI(CrosswordMapper c) {
		initialize();
		cwm=c;
	}
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		 btnBuscar = new JButton("Buscar");
		
		btnBuscar.setBounds(231, 38, 111, 29);
		frame.getContentPane().add(btnBuscar);
		
		textField = new JTextField();
		textField.setBounds(35, 38, 183, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		list=new DefaultListModel();
		listField = new JList(list);
		listField.setBackground(Color.WHITE);
		listField.setToolTipText("Selecciona el crucigrama a añadir");
		listField.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		frame.getContentPane().add(listField);
		
		JButton btnAdd = new JButton("btnAñadir");
		btnAdd.setBounds(335, 205, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		frame.setVisible(true);
		
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String e = textField.getText();
				//ArrayList<Crossword> resultados= new ArrayList<Crossword>();
				//for now it just only can search for exact match... cant implement search with LIKE instead of WHERE
				/*for(Crossword i: resultados){
				if (!list.contains(i))
				list.addElement(i);
				
			}*/
				Crossword resultado=new Crossword();
				resultado=cwm.findById(e);
				
				System.out.println(resultado.toString());
				listField.setModel(list);
				frame.add(listField,BorderLayout.SOUTH);
			}
		});
		
	}
}

