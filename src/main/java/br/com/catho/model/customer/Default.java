package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.Classificador;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;

public class Default extends Customer{
	
	private static final Double ZERO = 0.0;
	
	public Default(){
		this.produtos = new ArrayList<Produto>();
	}

	@Override
	public Boolean temPrivilegio(Classificador classificador) {
		return Boolean.FALSE;
	}

	@Override
	public Double desconto(Classificador classificador) {
		return ZERO;
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		return this.produtos;
	}
}