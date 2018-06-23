package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.util.Classificador;

public class Ford extends Customer {

	private final int porcentagemDescontoStandout = 13;
	private final int porcentagemDescontoPremium = 5;
	private final int BONUSCLASSIC = 4;
	private final int BONUSSTANDOUT = 0;
	private final int BONUSLPREMIUM = 3;
	
	public Ford() {
		this.produtos = new ArrayList<Produto>();
	}
	
	@Override
	public Boolean temPrivilegio(Classificador classificador) {
		return temPrivilegioClassic(classificador) || temPrivilegioStandout(classificador) || temPrivilegioPremium(classificador);
	}

	@Override
	public Double desconto(Classificador classificador) {
		Double totalClassic = classificador.somaSemDesconto(classificador.getListClassic());
		Double totalStandout = classificador.somaSemDesconto(classificador.getListStandout());
		Double totalPremium = classificador.somaSemDesconto(classificador.getListPremium());
		totalStandout = descontoStandoun(classificador,totalStandout);
		totalPremium = descontoPremium(classificador,totalPremium);
		return totalClassic + totalStandout + totalPremium;
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		int x = classificador.getListClassic().size()/BONUSCLASSIC;
		for(int index = 0;index < x; index++) {
			classificador.add(new Classic());
		}
		return classificador.getProdutos();
	}
	
	private Boolean temPrivilegioClassic(Classificador classificador) {
		return classificador.getListClassic().size() >= BONUSCLASSIC;
	}
	
	private Boolean temPrivilegioStandout(Classificador classificador) {
		return classificador.getListStandout().size() > BONUSSTANDOUT;
	}
	
	private Boolean temPrivilegioPremium(Classificador classificador) {
		return classificador.getListPremium().size() >= BONUSLPREMIUM;
	}

	private Double descontoStandoun(Classificador classificador, Double totalPremium) {
		if(temPrivilegioStandout(classificador)) 
			totalPremium = totalPremium - (porcentagemDescontoStandout * classificador.getListStandout().size());
		return totalPremium;
	}

	private Double descontoPremium(Classificador classificador, Double totalStandout) {
		if(temPrivilegioPremium(classificador)) 
			totalStandout = totalStandout - (porcentagemDescontoPremium * classificador.getListPremium().size());
		return totalStandout;
	}
}