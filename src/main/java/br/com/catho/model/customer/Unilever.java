package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.Classificador;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;
import br.com.catho.model.produto.Classic;

public class Unilever extends Customer {
	
	public Unilever(){
		this.produtos = new ArrayList<Produto>();
	}

	@Override
	public Boolean temPrivilegio(Classificador classificador) {
		return (classificador.getListClassic().size() >= 2);
	}

	@Override
	public Double desconto(Classificador classificador) {
		return totalSemDesconto();
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		int x = classificador.getListClassic().size()/2;
		for(int index = 0;index < x; index++) {
			classificador.add(new Classic());
		}
		return classificador.getProdutos();
	}
}