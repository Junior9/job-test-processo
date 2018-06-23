package com.br.catho.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.catho.model.customer.Nike;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.dto.NotaDTO;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;
import br.com.catho.model.util.Classificador;
import br.com.catho.model.util.TipoPerfil;

public class NikeTest {

	private Double resultado = 0.0;
	private Customer customer;
	private NotaDTO nota;
	
	@Before
	public void init() {
		customer = new Nike();
	}
	
	@Test
	public void calculaNikeSemPrivilegioTest() {
		resultado = 987.97;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.NIKE);
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaNikeComPrivilegioTest() {
		resultado = 2112.94;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.NIKE);
		assertEquals(6,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaNikeComMultiplosProdutosTest() {
		resultado = 4601.87;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()),TipoPerfil.NIKE);
		assertEquals(13,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
}
