package br.com.catho.model.produto;

import br.com.catho.model.inter.Produto;
import br.com.catho.model.util.TipoProduto;

public class Standout implements Produto {

	private final Double VALOR = 322.99;

	public Double getValor() {
		return VALOR;
	}

	@Override
	public TipoProduto getTipo() {
		return TipoProduto.STANDOUT;
	}

}
