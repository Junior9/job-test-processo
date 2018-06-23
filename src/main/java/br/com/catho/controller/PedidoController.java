package br.com.catho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.catho.model.Pedido;
import br.com.catho.model.dto.NotaDTO;
import br.com.catho.service.PedidoService;

@RestController
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@PostMapping(value="/pedido/nota",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public NotaDTO save(@RequestBody Pedido pedido) {
		return pedidoService.criaNota(pedido);
	}
}