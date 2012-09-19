package br.com.produtec.app.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.pedido.facade.PedidoFacade;

@Controller
public class PedidoController {

	@Inject
	private PedidoFacade pedidoFacade;

	private FiltroPedido filtro = new FiltroPedido();

	public Pedido novo() {
		return pedidoFacade.novoPedido();
	}

	public FiltroPedido getFiltro() {
		return filtro;
	}

}