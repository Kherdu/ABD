import java.util.Date;
import java.util.List;

import es.ucm.abd.practica2.dao.AbstractCrosswordDAO;
import es.ucm.abd.practica2.model.Contiene;
import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;
import es.ucm.abd.practica2.model.Orientation;


public class CrosswordFacade implements AbstractCrosswordFacade<Crucigrama,Definicion>{

	
	@Override
	public Crucigrama newCrossword(String title, Date date) {
		
		Crucigrama cwd= new Crucigrama(title,date);
		return cwd;
	}
	
	@Override
	public Definicion newDefinition(String sequence, String hint, String[] tags) {
		Definicion d= new Definicion(sequence,hint,tags);
		return d;
	}
	@Override
	public void addWordToCrossword(Crucigrama crossword, Definicion word,
			int row, int column, Orientation orientation) {
			new Contiene(crossword,word,row,column,orientation);
	}
	@Override
	public String getAnswerOfWord(Definicion word) {
		return word.getRespuesta();
	}
	@Override	
	public String[] getTagsOfWord(Definicion word) {

		return word.getEtiquetas();
	}
	@Override
	public String getHintOfWord(Definicion word) {
		return word.getEnunciado();
	}
	@Override
	public String getTitleOfCrossword(Crucigrama crossword) {
		return crossword.getTitulo();
	}
	@Override
	public Date getDateOfCrossword(Crucigrama crossword) {
		return crossword.getFecha_Creacion();
	}
	@Override
	public List<Object[]> getWordsOfCrossword(Crucigrama crossword) {
				return null;
	}
	
	//este no se toca por ahora
	@Override
	public AbstractCrosswordDAO<Crucigrama, Definicion> createDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
