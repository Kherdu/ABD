package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.swing.JFrame;

import ABD.abd.Crossword;
import ABD.abd.User;
import ABD.abd.Word;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JComboBox;

import mappers.ActivosMapper;
import mappers.ContieneMapper;
import mappers.CrosswordMapper;
import mappers.UsuarioMapper;
import mappers.WordMapper;

import javax.swing.JScrollPane;

public class UserMenu {

	private JFrame frame;

	private CrosswordMapper cm;
	private ActivosMapper am;
	private ContieneMapper ctm;
	private User user;
	private DefaultListModel lista;
	

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

		this.frame.setVisible(true);
		ctm= new ContieneMapper(ds);
		cm = new CrosswordMapper(ds);
		am = new ActivosMapper(ds);
		Crossword crucigrama = new Crossword();
		ArrayList<Crossword> crucisActivos = null;

		 lista = new DefaultListModel();
		
		this.user.setActiveCrosswords(am.find(user.getNick()));
		for (int i = 0; i < this.user.getActiveCrosswords().size(); i++) {
			lista.addElement(this.user.getActiveCrosswords().get(i));
			//System.out.println(this.user.getActiveCrosswords().get(i));
		}
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 65, 320, 176);
		panel.add(scrollPane);
		
				final JList list = new JList();
				scrollPane.setViewportView(list);
				list.setToolTipText("Selecciona el crucigrama que quieras abrir");
				list.setModel(lista);
				
		if (crucigrama != null) {

			this.user.addActiveCrossword(crucigrama);

		} 

		JButton btnNewButton = new JButton("Abrir crucigrama");
		btnNewButton.setBounds(224, 31, 161, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Word> abrir= new ArrayList();
				
				Crossword selected= new Crossword();
				 selected=(Crossword) list.getSelectedValue();
				abrir.addAll(ctm.find(selected.getTitle()));
				
				CrosswordGUI crosswordGUI= new CrosswordGUI(abrir);
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

	}

	/**
	 * Initialize the contents of the frame.
	 */

}
