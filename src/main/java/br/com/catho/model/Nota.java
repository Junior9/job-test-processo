package br.com.catho.model;

import java.util.List;

import br.com.catho.model.inter.Produto;

public class Nota {
	
	private List<Produto> produtos;
	private Double total;

	public Nota(Double total, List<Produto> produtos) {
		this.total = total;
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public Double getTotal() {
		return total;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}