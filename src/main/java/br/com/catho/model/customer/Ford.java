package br.com.catho.model.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.catho.model.Classificador;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.inter.Produto;
import br.com.catho.model.produto.Classic;

public class Ford extends Customer {

	private final int porcentagemDescontoStandout = 13;
	private final int porcentagemDescontoPremium = 5;
	
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
		
		if(temPrivilegioStandout(classificador)) {
			totalStandout = totalStandout - (porcentagemDescontoStandout * classificador.getListStandout().size());
		}
		
		if(temPrivilegioPremium(classificador)) {
			totalPremium = totalPremium - (porcentagemDescontoPremium * classificador.getListPremium().size());
		}
		
		return totalClassic + totalStandout + totalPremium;
		
	}

	@Override
	public List<Produto> produtosComBonus(Classificador classificador) {
		int x = classificador.getListClassic().size()/4;
		for(int index = 0;index < x; index++) {
			classificador.add(new Classic());
		}
		return classificador.getProdutos();
	}
	
	private Boolean temPrivilegioClassic(Classificador classificador) {
		return classificador.getListClassic().size() >= 4;
	}
	
	private Boolean temPrivilegioStandout(Classificador classificador) {
		return classificador.getListStandout().size() > 0;
	}
	
	private Boolean temPrivilegioPremium(Classificador classificador) {
		return classificador.getListPremium().size() >= 3;
	}
}