package ABD.abd;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class User {

	
	private ArrayList <Friends> amigo;
	private String nick;
	private String pass;
	private String email;
	private Date birthDate;
	private byte[] avatar;
	private ImageIcon picture;
	private ArrayList <Crossword> activeCrosswords;
	//should be this a crossword array or a new class with crossword, user and check?
	private ArrayList<Crossword> helpCrosswords;
	
	private int puntuacion;
	
	
	public User(String nick, String pass, Date birthDate, ImageIcon picture)
	{
		this.puntuacion = 0;
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.birthDate = birthDate;
		this.picture = picture;
		
	}
	public User(String nick, String pass, Date birthDate, ImageIcon picture, int score)
	{
		this.puntuacion = score;
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.birthDate = birthDate;
		this.picture = picture;
		
	}
	public User(String nick, String pass, String email,  byte[] picture)
	{
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.avatar = picture;
		this.birthDate = null;
		this.puntuacion = 0;
		
	}
	public User(String nick, String pass, String email, Date birthDate)
	{
		this.nick = nick;
		this.pass = pass;
		this.email = email;
		this.birthDate = birthDate;
		this.avatar = null;
		this.puntuacion = 0;
		
	}
	public User(String nick, String pass)
	{
		this.nick = nick;
		this.pass = pass;
		
		this.puntuacion = 0;
		
		this.avatar = null;
		
	}
	
	public User(String nick)
	{
		this.nick = nick;
		this.pass = null;
		this.puntuacion = 0;
	    
		
		this.avatar = null;
		
	}
	
	public User()
	{
		this.nick = null;
		this.pass = null;
		this.email = null;
		this.birthDate = null;
		this.avatar = null;
		this.puntuacion = 0;
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
	public  byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar( byte[] avatar) {
		this.avatar = avatar;
	}


	public ArrayList <Crossword> getActiveCrosswords() {
		return activeCrosswords;
	}


	public void setActiveCrosswords(ArrayList <Crossword> activeCrosswords) {
		this.activeCrosswords = activeCrosswords;
	}


	public ArrayList <Friends> getAmigo() {
		return amigo;
	}


	public void setAmigo(ArrayList <Friends> amigo) {
		this.amigo = amigo;
	}

	public void addAmigo(Friends friend)
	{
		this.amigo.add(friend);
	}
	
	public ArrayList<Crossword> getHelpCrosswords() {
		return helpCrosswords;
	}


	public void setHelpCrosswords(ArrayList<Crossword> helpCrosswords) {
		this.helpCrosswords = helpCrosswords;
	}
	public ImageIcon getPicture() {
		return picture;
	}
	public void setPicture(ImageIcon picture) {
		this.picture = picture;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
}
