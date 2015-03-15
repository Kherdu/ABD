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
