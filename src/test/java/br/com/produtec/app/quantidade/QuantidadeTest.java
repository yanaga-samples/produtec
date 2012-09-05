package br.com.produtec.app.quantidade;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class QuantidadeTest {

	@Test
	public void zero() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		Quantidade quantidade = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.0000"));
		assertTrue(quantidade.isZero());
	}

	@Test
	public void naoZero() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		Quantidade quantidade = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.02"));
		assertFalse(quantidade.isZero());
	}

	@Test
	public void isNegativa() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		Quantidade positivo = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.02"));
		assertFalse(positivo.isNegativa());
		Quantidade zero = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.00"));
		assertFalse(zero.isNegativa());
		Quantidade negativa = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("-2.00"));
		assertTrue(negativa.isNegativa());
	}

}