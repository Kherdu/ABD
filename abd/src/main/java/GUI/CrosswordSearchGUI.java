package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sql.DataSource;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import ABD.abd.Crossword;

import ABD.abd.User;
import mappers.ActivosMapper;
import mappers.CrosswordMapper;
import mappers.UsuarioMapper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

import java.awt.Color;

public class CrosswordSearchGUI {

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
	private DefaultListModel listaMenu;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param lista 
	 */
	public CrosswordSearchGUI(CrosswordMapper c, DataSource ds,
			ActivosMapper a, User u, DefaultListModel listamenu) {

		cwm = c;
		ds = ds;
		am = a;
		us = u;
		listaMenu = listamenu;

		frame = new JFrame();
		frame.setBounds(100, 100, 772, 482);
		frame.getContentPane().setLayout(null);

		btnBuscar = new JButton("Buscar");

		btnBuscar.setBounds(293, 38, 111, 29);
		frame.getContentPane().add(btnBuscar);

		textField = new JTextField();
		textField.setBounds(35, 38, 248, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		list = new DefaultListModel();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 385, 448, -282);
		frame.getContentPane().add(scrollPane);
		
		listField = new JList(list);
		scrollPane.setViewportView(listField);
		
		listField.setBackground(Color.WHITE);
		listField.setToolTipText("Selecciona el crucigrama a añadir");
		listField.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listField.setModel(list);
		frame.repaint();
		JButton btnAdd = new JButton("Añadir");

		btnAdd.setBounds(465, 38, 100, 29);
		frame.getContentPane().add(btnAdd);

		listField = new JList();
		listField.setBounds(104, 105, 450, 297);

		frame.setVisible(true);

		btnBuscar.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				String e = textField.getText();
				ArrayList<Crossword> resultados = new ArrayList<Crossword>();

				Crossword resultado = new Crossword();
				list.clear();
				resultados = cwm.findCrosswordsByTitle(e);
				for (Crossword i : resultados) {
					i.setUser(us);
					//System.out.println(i.toString());
					list.addElement(i);

				}

				listField.setModel(list);
				frame.getContentPane().add(listField);
				frame.repaint();
			}
		});

		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Crossword selected = new Crossword();
				selected = (Crossword) listField.getSelectedValue();
				if (selected != null) {
					if (am.findByUserAndCrossword(us, selected)) {
						// error msg , probably advice window
						String error = "Crucigrama ya activo";
						System.out.println(error);
						JOptionPane.showMessageDialog(new JFrame(), error, "Dialog",
						        JOptionPane.ERROR_MESSAGE);


					} else
					{
						am.insert(selected);
						listaMenu.addElement(selected);
					}

				}
			}
		});

	}
}
