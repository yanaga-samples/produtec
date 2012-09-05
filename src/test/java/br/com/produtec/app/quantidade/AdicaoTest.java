package br.com.produtec.app.quantidade;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AdicaoTest {

	@Test
	public void somar() {
		QuantidadeFactory.INSTANCE.setCasasDecimais(2);
		Quantidade somando1 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("1244.33"));
		Quantidade somando2 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("12.56"));
		Quantidade somando3 = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("43.22"));
		Quantidade resultado = Adicao.newAdicao(somando1).somando(somando2).somando(somando3).somar();
		assertEquals(new BigDecimal("1300.11"), resultado.valor);
	}

}
