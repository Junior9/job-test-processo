package br.com.catho.model.dto;

import java.util.List;

import br.com.catho.model.inter.Produto;
import br.com.catho.model.util.Classificador;
import br.com.catho.model.util.TipoPerfil;

public class NotaDTO {
	
	private List<Produto> produtos;
	private String perfil;
	private Double total;
	private int classicTotal;
	private int standoutTotal;
	private int premiumTotal;
	
	public NotaDTO(Double total, List<Produto> produtos,Classificador classificador,TipoPerfil perfil) {
		this.total = total;
		this.produtos = produtos;
		this.classicTotal = classificador.getListClassic().size();
		this.standoutTotal = classificador.getListStandout().size();
		this.premiumTotal = classificador.getListPremium().size();
		this.perfil = perfil.toString();
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
}