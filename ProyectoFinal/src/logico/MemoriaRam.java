package logico;

public class MemoriaRam extends Componente {

	private int memoria;
	private String tipo;
	
	public MemoriaRam(String marca, float precio, int disponibles, int serie, int memoria, String tipo) {
		super(marca, precio, serie);
		this.memoria = memoria;
		this.tipo = tipo;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
