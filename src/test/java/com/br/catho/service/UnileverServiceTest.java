package com.br.catho.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.catho.model.Classificador;
import br.com.catho.model.Nota;
import br.com.catho.model.TipoPerfil;
import br.com.catho.model.customer.Unilever;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;

public class UnileverServiceTest {
	
	private Double resultado = 0.0;
	private Customer customer;
	private Nota nota;
	
	@Before
	public void init() {
		customer = new Unilever();
	}
	
	@Test
	public void calculaUnileverSemPrivilegioTest() {
		resultado = 269.99;
		customer.add(new Classic());
		assertEquals(resultado,customer.getTotal(new Classificador(customer.getProdutos())));
	}
	
	@Test
	public void calculaComUmProdutoBonusTest() {
		resultado = 539.98;
		customer.add(new Classic());
		customer.add(new Classic());
		
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.UNILEVER );
		assertEquals(3,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());
	}
	
	@Test
	public void calculaComDoisProdutosBonusTest() {
		resultado = 1079.96;
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Classic());
		
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.UNILEVER);
		assertEquals(6,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());
	}
	
	@Test
	public void calculaMaisDeUmProdutoComUmProdutoBonusTest() {
		resultado = 1903.94;
		customer.add(new Classic());
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Premium());
		
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.UNILEVER);
		assertEquals(7,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());
	}
	
	@Test
	public void calculaMaisDeUmProdutoSemProdutoBonusTest() {
		resultado = 1633.95;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Premium());
		
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.UNILEVER);
		assertEquals(5,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());
	}
}