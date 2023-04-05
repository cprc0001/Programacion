package logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private Cliente cliente;
	private ArrayList<Combo> misCombos;
	private ArrayList<Componente> misComponentes;
	
	public Factura(String codigo, Cliente cliente, ArrayList<Combo> misCombos, ArrayList<Componente> misComponentes) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.misCombos = misCombos;
		this.misComponentes = misComponentes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}
	
 
   public float PrecioFactura() {
	float precio=0;
	   for (Combo combo : misCombos) {
		   precio += combo.getTotalD();
	   }
	   
	   for (Componente componente :misComponentes) {
		   precio += componente.getPrecio();
	   }
	
	   return precio;
	     
   }
	
}
