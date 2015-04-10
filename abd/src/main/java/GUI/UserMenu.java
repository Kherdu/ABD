package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.swing.JFrame;

import ABD.abd.Crossword;
import ABD.abd.Friends;
import ABD.abd.User;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JComboBox;

import mappers.ActivosMapper;
import mappers.AmigosMapper;
import mappers.CrosswordMapper;
import mappers.UsuarioMapper;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

public class UserMenu {

	private JFrame frame;

	private CrosswordMapper cm;
	private ActivosMapper am;
	private User user;
	private DefaultListModel lista;
	private DefaultListModel listaForFriends;
	private AmigosMapper amigosm;
	private JList listForFriends;
	private JTextField textField;
	private UsuarioMapper um;
	private JTable table;
	public UserMenu(final DataSource ds, final User user) {

		this.user = user;

		frame = new JFrame();
		frame.setBounds(100, 100, 737, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(111, 97, 488, 308);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Crucigramas", null, panel, null);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Amigos", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Peticiones de ayuda", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(81, 34, 331, 154);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 331, 154);
		panel_3.add(scrollPane_2);
		
		
		
		

		this.frame.setVisible(true);

		
		
		/**
		 * 
		 * PANEL CRUCIGRAMAS
		 * 
		 * */
		
		cm = new CrosswordMapper(ds);
		am = new ActivosMapper(ds);
		Crossword crucigrama = new Crossword();
		ArrayList<Crossword> crucisActivos = null;

		 lista = new DefaultListModel();
		
		this.user.setActiveCrosswords(am.find(user.getNick()));
		
		
	
		for (int i = 0; i < this.user.getActiveCrosswords().size(); i++) {
			lista.addElement(this.user.getActiveCrosswords().get(i));
			System.out.println(this.user.getActiveCrosswords().get(i).getAmigo());
		}
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 65, 320, 176);
		panel.add(scrollPane);
		
				JList list = new JList();
				scrollPane.setViewportView(list);
				list.setToolTipText("Selecciona el crucigrama que quieras abrir");
		list.setModel(lista);
		if (crucigrama != null) {

			this.user.addActiveCrossword(crucigrama);

		} else
			System.out.println("Fallo");

		JButton btnNewButton = new JButton("Abrir crucigrama");
		btnNewButton.setBounds(224, 31, 161, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//CrosswordSearchGUI crosswordGUI= new CrosswordSearchGUI();
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Busqueda de crucigrama");
		btnNewButton_1.setBounds(65, 31, 149, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				CrosswordSearchGUI searchframe = new CrosswordSearchGUI(cm, ds,
						am, user, lista);

			}
		});
		panel.add(btnNewButton_1);

		
		/**
		 * 
		 * PANEL CRUCIGRAMAS
		 * 
		 * */
		
		
		listaForFriends = new DefaultListModel();
		
		//creamos un mapper de activos, y hacemos 2 busquedas, una por el nick del primer amigo y otra por la del segundo, y los añadimos al panel
		amigosm = new AmigosMapper(ds);
		ArrayList<Friends> auxiliar = new ArrayList<>();
		auxiliar = amigosm.findForFriend(user.getNick());
		ArrayList<Friends> auxiliar2 = new ArrayList<>();
		auxiliar2 = amigosm.find(user.getNick());
		for(int i = 0; i < auxiliar.size(); i++)
		{
			listaForFriends.addElement(auxiliar.get(i).getNick1());
			//if(auxiliar.get(i) != null) this.user.addAmigo(auxiliar.get(i));
			System.out.println(auxiliar.get(i).getNick1());
		}
		for(int i = 0; i < auxiliar2.size(); i++)
		{
			listaForFriends.addElement(auxiliar2.get(i).getNick1());
			//if(auxiliar.get(i) != null) this.user.addAmigo(auxiliar2.get(i));
			System.out.println(auxiliar2.get(i).getNick1());
		}
		panel_1.setLayout(null);
		
		JScrollPane scrollPaneForFriends = new JScrollPane();
		scrollPaneForFriends.setBounds(54, 5, 379, 171);
		panel_1.add(scrollPaneForFriends);
		
		 listForFriends = new JList();
		scrollPaneForFriends.setViewportView(listForFriends);
		list.setToolTipText("Lista de amigos");
		listForFriends.setModel(listaForFriends);
		
		
		textField = new JTextField();
		textField.setBounds(193, 183, 240, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblBuscarAmigo = new JLabel("Añadir amigo:");
		lblBuscarAmigo.setBounds(64, 186, 100, 14);
		panel_1.add(lblBuscarAmigo);
		
		JButton btnAadirAmigo = new JButton("Añadir amigo");
		btnAadirAmigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				User aux = new User(textField.getText());
				System.out.println(textField.getText());
				um = new UsuarioMapper(ds);
				aux = um.findById(textField.getText());
				if(aux != null)
				{
					Friends fr = new Friends(user.getNick(), aux.getNick());
					amigosm.insert(fr);
					listaForFriends.addElement(aux.getNick());
				}
				else
				{
					String error = "Este usuario no existe";
					System.out.println(error);
					JOptionPane.showMessageDialog(new JFrame(), error, "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAadirAmigo.setBounds(81, 211, 131, 23);
		panel_1.add(btnAadirAmigo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String selected;
				selected = (String) listForFriends.getSelectedValue();
				User usuario = new User(selected);
				Friends amigos = new Friends(user.getNick(), usuario.getNick());
				System.out.println(user.getNick() + " " + usuario.getNick());
				if (selected != null) {
					amigosm.delete(amigos);
					amigos = new Friends(usuario.getNick(), user.getNick());
					amigosm.delete(amigos);
					listaForFriends.removeElement(usuario.getNick());
					
				
				
				}
			}
		});
		btnEliminar.setBounds(262, 211, 131, 23);
		panel_1.add(btnEliminar);
		
		
		
		
		
		
		/**
		 * 
		 * PANEL PETICIONES
		 * 
		 * */
		Object[][] data = { 
				{"asdd" , "Crucigrama1"},
				
				{"asdd" , "Crucigrama2"}
			};
		String[] columnNames = {"Usuario", "Crucigrama"};
		table = new JTable(data, columnNames);
		

		scrollPane_2.setViewportView(table);
		
		
		
		JButton btnAbrirCrucigrama = new JButton("Abrir crucigrama");
		btnAbrirCrucigrama.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnAbrirCrucigrama.setBounds(81, 225, 148, 23);
		panel_2.add(btnAbrirCrucigrama);
		
		JButton btnDescartarPeticin = new JButton("Descartar Petición");
		btnDescartarPeticin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnDescartarPeticin.setBounds(264, 225, 148, 23);
		panel_2.add(btnDescartarPeticin);
		
		
	}
}
