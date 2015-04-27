package es.ucm.abd.practica2.model;

import java.io.Serializable;

import javax.persistence.*;



@Entity
public class Contiene implements Serializable{

	@Id
	@ManyToOne
	private Crucigrama crucigrama;
	@Id
	@ManyToOne
	private Definicion definicion;
	private Orientation orientacion;
	private Integer fila;
	private Integer columna;
	
	
	
	public Contiene(Crucigrama crucigrama, Definicion definicion,
			Orientation orientacion,Integer fila, Integer columna) {
		
		this.crucigrama = crucigrama;
		this.definicion = definicion;
		this.orientacion = orientacion;
		this.fila=fila;
		this.columna=columna;
	}
	public Contiene(Crucigrama crossword, Definicion word, int row, int column,
			Orientation orientation) {
		this.crucigrama=crossword;
		this.definicion=word;
		this.orientacion=orientation;
		this.fila=row;
		this.columna=column;
	
	}
	public Crucigrama get_crucigrama() {
		return crucigrama;
	}
	public Definicion get_definicion() {
		return definicion;
	}
	public Orientation getOrientacion() {
		return orientacion;
	}
	
	public void setcrucigrama(Crucigrama crucigrama) {
		this.crucigrama = crucigrama;
	}
	public void setdefinicion(Definicion definicion) {
		this.definicion = definicion;
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
