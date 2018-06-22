package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.Classificador;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;

public class Apple extends Customer {
	
	private final int porcentagemDescontoClassic = 23;

	public Apple(){
		this.produtos = new ArrayList<Produto>();
	}
	
	@Override
	public Boolean temPrivilegio(Classificador classificador) {
		return classificador.getListStandout().size() > 0;
	}

	@Override
	public Double desconto(Classificador classificador) {
		Double totalClassic = classificador.somaSemDesconto(classificador.getListClassic());
		Double totalStandout = classificador.somaSemDesconto(classificador.getListStandout());
		Double totalPremium = classificador.somaSemDesconto(classificador.getListPremium());
		
		Double totalFinalDesconto = totalStandout - (porcentagemDescontoClassic * classificador.getListStandout().size());
		return totalClassic + totalFinalDesconto + totalPremium;
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		return this.produtos;
	}
}