package br.com.produtec;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.Test;

public class CancelamentoTest {

	@Test
	public void equals() {
		Pedido pedido = Pedido.newPedido(123);
		DateTimeUtils.setCurrentMillisFixed(new DateTime(2012, 8, 31, 11, 46, 15).getMillis());
		Cancelamento cancelamento1 = Cancelamento.newCancelamento(pedido);
		Cancelamento cancelamento2 = Cancelamento.newCancelamento(pedido);
		assertEquals(cancelamento1, cancelamento2);
		DateTimeUtils.setCurrentMillisFixed(new DateTime(2012, 8, 31, 11, 49, 15).getMillis());
		Cancelamento cancelamento3 = Cancelamento.newCancelamento(pedido);
		assertFalse(cancelamento1.equals(cancelamento3));
	}

}