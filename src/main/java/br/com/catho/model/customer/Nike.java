package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;
import br.com.catho.model.util.Classificador;

public class Nike extends Customer{
	
	private final int porcentagemDescontoPremium = 15;
	private final int BONUSPREMIUM = 4;
	
	public Nike(){
		this.produtos = new ArrayList<Produto>();
	}

	@Override
	public Boolean temPrivilegio(Classificador classificador) {
		return classificador.getListPremium().size() >= BONUSPREMIUM;
	}

	@Override
	public Double desconto(Classificador classificador) {
		Double totalClassic = classificador.somaSemDesconto(classificador.getListClassic());
		Double totalStandout = classificador.somaSemDesconto(classificador.getListStandout());
		Double totalPremium = classificador.somaSemDesconto(classificador.getListPremium());
		Double totalFinalDesconto = totalPremium - (porcentagemDescontoPremium * classificador.getListPremium().size());
		return totalClassic + totalFinalDesconto + totalStandout;
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		return produtos;
	}
}