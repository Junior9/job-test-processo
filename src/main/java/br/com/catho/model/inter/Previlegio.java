package br.com.catho.model.inter;

import java.util.List;

import br.com.catho.model.Classificador;

public interface Previlegio {

	Boolean temPrivilegio(Classificador classificador);
	Double desconto(Classificador classificador);
	List<Produto> produtosComBonus(Classificador classificador);
}