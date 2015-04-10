package ABD.abd;

public class Peticiones {

	private String usuario;
	private String crucigrama;
	private String amigo;
	
	public Peticiones()
	{
		this.usuario = null;
		this.crucigrama = null;
	}
	
	public Peticiones(String usuario, String crucigrama)
	{
		this.usuario = usuario;
		this.crucigrama = crucigrama;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCrucigrama() {
		return crucigrama;
	}

	public void setCrucigrama(String crucigrama) {
		this.crucigrama = crucigrama;
	}

	public String getAmigo() {
		return amigo;
	}

	public void setAmigo(String amigo) {
		this.amigo = amigo;
	}
	
	
}
