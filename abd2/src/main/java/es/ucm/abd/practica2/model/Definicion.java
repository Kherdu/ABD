package es.ucm.abd.practica2.model;

import java.util.List;

import javax.persistence.*;

import com.mysql.jdbc.Blob;

@Entity
public class Definicion {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		private String enunciado;
		@Lob
		private Blob imagen;
		private String respuesta;
		@ElementCollection
		private List<String> etiquetas;
		
		
		public Definicion(){
			this.id=null;
			this.enunciado=null;
			this.imagen=null;
			this.respuesta=null;
			this.etiquetas=null;
			
		}


		public Definicion(String sequence, String hint, List<String> tags) {
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


		public List<String> getEtiquetas() {
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


		public void setEtiquetas(List<String> etiquetas) {
			this.etiquetas = etiquetas;
		}
}
