package logico;

import java.util.ArrayList;

public class Tienda {

	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	public static Tienda tienda = null;
	
	
	public Tienda() {
		super();
		misClientes = new ArrayList<>();
		misCombos = new ArrayList<>();
		misComponentes = new ArrayList<>();
		misFacturas = new ArrayList<>();
		
	}
	
	public static Tienda getInstance(){
		if(tienda==null){
			tienda = new Tienda();
		}
		return tienda;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
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

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	
	
	
}
