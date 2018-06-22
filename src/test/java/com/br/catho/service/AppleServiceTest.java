package com.br.catho.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.catho.model.Classificador;
import br.com.catho.model.Nota;
import br.com.catho.model.customer.Apple;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;

public class AppleServiceTest {
	
	private Double resultado = 0.0;
	private Customer customer;
	private Nota nota;
	
	@Before
	public void init() {
		customer = new Apple();
	}
	
	@Test
	public void calculaAppleSemPrivilegioTest() {
		resultado = 664.98;
		customer.add(new Classic());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()));
		assertEquals(2,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaAppleComPrivilegioTest() {
		resultado = 964.97;
		customer.add(new Classic());
		customer.add(new Premium());
		customer.add(new Standout());
		
		nota = customer.criaNota(new Classificador(customer.getProdutos()));
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

		nota = customer.criaNota(new Classificador(customer.getProdutos()));
		assertEquals(13,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}

}
