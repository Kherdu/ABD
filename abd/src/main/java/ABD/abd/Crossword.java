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
	private User user;
	private String amigo;
	
	
	public Crossword(String title, Date date)
	{
		this.title = title;
		this.date = date;
		this.words = null;
		this.user = null;
		this.amigo = null;
	}
	

	public Crossword(String title)
	{
		this.title = title;
		this.date = null;
		this.words = null;
		this.user = null;
		this.amigo = null;
	}
	
	public Crossword(String title, String amigo)
	{
		this.title = title;
		this.date = null;
		this.words = null;
		this.user = null;
		this.amigo = amigo;
	}
	
	public Crossword(String title, String nick, String amigo)
	{
		this.title = title;
		this.date = null;
		this.words = null;
		setUserNick(nick);
		this.amigo = amigo;
	}
	
	public Crossword()
	{
		this.title=null;
		this.date = null;
		this.words = null;
		this.user = null;
		this.amigo = null;
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


	public String getUser() {
		return user.getNick();
	}

	
	public void setUserNick(String user)
	{
		this.user = new User(user);
	}
	
	public void setUser(User user) {
		this.user = user;
	}


	public String getAmigo() {
		return amigo;
	}


	public void setAmigo(String amigo) {
		this.amigo = amigo;
	}


	

	
	
}
