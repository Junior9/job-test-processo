package br.com.catho.model;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.inter.Produto;

public class Classificador {
	
	private List<Produto> produtos;
	private List<Produto> listClassic;
	private List<Produto> listStandout;
	private List<Produto> listPremium;
	private static final Double ZERO = 0.0;
	
	public Classificador(List<Produto> produtos) {
		//this.produtos = produtos;
		selecao(produtos);
	}

	private void selecao(List<Produto> produtos) {
		this.listClassic = new ArrayList<Produto>();
		this.listStandout = new ArrayList<Produto>();
		this.listPremium = new ArrayList<Produto>();
		this.produtos = new ArrayList<Produto>();
		
		for (Produto produto : produtos) {
			add(produto);
		}
	}

	public void add(Produto product) {
		switch (product.getTipo()) {
		
		case CLASSIC:
			listClassic.add(product);
			break;

		case STANDOUT:
			listStandout.add(product);
			break;

		case PREMIUM:
			listPremium.add(product);
			break;
			
		default:
			break;
		}
		this.produtos.add(product);
	}
	
	public List<Produto> getListClassic() {
		return listClassic;
	}
	public List<Produto> getListStandout() {
		return listStandout;
	}
	public List<Produto> getListPremium() {
		return listPremium;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}
	
	public Double somaSemDesconto(List<Produto> produtos) {
		Double resultado = ZERO;
		for (Produto produto : produtos) {
			resultado += produto.getValor();
		}
		return resultado;
	}
}