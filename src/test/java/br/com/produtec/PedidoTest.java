package br.com.produtec;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PedidoTest {

	@Test
	public void equals() {
		Pedido pedido1 = Pedido.newPedido(123);
		Pedido pedido2 = Pedido.newPedido(123);
		Pedido pedido3 = Pedido.newPedido(321);
		assertEquals(pedido1, pedido2);
		assertFalse(pedido1.equals(pedido3));
		assertFalse(pedido2.equals(321));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void cancelamentosImutavel() {
		Pedido pedido = Pedido.newPedido(123);
		List<Cancelamento> cancelamentos = pedido.getCancelamentos();
		cancelamentos.add(Cancelamento.newCancelamento(pedido));
	}

}
