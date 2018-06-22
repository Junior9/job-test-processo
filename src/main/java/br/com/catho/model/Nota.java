package br.com.catho.model;

import java.util.List;

import br.com.catho.model.inter.Produto;

public class Nota {
	
	private List<Produto> produtos;
	private String perfil;
	private Double total;
	private int classicTotal;
	private int standoutTotal;
	private int premiumTotal;
	
	public Nota(Double total, List<Produto> produtos,int classicTotal,int standoutTotal,int premiumTotal,String perfil) {
		this.total = total;
		this.produtos = produtos;
		this.classicTotal = classicTotal;
		this.standoutTotal = standoutTotal;
		this.premiumTotal = premiumTotal;
		this.perfil = perfil;
	}
	
	public int getClassicTotal() {
		return classicTotal;
	}

	public int getStandoutTotal() {
		return standoutTotal;
	}

	public int getPremiumTotal() {
		return premiumTotal;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public Double getTotal() {
		return total;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Nota imprime() {
		return null;
		//this.classicTotal  = 
	}
	
}