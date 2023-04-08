package logico;

import java.util.ArrayList;
import java.io.Serializable;



public class Tienda implements Serializable {

	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<User> misUsers;
	private static User loginUser;
	private static final long serialVersionUID = 1L;
	public static Tienda tienda = null;
	public int codComb = 1;
	public int codF= 1;
	public int codComp = 1;


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
		int	i=0;
		boolean encontrado = false;
		while (!encontrado && i< misComponentes.size()){
			if (misComponentes.get(i).getCodigo().equalsIgnoreCase(codigo)){
				encontrado = true;
				aux=misComponentes.get(i);
			}
			i++;
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
		int	i=0;
		boolean encontrado = false;
		while (!encontrado && i< misClientes.size()){
			if (misClientes.get(i).getCedula().equalsIgnoreCase(cedula)){
				encontrado = true;
				aux=misClientes.get(i);
			}
			i++;
		}
		return aux;
	}

	public Combo EncontrarCombo(String codigo) {
		Combo aux = null;
		int	i=0;
		boolean encontrado = false;
		while (!encontrado && i< misClientes.size()){
			if (misCombos.get(i).getCodigo().equalsIgnoreCase(codigo)){
				encontrado = true;
				aux=misCombos.get(i);
			}
			i++;
		
		}
		return aux;
	}

	public void EliminarCombo(Combo selected) {
		misCombos.remove(selected);

	}

	public void regUser (User user) {
		misUsers.add(user);
	}

	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		int	i=0;
		boolean encontrado = false;
		while (!encontrado && i< misUsers.size()){
			if (misUsers.get(i).getUserName().equals(text)&& misUsers.get(i).getPass().equals(text2)){
				encontrado = true;
				loginUser = misUsers.get(i);
				login = true;
			}
			i++;
		}
		return login;
	}

	public void ModificarUsuario(User user) { 

	}

	public User EncontrarUsuario(String usuario) {
		User aux = null;
		
		int	i=0;
		boolean encontrado = false;
		while (!encontrado && i< misUsers.size()){
			if (misUsers.get(i).getUserName().equals(usuario)){
				encontrado = true;
				aux=misUsers.get(i);
			}
			i++;
		}
		return aux;
	}


}
