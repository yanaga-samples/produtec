package br.com.produtec.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.pedido.facade.PedidoFacade;
import br.com.produtec.app.pedido.repository.PedidoRepository;

@Controller
public class PedidoController {

	@Autowired
	private PedidoFacade pedidoFacade;

	@Autowired
	private PedidoRepository pedidoRepository;

	private FiltroPedido filtro = new FiltroPedido();

	public Pedido novo() {
		return pedidoFacade.novoPedido();
	}

	public FiltroPedido getFiltro() {
		return filtro;
	}

	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}

}