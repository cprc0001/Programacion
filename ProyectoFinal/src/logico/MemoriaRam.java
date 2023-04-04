package logico;

public class MemoriaRam extends Componente {

	private String memoria;
	private String tipo;
	
	public MemoriaRam(String codigo, String marca, float precio, String serie, String memoria, String tipo) {
		super(codigo, marca, precio, serie);
		this.memoria = memoria;
		this.tipo = tipo;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
