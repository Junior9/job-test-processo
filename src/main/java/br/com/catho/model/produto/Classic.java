package br.com.catho.model.produto;

import br.com.catho.model.TipoProduto;
import br.com.catho.model.inter.Produto;

public class Classic implements Produto {

	public Double getValor() {
		return 269.99;
	}

	@Override
	public TipoProduto getTipo() {
		return TipoProduto.CLASSIC;
	}
	
}
