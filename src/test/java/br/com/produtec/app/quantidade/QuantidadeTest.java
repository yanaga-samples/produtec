package br.com.produtec.app.quantidade;

import static org.junit.Assert.assertEquals;
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

	@Test
	public void percentual() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		Quantidade quantidade = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("24.000"));
		Percentual percentual = Percentual.newPercentual(new BigDecimal("12.5"));
		Quantidade resultado = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("3.000"));
		assertEquals(resultado, quantidade.percentual(percentual));
	}

}