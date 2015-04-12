package GUI;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;

import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import mappers.ResuelveMapper;
import mappers.UsuarioMapper;
import mappers.WordMapper;
import ABD.abd.Crossword;
import ABD.abd.Resuelve;
import ABD.abd.User;
import ABD.abd.Word;
import es.ucm.abd.crossword.CrosswordPanel;
import es.ucm.abd.crossword.CrosswordPanelEventListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrosswordGUI {

	private JFrame frame;
	private JTextField answer;
	private JTextArea description;
	private ArrayList<Word> words;
	private DataSource ds;
	private JButton btnNewButton_12;
	private JButton aceptar;
	private  CrosswordPanel<Word> paintCwd;
	private ArrayList<Word> cwd;
	private User user;
	private Resuelve resuelve;
	/**
	 * Launch the application.
	 */

	public CrosswordGUI(ArrayList<Word> cw, DataSource datas, User usr, Resuelve res) {
		
		resuelve = res;
		user = usr;
		cwd = cw;
		frame = new JFrame();
		frame.setBounds(100, 100, 836, 857);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		words = cwd;
		ds = datas;
		
		/*Panel crosswordContainer = new Panel();
		crosswordContainer.setBounds(23, 11, 550, 400);
		*/
		//generar panel con atributos del crucigrama
		
	   paintCwd= new CrosswordPanel(frame, cwd);
	    paintCwd.setBounds(23, 11, 787, 503);
		frame.getContentPane().add(paintCwd);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);	
		scrollPane.setBounds(182, 550, 1, 1);
		frame.getContentPane().add(scrollPane);
		
		description = new JTextArea();
		description.setBounds(138, 525, 672, 101);
		frame.getContentPane().add(description);
		
		
		
		
		
		aceptar = new JButton("Aceptar");
		
	
		aceptar.setBounds(333, 654, 106, 29);
		frame.getContentPane().add(aceptar);
		
		JButton askForHelp = new JButton("Pedir ayuda");
		askForHelp.setBounds(467, 654, 106, 29);
		frame.getContentPane().add(askForHelp);
		
		answer = new JTextField();
		answer.setBounds(154, 654, 174, 29);
		frame.getContentPane().add(answer);
		answer.setColumns(10);
		
		
		
		JList labelList = new JList();
		scrollPane.setViewportView(labelList);
		
		

		btnNewButton_12 = new JButton();
		btnNewButton_12.setBounds(23, 525, 105, 101);
		frame.getContentPane().add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		frame.setVisible(true);
		
	
		paintCwd.addEventListener(new CrosswordPanelEventListener<Word>() {
			
			
	            public void wordSelected(CrosswordPanel<Word> source, final Word newWord) {
	            	final Word aux;
	            	WordMapper um = new WordMapper(ds);
	            	
	            	
	            	
	    			
	            	
	                if (newWord != null) {
	                	aux = um.findById(newWord.getWord());
	                	description.setText(aux.getDescription());
	                    System.out.println("Seleccionada la palabra " + newWord.getWord());
	                    
	                    
	                    
	                    for(int i = 0; i< cwd.size(); i++)
	                    {
	                    	if(cwd.get(i).getWord().equalsIgnoreCase(newWord.getWord()))
	                    	{
	                    		   System.out.println(cwd.get(i).getPuntuacion());
	                    		   int score = cwd.get(i).getPuntuacion() + user.getPuntuacion();
	                    		   
	                    		   
	                    		   user.setPuntuacion(score);
	                    	
	                    		   
	                    	}
	                    }
	                    
	                    
	                 
	            		if(aux.getPicture()!=null) btnNewButton_12.setIcon(aux.getPicture());
	            		else btnNewButton_12.setIcon(null);
	            		
	            		
	            		
	            		 aceptar.addMouseListener(new MouseAdapter() {
	 	        			@Override
	 	        			public void mouseClicked(MouseEvent arg0) {
	 	        				
	 	        				
	 	        				//Resuelve resuelve = new Resuelve();
	 	        				ResuelveMapper rm = new ResuelveMapper(ds);
	 	        				if(newWord.getWord().equalsIgnoreCase(answer.getText()))
	 	        				{
	 	        					//resuelve.setUsuario(user.getNick());
	 	        					resuelve.setPalabra(newWord.getWord());
	 	        					resuelve.setResponde(user.getNick());
	 	        					rm.insert(resuelve);
	 	        					paintCwd.showWord(newWord);
	 	        				}
	 	        			
	 	        				
	 	        			}
	 	        		});
	            		 
	            		 
	                } else {
	                    System.out.println("Deseleccionada palabra");
	                }
	                
	                
	                
	               
	                
	                
	            }

	            public void cellSelected(CrosswordPanel<Word> source, Point newCell) {
	                if (newCell != null) {
	                    System.out.println("Seleccionada la celda (" + newCell.x + ", " + newCell.y + ")");
	                } else {
	                    System.out.println("Deseleccionada celda");
	                }
	            }

	            public void deselected(CrosswordPanel<Word> source) {
	                System.out.println("DeselecciÃ³n!");
	            }
	        });
	
	}
}
