package logico;

public class DiscoDuro extends Componente {

	private String modelo;
	private int capacidad;
	private String tipoConexion;
	
	
	public DiscoDuro(String marca, float precio, int disponibles, int serie, String modelo, int capacidad,
			String tipoConexion) {
		super(marca, precio, disponibles, serie);
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.tipoConexion = tipoConexion;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public String getTipoConexion() {
		return tipoConexion;
	}


	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	
	

}
