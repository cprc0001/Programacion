package logico;

public abstract class Componente {

	protected String marca;
	protected float precio;
	protected int disponibles;
	protected int serie;
	

	public Componente(String marca, float precio, int disponibles, int serie) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.disponibles = disponibles;
		this.serie = serie;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getDisponibles() {
		return disponibles;
	}


	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}


	public int getSerie() {
		return serie;
	}


	public void setSerie(int serie) {
		this.serie = serie;
	}
	
	
}
