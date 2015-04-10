package GUI;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.swing.JFrame;

import ABD.abd.Crossword;
import ABD.abd.Friends;
import ABD.abd.Peticiones;
import ABD.abd.User;
import ABD.abd.Word;

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
import mappers.ContieneMapper;
import mappers.CrosswordMapper;
import mappers.PeticionesMapper;
import mappers.UsuarioMapper;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UserMenu {

	private JFrame frame;

	private CrosswordMapper cm;
	private ActivosMapper am;
	private ContieneMapper cntm;
	private User user;
	private DefaultListModel listField;
	private DefaultListModel listaForFriends;
	private JList list;
	private AmigosMapper amigosm;
	private JList listForFriends;
	private PeticionesMapper petm;
	private ArrayList<Peticiones> peticionado;
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
		petm = new PeticionesMapper(ds);
		cm = new CrosswordMapper(ds);
		am = new ActivosMapper(ds);
		cntm= new ContieneMapper(ds);
		Crossword crucigrama = new Crossword();
		ArrayList<Crossword> crucisActivos = null;
		

		listField = new DefaultListModel();
		
		this.user.setActiveCrosswords(am.find(user.getNick()));
		
		
	
		for (int i = 0; i < this.user.getActiveCrosswords().size(); i++) {
			listField.addElement(this.user.getActiveCrosswords().get(i));
		
		}
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 65, 320, 176);
		panel.add(scrollPane);
		
				list = new JList(listField);
				scrollPane.setViewportView(list);
				list.setToolTipText("Selecciona el crucigrama que quieras abrir");
				list.setModel(listField);
				
		if (crucigrama != null) {

			this.user.addActiveCrossword(crucigrama);

		} else
			System.out.println("Fallo");

		JButton btnNewButton = new JButton("Abrir crucigrama");
		btnNewButton.setBounds(224, 31, 161, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				Crossword selected=new Crossword();
				selected = (Crossword) list.getSelectedValue();
				ArrayList<Word> words= new ArrayList<Word>();
				words.addAll(cntm.find(selected.getTitle()));
				CrosswordGUI opencrossword= new CrosswordGUI(words);
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Busqueda de crucigrama");
		btnNewButton_1.setBounds(65, 31, 149, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				CrosswordSearchGUI searchframe = new CrosswordSearchGUI(cm, ds,
						am, user, listField);

			}
		});
		panel.add(btnNewButton_1);

		
		//Boton en el que metemos la imagen
		JButton btnNewButton_12 = new JButton();
		btnNewButton_12.setBounds(111, 11, 89, 74);
		frame.getContentPane().add(btnNewButton_12);
		
		if(user.getPicture()!=null) btnNewButton_12.setIcon(user.getPicture());
		
		
		JLabel lblNewLabel_1 = new JLabel("NICK:");
		lblNewLabel_1.setBounds(222, 11, 112, 25);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(user.getNick());
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		lblNewLabel.setBounds(381, 11, 262, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(222, 58, 46, 14);
		frame.getContentPane().add(lblEdad);
		
		JLabel lblAos = new JLabel("34 años");
		lblAos.setBounds(381, 58, 145, 14);
		frame.getContentPane().add(lblAos);
		
		
		
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
			
		}
		for(int i = 0; i < auxiliar2.size(); i++)
		{
			listaForFriends.addElement(auxiliar2.get(i).getNick1());
			
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
		
		peticionado = new ArrayList<>();
		
		peticionado = petm.find(user.getNick());
		Object[][] data = new Object[8][8];
		
		
		for(int i = 0; i < peticionado.size(); i++)
		{
			peticionado.get(i).setAmigo(user.getNick());
			data[i][0] = peticionado.get(i).getCrucigrama();
			data[i][1] = peticionado.get(i).getUsuario();
			
		}
		
		
		String[] columnNames = {"Usuario", "Crucigrama"};
		
		table = new JTable(data, columnNames);
		table.setModel(new DefaultTableModel(data, columnNames));

		
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
				Peticiones pet = new Peticiones();
				Crossword crAux = new Crossword();
				Object[][] dataAux = new Object[8][8];
				
				int row = table.getSelectedRow();
				int column = table.getColumnCount();
				for(int i = 0; i < column; i++) {
					dataAux[row][i]= table.getValueAt(row, i);
				   
				   
				}
				
				 crAux.setAmigo(null);
				crAux.setUserNick((String) dataAux[row][0]);
				crAux.setTitle((String) dataAux[row][1]);
	
				
				
				((DefaultTableModel)table.getModel()).removeRow(row);
				am.update(crAux);
			
				
			}
		});
		btnDescartarPeticin.setBounds(264, 225, 148, 23);
		panel_2.add(btnDescartarPeticin);
		

	

				
				
				
				
				
				
		
		
	}
}
