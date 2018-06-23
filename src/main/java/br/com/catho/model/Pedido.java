package br.com.catho.model;

public class Pedido {
	
	private int perfil;
	private int classic;
	private int standout;
	private int premium;
	
	public Pedido(int classic,int standout,int premium,int perfil){
		this.classic = classic;
		this.standout = standout;
		this.premium = premium;
		this.perfil = perfil;
	}
	
	public int getPerfil() {
		return perfil;
	}
	public int getClassic() {
		return classic;
	}
	public int getStandout() {
		return standout;
	}
	public int getPremium() {
		return premium;
	}
}