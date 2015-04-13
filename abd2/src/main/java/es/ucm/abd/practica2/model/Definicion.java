package es.ucm.abd.practica2.model;

import com.mysql.jdbc.Blob;

public class Definicion {

		private Integer id;
		private String enunciado;
		private Blob imagen;
		private String respuesta;
		private String[] etiquetas;
		
		
		public Definicion(){
			this.id=null;
			this.enunciado=null;
			this.imagen=null;
			this.respuesta=null;
			this.etiquetas=null;
			
		}


		public Definicion(String sequence, String hint, String[] tags) {
			this.respuesta=sequence;
			this.enunciado=hint;
			this.etiquetas=tags;
		}


		public Integer getId() {
			return id;
		}


		public String getEnunciado() {
			return enunciado;
		}


		public Blob getImagen() {
			return imagen;
		}


		public String getRespuesta() {
			return respuesta;
		}


		public String[] getEtiquetas() {
			return etiquetas;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public void setEnunciado(String enunciado) {
			this.enunciado = enunciado;
		}


		public void setImagen(Blob imagen) {
			this.imagen = imagen;
		}


		public void setRespuesta(String respuesta) {
			this.respuesta = respuesta;
		}


		public void setEtiquetas(String[] etiquetas) {
			this.etiquetas = etiquetas;
		}
}
