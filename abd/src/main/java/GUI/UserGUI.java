package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JButton;

import mappers.ActivosMapper;
import mappers.CrosswordMapper;
import ABD.abd.Crossword;
import ABD.abd.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserGUI extends JFrame {

	private JFrame frame;


	private CrosswordMapper cm;
	private ActivosMapper am;
	private User user;
	 
	public UserGUI(final DataSource ds, final User user) {
		this.user = user;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(111, 97, 488, 308);
		frame.getContentPane().add(tabbedPane);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Amigos", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Peticiones de ayuda", null, panel_2, null);
		
		
		
		this.frame.setVisible(true);
		
		
		
		
		
		
		
		
		cm = new CrosswordMapper(ds);
		am = new ActivosMapper(ds);
		Crossword crucigrama = new Crossword();
		ArrayList <Crossword> crucisActivos = null;
	
		DefaultListModel lista = new DefaultListModel();
		this.user.setActiveCrosswords(am.find(user.getNick()));
		for(int i = 0; i < this.user.getActiveCrosswords().size(); i++)
		{
			lista.addElement(this.user.getActiveCrosswords().get(i));
			System.out.println(this.user.getActiveCrosswords().get(i));
		}
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Crucigramas", null, panel, null);
		
	
	
		
		JList list = new JList();
		list.setBounds(379, 197, -287, -181);
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Abrir crucigrama");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.setLayout(null);
		btnNewButton.setBounds(102, 246, 111, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Busqueda de crucigramas");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(233, 246, 155, 23);
		panel.add(btnNewButton_1);
		list.setModel(lista);
		
		panel.add(list);
		if(crucigrama != null){
			
			
			this.user.addActiveCrossword(crucigrama);

		}
		else System.out.println("Fallo");
	
    }
}
