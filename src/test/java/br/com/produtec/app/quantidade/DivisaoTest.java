package br.com.produtec.app.quantidade;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.produtec.app.quantidade.Divisao;
import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeFactory;

public class DivisaoTest {

	@Test
	public void dividirComDuasQuantidades() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		Quantidade dividendo = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("123456.00"));
		Quantidade divisor = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("56.00"));

		Quantidade resultado = Divisao.newDivisao(dividendo).divisor(divisor)
				.dividir();
		assertEquals(new BigDecimal("2204.571"), resultado.valor);
	}

	@Test
	public void dividirComQuatroQuantidades() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		Quantidade dividendo = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("123456.00"));
		Quantidade divisor1 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("56.00"));
		Quantidade divisor2 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("12.13"));
		Quantidade divisor3 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("4.5678"));

		Quantidade resultado = Divisao.newDivisao(dividendo).divisor(divisor1).
				divisor(divisor2).divisor(divisor3)
				.dividir();
		assertEquals(new BigDecimal("39.787"), resultado.valor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void divisorZero() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		Quantidade dividendo = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("123456.00"));
		Quantidade divisor = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.00"));
		Divisao.newDivisao(dividendo).divisor(divisor).dividir();
	}

}