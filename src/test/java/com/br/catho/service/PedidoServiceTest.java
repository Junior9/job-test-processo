package com.br.catho.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.catho.model.Pedido;
import br.com.catho.model.dto.NotaDTO;
import br.com.catho.service.PedidoService;

public class PedidoServiceTest {

	@InjectMocks
	private PedidoService pedidoService;
	private Double resposta = 0.0;
	private Pedido pedido;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		pedido = new Pedido(2,2,2,1);
	}
	
	@Test
	public void defaultSemPrilegio() {
		resposta = 987.97;
		pedido = new Pedido(1,1,1,1);
		NotaDTO nota = pedidoService.criaNota(pedido);
		assertNotNull(nota);
		assertEquals(resposta, nota.getTotal());
	}
	
	@Test
	public void unileverComPrilegio() {
		resposta = 934.97;
		pedido = new Pedido(2,0,1,2);
		NotaDTO nota = pedidoService.criaNota(pedido);
		assertNotNull(nota);
		assertEquals(resposta, nota.getTotal());
	}
	
	@Test
	public void appleComPrilegioTest() {
		resposta = 1294.96;
		pedido = new Pedido(0,3,1,4);
		NotaDTO nota = pedidoService.criaNota(pedido);
		assertNotNull(nota);
		assertEquals(resposta, nota.getTotal());
	}
	
	@Test
	public void nikeComPrilegioTest() {
		resposta = 1519.96;
		pedido = new Pedido(0,0,4,3);
		NotaDTO nota = pedidoService.criaNota(pedido);
		assertNotNull(nota);
		assertEquals(resposta, nota.getTotal());
	}
	
	@Test
	public void fordComPrilegioTest() {
		resposta = 2909.91;
		pedido = new Pedido(3,3,3,5);
		NotaDTO nota = pedidoService.criaNota(pedido);
		assertNotNull(nota);
		assertEquals(resposta, nota.getTotal());
	}
}