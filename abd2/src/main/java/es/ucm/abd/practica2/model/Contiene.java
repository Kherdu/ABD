package es.ucm.abd.practica2.model;

public class Contiene {

	private Integer id_crucigrama;
	private Integer id_definicion;
	private Orientation orientacion;
	private Integer fila;
	private Integer columna;
	
	
	
	public Contiene(Integer id_crucigrama, Integer id_definicion,
			Orientation orientacion,Integer fila, Integer columna) {
		
		this.id_crucigrama = id_crucigrama;
		this.id_definicion = id_definicion;
		this.orientacion = orientacion;
		this.setFila(fila);
		this.setColumna(columna);
	}
	public Contiene(Crucigrama crossword, Definicion word, int row, int column,
			Orientation orientation) {
		this.id_crucigrama=crossword.getId();
		this.id_definicion=word.getId();
		this.orientacion=orientation;
		this.setFila(row);
		this.setColumna(column);
	
	}
	public Integer getId_crucigrama() {
		return id_crucigrama;
	}
	public Integer getId_definicion() {
		return id_definicion;
	}
	public Orientation getOrientacion() {
		return orientacion;
	}
	
	public void setId_crucigrama(Integer id_crucigrama) {
		this.id_crucigrama = id_crucigrama;
	}
	public void setId_definicion(Integer id_definicion) {
		this.id_definicion = id_definicion;
	}
	public void setOrientacion(Orientation orientacion) {
		this.orientacion = orientacion;
	}
	public Integer getFila() {
		return fila;
	}
	public void setFila(Integer fila) {
		this.fila = fila;
	}
	public Integer getColumna() {
		return columna;
	}
	public void setColumna(Integer columna) {
		this.columna = columna;
	}
	
	
}
