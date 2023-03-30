package logico;

public class Microprocesadores extends Componente {

	private String modelo;
	private String tipoConexion;
	private int velocidad;
	
	public Microprocesadores(String marca, float precio, int disponibles, int serie, String modelo, String tipoConexion,
			int velocidad) {
		super(marca, precio, disponibles, serie);
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

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	
}
