package com.br.catho.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.catho.model.customer.Default;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;
import br.com.catho.model.util.Classificador;

public class DefaultTest {
	
	private final Double classicValor = 269.99;
	private final Double standoutValor = 322.99;
	private final Double premiumValor = 394.99;
	
	@Test
	public void calculaDefaultClassicTest() {
		Customer customer = new Default();
		customer.add(new Classic());
		assertEquals(classicValor,customer.getTotal(new Classificador(customer.getProdutos())));
	}
	
	@Test
	public void calculaDefaultStandoutTest() {
		Customer customer = new Default();
		customer.add(new Standout());
		assertEquals(standoutValor,customer.getTotal(new Classificador(customer.getProdutos())));
	}
	
	@Test
	public void calculaDefaultPremiumTest() {
		Customer customer = new Default();
		customer.add(new Premium());
		assertEquals(premiumValor,customer.getTotal(new Classificador(customer.getProdutos())));
	}
	
	@Test
	public void calculaDefaultMultiplesProductsTest() {
		Customer customer = new Default();
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		Double resultado = classicValor + premiumValor + standoutValor;
		assertEquals(resultado ,customer.getTotal(new Classificador(customer.getProdutos())));
	}
}