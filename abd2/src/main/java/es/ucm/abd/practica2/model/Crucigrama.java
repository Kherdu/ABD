package es.ucm.abd.practica2.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity
public class Crucigrama {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false)
	private String titulo;
	
	private Date Fecha_Creacion;
	
	@ElementCollection
	private List<Object[]> palabras;
	
	public Crucigrama(){
		
		this.id=null;
		this.titulo=null;
		this.Fecha_Creacion=null;
		this.palabras= new ArrayList<Object[]>();
		
	}


	public Crucigrama(String title, Date date) {
		this.titulo=title;
		this.Fecha_Creacion=date;
		this.palabras= new ArrayList<Object[]>();
	}
	
	public List<Object[]> getPalabras() {
		return palabras;
	}


	public void setPalabras(List<Object[]> palabras) {
		this.palabras = palabras;
	}

	public void addPalabra(Object[] palabra){
		
		palabras.add(palabra);
	}
	
	public Integer getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public Date getFecha_Creacion() {
		return Fecha_Creacion;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setFecha_Creacion(Date fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}
	
}

