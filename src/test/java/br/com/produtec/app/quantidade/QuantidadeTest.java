package br.com.produtec.app.quantidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeFactory;

public class QuantidadeTest {

	@Test
	public void multiplicar() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(2);
		Quantidade valor1 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.13"));
		Quantidade valor2 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("3.34"));
		Quantidade valor3 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("4.17"));
		// ERRADO
		// valor1.multiplicar(valor2).multiplicar(valor3);
		Quantidade resultado = valor1.multiplicar(valor2, valor3);
		assertEquals(new BigDecimal("29.67"), resultado.valor);
	}

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

}