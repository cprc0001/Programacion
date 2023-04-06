package logico;

import java.util.ArrayList;



public class Tienda {

	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<User> misUsers;
	private static User loginUser;
	private static final long serialVersionUID = 1L;
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
		misUsers = new ArrayList<>();
		
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

	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
	}

	public static User getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(User loginUser) {
		Tienda.loginUser = loginUser;
	}

	public static Tienda getTienda() {
		return tienda;
	}

	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
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

	public Componente EncontrarComponente(String codigo) {
		Componente aux = null;
		for (Componente comp : misComponentes) {
			if (comp.getCodigo().equalsIgnoreCase(codigo)) {
				aux = comp;
			}
		}
		return aux;
	}

	public void EliminarComponente(Componente selected) {
		misComponentes.remove(selected);
		
	}
	
	public void ModificarCliente(Cliente cliente) { 
	
	}

	public Cliente EncontrarCliente(String cedula) {
		Cliente aux= null;
		for (Cliente cliente : getMisClientes()) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				aux = cliente ;
			}
		}
		return aux;
	}

	public Combo EncontrarCombo(String codigo) {
		Combo aux = null;
		for (Combo combo : misCombos) {
			if (combo.getCodigo().equalsIgnoreCase(codigo)) {
				aux = combo;
			}
		}
		return aux;
	}

	public void EliminarCombo(Combo selected) {
		misCombos.remove(selected);
		
	}
	
	
	
}
