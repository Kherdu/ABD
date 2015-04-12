package GUI;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;

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
import es.ucm.abd.crossword.CrosswordPanelEventListener;
import es.ucm.abd.crossword.WordModel;

public class CrosswordGUI {

	private JFrame frame;
	private JTextField Answer;
	private CrosswordPanelEventListener listener;
	private Word selected;
	private JTextPane description;

	/**
	 * Launch the application.
	 */

	public CrosswordGUI(ArrayList<Word> cwd) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1227, 734);
		
		frame.getContentPane().setLayout(null);
		
		
		//generar panel con atributos del crucigrama
		
	    CrosswordPanel<Word> paintCwd= new CrosswordPanel(frame, cwd);
	    paintCwd.setBounds(23, 11, 588, 654);
	    //redimensionar, sale raro
	   
		frame.getContentPane().add(paintCwd);
		 selected=paintCwd.getSelectedWord();
		paintCwd.addEventListener(new CrosswordPanelEventListener(){

			@Override
			public void cellSelected(CrosswordPanel paintCwd, Point arg1) {
				
				
			}

			@Override
			public void deselected(CrosswordPanel arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void wordSelected(CrosswordPanel paintCwd, WordModel selected) {
				String text=  ((Word) selected).getDescription();
				if (text!=null){
					description.setText(text);
					frame.repaint();
				}
			}
			
			
			
		});
		
		JPanel ImageContainer = new JPanel();
		ImageContainer.setBounds(642, 11, 93, 101);
		frame.getContentPane().add(ImageContainer);
		
		description = new JTextPane();
		description.setEditable(false);
		//con esto se pone la descripcion de la palabra seleccionada
		
		description.setBounds(745, 11, 454, 101);
		frame.getContentPane().add(description);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Aceptar.setBounds(856, 162, 106, 29);
		frame.getContentPane().add(Aceptar);
		
		JButton askForHelp = new JButton("Pedir ayuda");
		askForHelp.setBounds(1005, 162, 106, 29);
		frame.getContentPane().add(askForHelp);
		
		Answer = new JTextField();
		Answer.setBounds(642, 162, 174, 29);
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
