package es.ucm.abd.practica2.model;

import java.util.Date;

public class Crucigrama {
	
	private Integer id;
	private String titulo;
	private Date Fecha_Creacion;
	
	
	public Crucigrama(){
		
		this.id=null;
		this.titulo=null;
		this.Fecha_Creacion=null;
		
	}


	public Crucigrama(String title, Date date) {
		this.titulo=title;
		this.Fecha_Creacion=date;
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

