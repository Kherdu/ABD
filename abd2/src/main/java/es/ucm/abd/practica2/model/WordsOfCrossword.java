package es.ucm.abd.practica2.model;

public class WordsOfCrossword {

	private String word;
	private Integer row;
	private Integer column;
	private Orientation orientacion;
	
	
	public WordsOfCrossword(String word, Integer row, Integer column,
			Orientation orientacion) {
	
		this.word = word;
		this.row = row;
		this.column = column;
		this.orientacion = orientacion;
	}
	
	public String getWord() {
		return word;
	}



	public Integer getRow() {
		return row;
	}



	public Integer getColumn() {
		return column;
	}



	public Orientation getOrientacion() {
		return orientacion;
	}



	public void setWord(String word) {
		this.word = word;
	}



	public void setRow(Integer row) {
		this.row = row;
	}



	public void setColumn(Integer column) {
		this.column = column;
	}



	public void setOrientacion(Orientation orientacion) {
		this.orientacion = orientacion;
	}


}
