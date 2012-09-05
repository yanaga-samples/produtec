package br.com.produtec.app.quantidade;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class MultiplicacaoTest {

	@Test
	public void multiplicar() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(2);
		Quantidade multiplicando = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("33.33"));
		Quantidade multiplicador1 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("12.56"));
		Quantidade multiplicador2 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("43.22"));
		Quantidade resultado = Multiplicacao.newMultiplicacao(multiplicando).multiplicando(multiplicador1)
				.multiplicando(multiplicador2).multiplicar();
		assertEquals(new BigDecimal("18092.96"), resultado.valor);
	}

}
