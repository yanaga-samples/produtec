package br.com.produtec.app.pedido.facade;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.config.root.ProdutecConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProdutecConfig.class)
@TransactionConfiguration
public class PedidoFacadeIT {

	@Autowired
	private PedidoFacade pedidoFacade;

	@Test
	public void novoPedido() {
		Pedido pedido = pedidoFacade.novoPedido();
		assertEquals(1, pedido.getNumero().intValue());
		pedido = pedidoFacade.novoPedido();
		assertEquals(2, pedido.getNumero().intValue());
		pedido = pedidoFacade.novoPedido();
		assertEquals(3, pedido.getNumero().intValue());
		pedido = pedidoFacade.novoPedido();
		assertEquals(4, pedido.getNumero().intValue());
		pedido = pedidoFacade.novoPedido();
		assertEquals(5, pedido.getNumero().intValue());
	}

}
