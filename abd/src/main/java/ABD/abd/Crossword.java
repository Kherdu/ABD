package ABD.abd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import mappers.AbstractMapper;
import mappers.ContieneMapper;
import mappers.UsuarioMapper;
import mappers.WordMapper;

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
	
	
	
	/*public void loadWords()
	{
		int i = 0;
		Word aux = null;
		DataSource ds;
		//¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?
		ContieneMapper um = new ContieneMapper(ds);
		WordMapper wm = new WordMapper(ds);
		
		
		//¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?
		
		
		do
		{
			this.words.add(um.findById(this.title));
			aux = wm.findById(this.title);
			
			this.words.get(i).setDescription(aux.getDescription());
			
			i++;
		}while(!this.words.get(i-1).equals(null) );
		
		this.words.remove(i-1);
		
		
		
	}
	*/
	
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
