package com.br.catho.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.catho.model.Classificador;
import br.com.catho.model.Nota;
import br.com.catho.model.TipoPerfil;
import br.com.catho.model.customer.Ford;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;

public class FordServiceTest {

	private Double resultado = 0.0;
	private Customer customer;
	private Nota nota;
	
	@Before
	public void init() {
		customer = new Ford();
	}
	
	@Test
	public void calculaFordSemPrivilegioTest() {
		resultado = 664.98;
		customer.add(new Classic());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD);
		assertEquals(2,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaFordComClassicPrivilegioTest() {
		resultado = 1079.96;
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD);
		assertEquals(5,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaFordComMuitoClassicPrivilegioTest() {
		resultado = 3509.869999999999;
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD);
		assertEquals(16,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaFordComStandouPrivilegioTest() {
		resultado = 974.97;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD);
		assertEquals(3,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaFordComMuitoStandouPrivilegioTest() {
		resultado = 2214.9300000000003;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD );
		assertEquals(7,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaFordComPremiumPrivilegioTest() {
		resultado = 1439.96;
		customer.add(new Classic());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD );
		assertEquals(4,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaFordComPremiumANDStandouPrivilegioTest() {
		resultado = 1749.95;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD);
		assertEquals(5,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaFordComPremiumANDClassicPrivilegioTest() {
		resultado = 2249.9300000000003;
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD);
		assertEquals(8,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}

	@Test
	public void calculaFordComTodosPrivilegioTest() {
		resultado = 2559.92;
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.FORD);
		assertEquals(9,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
}