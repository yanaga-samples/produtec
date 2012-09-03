package br.com.produtec;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class DinheiroTest {

	@Test(expected = NullPointerException.class)
	public void dinheiroNulo() {
		Dinheiro.newReal(null);
	}

	@Test
	public void zeroReal() {
		assertTrue(Dinheiro.newReal(new BigDecimal("0.00")).isZero());
		assertTrue(Dinheiro.newReal(new BigDecimal("0")).isZero());
		assertTrue(Dinheiro.newReal(new BigDecimal("0.0000")).isZero());
	}

	@Test
	public void zeroDolar() {
		assertTrue(Dinheiro.newDolar(new BigDecimal("0.00")).isZero());
		assertTrue(Dinheiro.newDolar(new BigDecimal("0")).isZero());
		assertTrue(Dinheiro.newDolar(new BigDecimal("0.0000")).isZero());
	}

}