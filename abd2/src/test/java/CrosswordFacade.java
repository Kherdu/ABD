import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.ucm.abd.practica2.dao.AbstractCrosswordDAO;
import es.ucm.abd.practica2.model.Contiene;
import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;
import es.ucm.abd.practica2.model.Orientation;
import es.ucm.abd.practica2.model.WordsOfCrossword;


public class CrosswordFacade implements AbstractCrosswordFacade<Crucigrama,Definicion>{

	public CrosswordFacade(){
		
	}
	@Override
	public Crucigrama newCrossword(String title, Date date) {
		
		Crucigrama cwd= new Crucigrama(title,date);
		return cwd;
	}
	
	@Override
	public Definicion newDefinition(String sequence, String hint, String[] tags) {
 		List<String> tag=new ArrayList<String>();
		for (int i=0;i<tags.length;i++){
			tag.add(tags[i]);
		}
 		//tags instead of tag y cargarse el bucle
		Definicion d= new Definicion(sequence,hint,tag);
		return d;
	}
	@Override
	public void addWordToCrossword(Crucigrama crossword, Definicion word,
			int row, int column, Orientation orientation) {
			new Contiene(crossword,word,row,column,orientation);
			Object[] o= new Object[]{word.getRespuesta(),row,column,orientation};
			crossword.addPalabra(o);
	}
	@Override
	public String getAnswerOfWord(Definicion word) {
		return word.getRespuesta();
	}
	@Override	
	public String[] getTagsOfWord(Definicion word) {
		
		ArrayList<String> tags=new ArrayList<>();
		
		for (String s: word.getEtiquetas()){
			
			tags.add(s);
		}
		String[] words = new String[tags.size()];
		tags.toArray(words);
		return words;
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
				return crossword.getPalabras();
	
	}
	
	
	
	
	//este no se toca por ahora
	@Override
	public AbstractCrosswordDAO<Crucigrama, Definicion> createDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
