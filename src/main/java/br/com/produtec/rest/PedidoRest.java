package br.com.produtec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.produtec.app.pedido.facade.PedidoFacade;

@Controller
@RequestMapping("/pedido")
public class PedidoRest {

	@Autowired
	private PedidoFacade pedidoFacade;

	@ResponseBody
	@RequestMapping(value = "/numero", method = RequestMethod.GET, produces = "text/plain")
	public String numeroPedido() {
		return pedidoFacade.proximoNumeroPedido().toString();
	}

}