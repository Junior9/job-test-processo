package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.Classificador;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;

public class Nike extends Customer{
	
	private final int porcentagemDescontoClassic = 15;
	
	public Nike(){
		this.produtos = new ArrayList<Produto>();
	}

	@Override
	public Boolean temPrivilegio(Classificador classificador) {
		return classificador.getListPremium().size() >= 4;
	}

	@Override
	public Double desconto(Classificador classificador) {
		Double totalClassic = classificador.somaSemDesconto(classificador.getListClassic());
		Double totalStandout = classificador.somaSemDesconto(classificador.getListStandout());
		Double totalPremium = classificador.somaSemDesconto(classificador.getListPremium());
		
		Double totalFinalDesconto = totalPremium - (porcentagemDescontoClassic * classificador.getListPremium().size());
		return totalClassic + totalFinalDesconto + totalStandout;
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		return produtos;
	}
}