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

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JComboBox;

import mappers.ActivosMapper;
import mappers.CrosswordMapper;
import mappers.UsuarioMapper;

public class UserMenu {

	private JFrame frame;

	private CrosswordMapper cm;
	private ActivosMapper am;
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

		JList list = new JList();
		list.setToolTipText("Selecciona el crucigrama que quieras abrir");

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Amigos", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Peticiones de ayuda", null, panel_2, null);

		this.frame.setVisible(true);

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
		list.setModel(lista);

		panel.add(list, BorderLayout.CENTER);
		if (crucigrama != null) {

			this.user.addActiveCrossword(crucigrama);

		} else
			System.out.println("Fallo");

		JButton btnNewButton = new JButton("Abrir crucigrama");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(360, 0, 100, 23);
		panel.add(btnNewButton, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Busqueda de crucigrama");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				CrosswordSearchGUI searchframe = new CrosswordSearchGUI(cm, ds,
						am, user, lista);

			}
		});
		btnNewButton_1.setBounds(116, 0, 100, 23);
		panel.add(btnNewButton_1, BorderLayout.SOUTH);

	}

	/**
	 * Initialize the contents of the frame.
	 */

}
