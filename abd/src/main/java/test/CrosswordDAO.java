package test;


import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.DefaultListModel;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import mappers.ActivosMapper;
import mappers.CrosswordMapper;
import mappers.UsuarioMapper;
import ABD.abd.Crossword;
import ABD.abd.User;

public class CrosswordDAO {
	private DataSource ds;

	/**
	 * Aquí se debe inicializar el pool de conexiones, mediante
	 * la creación de un DataSource, que deberá ser asignado a
	 * la variable ds.
	 */
	public CrosswordDAO() {
		// this.ds = ...
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//cpds.setDriverClass("com.mysql.jdbc.Driver");
		
		
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/Practica1_715");
		cpds.setUser("root");
		cpds.setPassword("");

		cpds.setAcquireRetryAttempts(1);
		cpds.setAcquireRetryDelay(1);
		final DataSource ds = cpds;
		this.ds = ds;
	}

	
	/**
	 * Devuelve la contraseña del usuario cuyo nick se pasa como
	 * parámetro. Devuelve null si el usuario no existe. 
	 */
	public String getPassword(String nick) {
		
		UsuarioMapper um = new UsuarioMapper(ds);
		User aux = null;
		try 
		{
			aux= um.findById(nick);
			System.out.println(aux);
		}
		catch(NullPointerException e)
		{
			
		
		}
		finally
		{
			if(aux == null) return null;
			else return aux.getPass();
		}
		
				
		 
	}
	
	/**
	 * Modifica la contraseña del usuario pasado como parámetro 
	 */
	public void modifyPassword(String nick, String newPassword) {
		
		UsuarioMapper um = new UsuarioMapper(ds);
		User aux = null;
		aux= um.findById(nick);
		System.out.println(aux);
		
		aux.setPass(newPassword);
		um.update(aux);
		
		/*try 
		{
		
		}
		catch(NullPointerException e)
		{
			
		
		}
		finally
		{
			if(aux == null) System.out.println("Usuario no existente");
			else 
			{
				
				
			}
		}*/
		
	}

	/**
	 * Devuelve una lista de las claves de aquellos crucigramas
	 * cuyo título contenga str.
	 * 
	 * Si escogisteis una clave numérica para la tabla de crucigramas,
	 * se debe devolver una lista de Integer. Si escogisteis el título
	 * como clave, se debe devolver una lista de String. Si, por el contrario,
	 * escogisteis una clave compuesta, debéis crear una clase para almacenar
	 * los atributos de dicha clave. 
	 */
	public List<Crossword> findCrosswordsByTitle(String str) {
		
		List<Object> asd ;
		
		CrosswordMapper cm = new CrosswordMapper(ds);
		
		
		
	
		return cm.find2(str);
	}

	/**
	 * Devuelve el título del crucigrama cuya clave se pasa como
	 * parámetro.
	 */
	public String getCrosswordTitle(Object id) {
		
		/*CrosswordMapper cm = new CrosswordMapper(ds);
		Crossword aux = cm.findById((String) id);*/
		Crossword aux = (Crossword) id;
		
		return aux.getTitle();
		//return aux.getTitle();
	}
	
	/**
	 * Añade un crucigrama a la lista de crucigramas activos de un usuario.
	 * 
	 * El crucigrama se especifica mediante su clave
	 */
	public void addCrosswordToUser(String nick, Object crosswordId) {

		UsuarioMapper um = new UsuarioMapper(ds);

		User user = um.findById(nick);

		ActivosMapper am = new ActivosMapper(ds);

		Crossword resultado=new Crossword();
		CrosswordMapper cwm = new CrosswordMapper(ds);

		resultado= (Crossword) crosswordId;

		resultado.setUser(user);
		System.out.println(resultado.toString());
		am.insert(resultado);
		
		
	}
	
	/**
	 * Devuelve la lista de identificadores de los crucigramas activos
	 * del usuario pasado como parámetro
	 */
	public ArrayList<Crossword> getCrosswordsOf(String nick) {
		UsuarioMapper um = new UsuarioMapper(ds);
			User user = um.findById(nick);
			
			System.out.println(user.getNick());
			ActivosMapper am = new ActivosMapper(ds);
			
			
		
		
			user.setActiveCrosswords(am.find(user.getNick()));
			
		
			
			
			return user.getActiveCrosswords();
	}

	/**
	 * Cierra el dataSource
	 */
	public void close() {
		 ((ComboPooledDataSource)ds).close();
	}
}
