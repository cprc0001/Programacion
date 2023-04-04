package logico;

public class MotherBoard extends Componente {
   
   private String modelo;
   private String tipoConector;
   private String tipoMemoria;
   private String conexionesDisco;
   
   
public MotherBoard(String codigo, String marca, float precio, String serie, String modelo, String tipoConector,
		String tipoMemoria, String conexionesDisco) {
	super(codigo, marca, precio, serie);
	this.modelo = modelo;
	this.tipoConector = tipoConector;
	this.tipoMemoria = tipoMemoria;
	this.conexionesDisco = conexionesDisco;
}


public String getMarca() {
	return marca;
}


public void setMarca(String marca) {
	this.marca = marca;
}


public String getModelo() {
	return modelo;
}


public void setModelo(String modelo) {
	this.modelo = modelo;
}


public String getTipoConector() {
	return tipoConector;
}


public void setTipoConector(String tipoConector) {
	this.tipoConector = tipoConector;
}


public String getTipoMemoria() {
	return tipoMemoria;
}


public void setTipoMemoria(String tipoMemoria) {
	this.tipoMemoria = tipoMemoria;
}


public String getConexionesDisco() {
	return conexionesDisco;
}


public void setConexionesDisco(String conexionesDisco) {
	this.conexionesDisco = conexionesDisco;
}
	
   

}
