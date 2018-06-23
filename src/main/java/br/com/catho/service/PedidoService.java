package br.com.catho.service;

import org.springframework.stereotype.Service;

import br.com.catho.model.Pedido;
import br.com.catho.model.customer.Apple;
import br.com.catho.model.customer.Default;
import br.com.catho.model.customer.Ford;
import br.com.catho.model.customer.Nike;
import br.com.catho.model.customer.Unilever;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.dto.NotaDTO;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;
import br.com.catho.model.util.Classificador;
import br.com.catho.model.util.TipoPerfil;

@Service
public class PedidoService {

	public NotaDTO criaNota(Pedido pedido) {
		int index = 0;
		Customer customer = getPerfil(convertePerfil(pedido.getPerfil()));

		for(index=0;index<pedido.getClassic();index++) {
			customer.add(new Classic());
		}
		for(index=0;index<pedido.getStandout();index++) {
			customer.add(new Standout());
		}
		for(index=0;index<pedido.getPremium();index++) {
			customer.add(new Premium());
		}
		return customer.criaNota(new Classificador(customer.getProdutos()),convertePerfil(pedido.getPerfil()));
	}


	private TipoPerfil convertePerfil(int perfil) {
		
		TipoPerfil tipo = null;
		switch (perfil) {
		case 1:
			tipo = TipoPerfil.DEFAULT;
			break;
			
		case 2:
			tipo =  TipoPerfil.UNILEVER;
			break;
			
		case 3:
			tipo = TipoPerfil.NIKE;
			break;
			
		case 4:
			tipo =  TipoPerfil.APPLE;
			break;
			
		case 5:
			tipo =  TipoPerfil.FORD;
			break;
		default:
			break;
		}
		return tipo;
	}


	private Customer getPerfil(TipoPerfil perfil) {
		Customer customer = null;
		
		switch (perfil) {
		case DEFAULT:
			customer = new Default();
			break;
			
		case UNILEVER:
			customer = new Unilever();
			break;
			
		case APPLE:
			customer = new Apple();
			break;
			
		case NIKE:
			customer = new Nike();
			break;
			
		case FORD:
			customer = new Ford();
			break;

		default:
			break;
		}
		return customer;
	}
}