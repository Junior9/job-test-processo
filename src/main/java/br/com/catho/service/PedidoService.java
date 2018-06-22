package br.com.catho.service;

import org.springframework.stereotype.Service;

import br.com.catho.model.Classificador;
import br.com.catho.model.Nota;
import br.com.catho.model.Pedido;
import br.com.catho.model.TipoPerfil;
import br.com.catho.model.customer.Apple;
import br.com.catho.model.customer.Default;
import br.com.catho.model.customer.Ford;
import br.com.catho.model.customer.Nike;
import br.com.catho.model.customer.Unilever;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;

@Service
public class PedidoService {

	public Nota criaNota(Pedido pedido) {
		
		Customer customer = getPerfil(getP(pedido.getPerfil()));
		
		for(int x=0;x<pedido.getClassic();x++) {
			customer.add(new Classic());
		}
		
		for(int x=0;x<pedido.getStandout();x++) {
			customer.add(new Standout());
		}
		
		for(int x=0;x<pedido.getPremium();x++) {
			customer.add(new Premium());
		}
		return customer.criaNota(new Classificador(customer.getProdutos()),getP(pedido.getPerfil()));
	}


	private TipoPerfil getP(int perfil) {
		
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
