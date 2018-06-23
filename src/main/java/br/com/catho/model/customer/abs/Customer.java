package br.com.catho.model.customer.abs;

import java.util.List;

import br.com.catho.model.dto.NotaDTO;
import br.com.catho.model.inter.Previlegio;
import br.com.catho.model.inter.Produto;
import br.com.catho.model.util.Classificador;
import br.com.catho.model.util.TipoPerfil;

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
	
	public NotaDTO criaNota(Classificador classificador,TipoPerfil tipo) {
		if(temPrivilegio(classificador)) {
			return new NotaDTO(desconto(classificador),produtosComBonus(classificador),classificador,tipo);
		}
		return new NotaDTO(totalSemDesconto(),classificador.getProdutos(),classificador,tipo);
	}
	
	public Double totalSemDesconto() {
		Double resultado = ZERO;
		for (Produto produto : produtos) {
			resultado += produto.getValor();
		}
		return resultado;
	}
}