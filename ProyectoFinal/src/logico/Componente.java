package logico;
import java.io.Serializable;

public abstract class Componente implements Serializable {

	protected static final long serialVersionUID = 1L;
	protected String codigo;
	protected String marca;
	protected float precio;
	protected int disponibles;
	protected int dispMin;
	protected String serie;
	protected char estado;
	protected int cant;
	

	public Componente(String codigo, String marca, float precio, String serie) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.precio = precio;
		this.disponibles = 0;
		this.dispMin = 0;
		this.serie = serie;
		this.estado = 'D';
		this.cant = 0;
	}


	public String getMarca() {
		return marca;
	}


	public String getCodigo() {
		return codigo;
	}

	

	public int getCant() {
		return cant;
	}


	public void setCant(int cant) {
		this.cant = cant;
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
