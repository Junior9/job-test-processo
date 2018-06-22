package br.com.catho.model.customer.abs;

import java.util.List;

import br.com.catho.model.Classificador;
import br.com.catho.model.Nota;
import br.com.catho.model.inter.Previlegio;
import br.com.catho.model.inter.Produto;

public abstract class Customer implements Previlegio{

	private static final Double ZERO = 0.0;
	protected List<Produto> produtos;
	
	public void add(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> getProdutos(){
		return this.produtos;
	}
	
	public Double getTotal(Classificador classificador) {
		if(temPrivilegio(classificador)) {
			return desconto(classificador);
		}
		return totalSemDesconto();
	}
	
	public Nota criaNota(Classificador classificador) {
		if(temPrivilegio(classificador)) {
			return new Nota(desconto(classificador),produtosComBonus(classificador));
		}
		return new Nota(totalSemDesconto(),classificador.getProdutos());
	}
	
	public Double totalSemDesconto() {
		Double resultado = ZERO;
		for (Produto produto : produtos) {
			resultado += produto.getValor();
		}
		return resultado;
	}
}