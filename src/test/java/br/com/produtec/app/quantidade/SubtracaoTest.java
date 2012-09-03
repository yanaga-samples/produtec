package br.com.produtec.app.quantidade;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class SubtracaoTest {

	@Test
	public void subtrair() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(2);
		Quantidade minuendo = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("1200.00"));
		Quantidade subtraendo1 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("12.15"));
		Quantidade subtraendo2 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("60.33"));
		Quantidade resultado = Subtracao.newSubtracao(minuendo).subtraendo(subtraendo1).subtraendo(subtraendo2)
				.subtrair();
		assertEquals(new BigDecimal("1127.52"), resultado.valor);
	}

}
