package com.br.catho.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.catho.model.customer.Apple;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.dto.NotaDTO;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;
import br.com.catho.model.util.Classificador;
import br.com.catho.model.util.TipoPerfil;

public class AppleTest {
	
	private Double resultado = 0.0;
	private Customer customer;
	private NotaDTO nota;
	
	@Before
	public void init() {
		customer = new Apple();
	}
	
	@Test
	public void calculaAppleSemPrivilegioTest() {
		resultado = 664.98;
		customer.add(new Classic());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.APPLE);
		assertEquals(2,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaAppleComPrivilegioTest() {
		resultado = 964.97;
		customer.add(new Classic());
		customer.add(new Premium());
		customer.add(new Standout());
		
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.APPLE);
		assertEquals(3,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaAppleComMuitoPrivilegioTest() {
		resultado = 4154.87;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());

		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.APPLE);
		assertEquals(13,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
}
