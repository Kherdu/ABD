package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import ABD.abd.Crossword;
import ABD.abd.Word;
import es.ucm.abd.crossword.CrosswordPanel;

public class CrosswordGUI {

	private JFrame frame;
	private JTextField Answer;

	/**
	 * Launch the application.
	 */

	public CrosswordGUI(ArrayList<Word> cwd) {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel crosswordContainer = new JPanel();
		crosswordContainer.setBounds(23, 11, 550, 400);
		frame.getContentPane().add(crosswordContainer);
		
		
		
		
	    CrosswordPanel paintCwd= new CrosswordPanel(crosswordContainer, cwd);
		
		//generar panel con atributos del crucigrama
		
		JPanel ImageContainer = new JPanel();
		ImageContainer.setBounds(33, 422, 93, 101);
		frame.getContentPane().add(ImageContainer);
		
		JTextPane Description = new JTextPane();
		Description.setBounds(138, 422, 435, 101);
		frame.getContentPane().add(Description);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Aceptar.setBounds(333, 654, 106, 29);
		frame.getContentPane().add(Aceptar);
		
		JButton askForHelp = new JButton("Pedir ayuda");
		askForHelp.setBounds(467, 654, 106, 29);
		frame.getContentPane().add(askForHelp);
		
		Answer = new JTextField();
		Answer.setBounds(154, 654, 174, 29);
		frame.getContentPane().add(Answer);
		Answer.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 550, 1, 1);
		frame.getContentPane().add(scrollPane);
		
		JList labelList = new JList();
		scrollPane.setViewportView(labelList);
		
		frame.setVisible(true);
	}
}
