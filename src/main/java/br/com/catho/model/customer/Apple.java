package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;
import br.com.catho.model.util.Classificador;

public class Apple extends Customer {
	
	private final int porcentagemDescontoStandout = 23;
	private final int BONUSCLASSIC = 0;

	public Apple(){
		this.produtos = new ArrayList<Produto>();
	}
	
	@Override
	public Boolean temPrivilegio(Classificador classificador) {
		return classificador.getListStandout().size() > BONUSCLASSIC;
	}

	@Override
	public Double desconto(Classificador classificador) {
		Double totalClassic = classificador.somaSemDesconto(classificador.getListClassic());
		Double totalStandout = classificador.somaSemDesconto(classificador.getListStandout());
		Double totalPremium = classificador.somaSemDesconto(classificador.getListPremium());
		Double totalFinalDesconto = totalStandout - (porcentagemDescontoStandout * classificador.getListStandout().size());
		return totalClassic + totalFinalDesconto + totalPremium;
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		return this.produtos;
	}
}