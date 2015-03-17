package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sql.DataSource;
import javax.swing.JFrame;

import ABD.abd.Crossword;
import ABD.abd.User;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JComboBox;

import mappers.CrosswordMapper;
import mappers.UsuarioMapper;

public class UserMenu {

	private JFrame frame;

	private UsuarioMapper user;
	private CrosswordMapper cm;
	
	public UserMenu(final DataSource ds, final User user) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(111, 97, 488, 308);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Crucigramas", null, panel, null);
		
	
		cm = new CrosswordMapper(ds);
		
		
		
		JList list = new JList();
		panel.add(list, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Amigos", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Peticiones de ayuda", null, panel_2, null);
		
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
}
