package logico;

public class DiscoDuro extends Componente {

	private String modelo;
	private String capacidad;
	private String tipoConexion;
	
	
	public DiscoDuro(String codigo, String marca, float precio, String serie, String modelo, String capacidad,
			String tipoConexion) {
		super(codigo, marca, precio, serie);
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


	public String getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}


	public String getTipoConexion() {
		return tipoConexion;
	}


	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	
	

}
