package logico;

import java.util.ArrayList;

public class Combo {

	private String codigo;
	private ArrayList<Componente> misComponentes;
	private String nombreComb;
	private float des;
	private float totalD;
	
	public Combo(String codigo, ArrayList<Componente> misComponentes, String nombreComb, float des, float totalD) {
		super();
		this.codigo = codigo;
		this.misComponentes = misComponentes;
		this.nombreComb = nombreComb;
		this.des = des;
		this.totalD = totalD;
	}

	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public String getNombreComb() {
		return nombreComb;
	}

	public void setNombreComb(String nombreComb) {
		this.nombreComb = nombreComb;
	}

	public float getDes() {
		return des;
	}

	public void setDes(float des) {
		this.des = des;
	}

	public float getTotalD() {
		return totalD;
	}

	public void setTotalD(float totalD) {
		this.totalD = totalD;
	}
	
	
	
	
}
