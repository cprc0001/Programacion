package logico;

public class Microprocesador extends Componente {

	private String modelo;
	private String tipoConexion;
	private String velocidad;
	
	public Microprocesador(String codigo, String marca, float precio, String serie, String modelo, String tipoConexion,
			String velocidad) {
		super(codigo, marca, precio, serie);
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		this.velocidad = velocidad;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	
	
}

