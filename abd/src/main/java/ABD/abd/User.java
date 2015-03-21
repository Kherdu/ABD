package ABD.abd;

import java.sql.Blob;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class User {

	
	private ArrayList <User> amigo;
	private String nick;
	private String pass;
	private String email;
	private Date birthDate;
	private char[] avatar;
	private Blob picture;
	private ArrayList <Crossword> activeCrosswords;
	//should be this a crossword array or a new class with crossword, user and check?
	private ArrayList<Crossword> helpCrosswords;
	
	
	
	public User(String nick, String pass, Date birthDate, Blob picture)
	{
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.birthDate = birthDate;
		this.picture = picture;
		
	}
	public User(String nick, String pass, String email, char[] picture)
	{
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.avatar = picture;
		this.birthDate = null;
		
	}
	public User(String nick, String pass, String email, Date birthDate)
	{
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.birthDate = birthDate;
		this.avatar = null;
		
	}
	public User(String nick, String pass)
	{
		this.nick = nick;
		this.pass = pass;
		
	    
		
		this.avatar = null;
		
	}
	
	public User()
	{
		this.nick = null;
		this.pass = null;
		this.email = null;
		this.birthDate = null;
		this.avatar = null;
		
	}
	
	
	
	
	
	
	public void addActiveCrossword(Crossword cw)
	{
		if(cw == null) System.out.println("pene");
		this.activeCrosswords.add(cw);
	}
	
	public void addHelpCrossword(Crossword cw)
	{
		this.helpCrosswords.add(cw);
	}
	
	public void deleteHelpCrossword(Crossword cw)
	{
		this.helpCrosswords.remove(cw);
	}
	
	

	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public char[] getAvatar() {
		return avatar;
	}
	public void setAvatar(char[] avatar) {
		this.avatar = avatar;
	}


	public ArrayList <Crossword> getActiveCrosswords() {
		return activeCrosswords;
	}


	public void setActiveCrosswords(ArrayList <Crossword> activeCrosswords) {
		this.activeCrosswords = activeCrosswords;
	}


	public ArrayList <User> getAmigo() {
		return amigo;
	}


	public void setAmigo(ArrayList <User> amigo) {
		this.amigo = amigo;
	}


	public ArrayList<Crossword> getHelpCrosswords() {
		return helpCrosswords;
	}


	public void setHelpCrosswords(ArrayList<Crossword> helpCrosswords) {
		this.helpCrosswords = helpCrosswords;
	}
	
}
