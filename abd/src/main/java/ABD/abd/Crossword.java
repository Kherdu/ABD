package ABD.abd;

import java.sql.Date;
import java.util.ArrayList;

public class Crossword {
	
	private String title;
	private Date date;
	private ArrayList <Word> words;
	
	
	public Crossword(String title, Date date)
	{
		this.title = title;
		this.date = date;
		this.words = null;
	}
	public Crossword()
	{
		this.title=null;
		this.date = null;
		this.words = null;
	}
	
	
	
	/**
	 * 
	 * FALTA POR ACABAR
	 * 
	 * */
	
	public void loadWords()
	{
		/**
		 * Load table contiene from database, set the words in the word's array from crossword with coords and orientation.
		 * Check if there is a picture, if it's not null, add it to the auxiliar word. add to the array at the end.
		 * 
		 * */
		int dbWordSize = 10000;
		
		for(int i = 0; i < dbWordSize;i++)
		{
			/**
			 * If the word is already loaded, we can just use set to coords and orientation
			 * */
			Word aux = new Word(titulo, descripcion, coordX, coordY, orientacion);
			if(foto!=null) aux.setPicture(foto);
			this.words.add(aux);
		}
		
		
	}
	
	
	@Override
	public String toString() {
		return "Crossword [title=" + title + ", date=" + date + "]";
	}


	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Word> getWords() {
		return words;
	}
	public void setWords(ArrayList<Word> words) {
		this.words = words;
	}

	
	
}
