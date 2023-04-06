package logico;

public abstract class Componente {

	protected String codigo;
	protected String marca;
	protected float precio;
	protected int disponibles;
	protected int dispMin;
	protected String serie;
	protected char estado;
	

	public Componente(String codigo, String marca, float precio, String serie) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.precio = precio;
		this.disponibles = 0;
		this.dispMin = 0;
		this.serie = serie;
		this.estado = 'D';
	}


	public String getMarca() {
		return marca;
	}


	public String getCodigo() {
		return codigo;
	}


	public char getEstado() {
		return estado;
	}


	public void setEstado(char estado) {
		this.estado = estado;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public int getDispMin() {
		return dispMin;
	}


	public void setDispMin(int dispMin) {
		this.dispMin = dispMin;
	}
	
	
	
}
