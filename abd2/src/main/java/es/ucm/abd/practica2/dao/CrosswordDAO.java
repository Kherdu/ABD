package es.ucm.abd.practica2.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;

public class CrosswordDAO implements AbstractCrosswordDAO<Crucigrama, Definicion> {

	private SessionFactory sf;
	private Session session;
	public CrosswordDAO()
	{
		
	}
	

	public void setSessionFactory(SessionFactory f) {
		this.sf = f;
		
	}

	@Override
	public int insertCrossword(Crucigrama crossword) {

		Transaction tr = session.beginTransaction();
		session.save(crossword);
		tr.commit();
		return crossword.getId();
	}

	@Override
	public void insertWord(Definicion word) {
		this.session = this.sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(word);
		tr.commit();
		
	}

	@Override
	public Crucigrama findCrosswordById(int id) {
		this.session = this.sf.openSession();

		Crucigrama c1  = (Crucigrama) this.session.get(Crucigrama.class, id);
		
		return c1;
	}

	@Override
	public List<Object[]> getCrosswordData(String str) {
		/**
		 * WTF??
		 * 
		 * Devuelve el identificador, título, fecha de creación
		 * y número de palabras de los crucigramas cuyo título contenga
		 * la palabra pasada como parámetro.
		 * 
		 * */
		
		this.session = this.sf.openSession();
		
		Query query = session.createQuery("SELECT c.id, c.titulo, c.Fecha_Creacion, COUNT (list.crucigrama.id)"
				+ "	FROM Crucigrama AS c LEFT JOIN c.palabras AS list "
				+ "WHERE c.titulo LIKE ? GROUP BY c.id ");
		
		query.setString(0, "%" + str + "%");
		
		@SuppressWarnings("unchecked")
		List<Object[]> resultados = (List<Object[]>)query.list();
		return resultados;
	}

	@Override
	public List<Definicion> findWordsByTags(String[] tags) {
		
				Query query;
		this.session = this.sf.openSession();
		
		if(tags.length== 0)
		{
			query = session.createQuery("SELECT d	FROM Definicion AS d");
			List<Definicion> aux = (List<Definicion>)query.list();
			return aux;
			
		}
		else
		{
			query = session.createQuery("SELECT d FROM Definicion AS d WHERE d.enunciado LIKE ?");
			List<Definicion> aux= new ArrayList<Definicion>();
			for(int i = 0; i< tags.length; i++)
			{
				
				query.setString(0, "%" + tags[i] + "%");
				aux.addAll((List<Definicion>)query.list());
			}
			 
			
			return aux;
		}
		
	}

	@Override
	public List<Definicion> getMatchingWords(CharConstraint[] constraints) {
		// TODO Auto-generated method stub
		return null;
	}

}
