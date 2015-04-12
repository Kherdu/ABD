package ABD.abd;

public class Resuelve {

	private Integer idCrucigrama;
	private String usuario;
	private String responde;
	private String palabra;
	
	public Resuelve()
	{
		this.idCrucigrama=0;
		this.usuario = null;
		this.responde = null;
		this.palabra = null;
	}
	public Resuelve(String usuario, String responde, String palabra)
	{
		this.usuario = usuario;
		this.responde = responde;
		this.palabra = palabra;
		
	}
	
	public Resuelve( String responde, String palabra)
	{
		this.usuario = null;
		this.responde = responde;
		this.palabra = palabra;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getResponde() {
		return responde;
	}

	public void setResponde(String responde) {
		this.responde = responde;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public Integer getIdCrucigrama() {
		return idCrucigrama;
	}
	public void setIdCrucigrama(Integer idCrucigrama) {
		this.idCrucigrama = idCrucigrama;
	}
}
