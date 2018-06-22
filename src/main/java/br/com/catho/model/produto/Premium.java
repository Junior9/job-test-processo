package br.com.catho.model.produto;

import br.com.catho.model.TipoProduto;
import br.com.catho.model.inter.Produto;

public class Premium implements Produto{

	public Double getValor() {
		return 394.99;
	}

	@Override
	public TipoProduto getTipo() {
		return TipoProduto.PREMIUM;
	}

}
