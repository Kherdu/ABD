package es.ucm.abd.practica2.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class Crucigrama {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String titulo;
	
	private Date Fecha_Creacion;
	
	@OneToMany(mappedBy="crucigrama", cascade = CascadeType.ALL)
	
	private List<Contiene> palabras;
	
	public Crucigrama(){
		
		
	}


	public Crucigrama(String title, Date date) {
		this.titulo=title;
		this.Fecha_Creacion=date;
		this.palabras= new ArrayList<Contiene>();
	}
	
	public List<Object[]> getPalabras() {
		
		//construir el array de objetos para sacarlo
		
		//cerdada padre
		List <Object[]> l= new ArrayList<Object[]>();
		for(Contiene c: palabras){
			Object[] o= new Object[4];
			o[0]=c.get_definicion().getRespuesta();
			o[1]=c.getFila();
			o[2]=c.getColumna();
			o[3]=c.getOrientacion();
			l.add(o);
		}
		
		return l;
	}


	public void setPalabras(List<Contiene> palabras) {
		this.palabras = palabras;
	}

	public void addPalabra(Contiene c){
		
		palabras.add(c);
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

