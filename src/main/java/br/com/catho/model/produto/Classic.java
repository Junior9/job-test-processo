package br.com.catho.model.produto;

import br.com.catho.model.inter.Produto;
import br.com.catho.model.util.TipoProduto;

public class Classic implements Produto {
	
	private final Double VALOR = 269.99;

	public Double getValor() {
		return VALOR;
	}

	@Override
	public TipoProduto getTipo() {
		return TipoProduto.CLASSIC;
	}
	
}
