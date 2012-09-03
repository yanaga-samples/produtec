package br.com.produtec;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class QuantidadeFactoryTest {

	@Test
	public void casasDecimais() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(4);
		Quantidade quantidade = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal(2));
		assertEquals(new BigDecimal("2.0000"), quantidade.valor);
	}

}