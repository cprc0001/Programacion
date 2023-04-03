package logico;

import java.util.ArrayList;

public class Tienda {

	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	public static Tienda tienda = null;
	public static int codComb = 1;
	public static int codF= 1;
	public static int codComp = 1;

	
	
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
	
	public void insertarCombo(Combo combo) {
		misCombos.add(combo);
		codComb++;
		
	}
	
	public void insertarComponente(Componente componente) {
		misComponentes.add(componente);
		codComp++;
	}
	
	public void insertarFactura (Factura factura) {
		misFacturas.add(factura);
		codF++;
	}
	
	public void insertarCliente (Cliente cliente) {
		misClientes.add(cliente);
	}
	
	
	
}
