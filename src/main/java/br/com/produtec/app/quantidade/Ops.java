package br.com.produtec.app.quantidade;

import java.math.BigDecimal;

public class Ops {

	private Ops() {
	}

	public static Adicao adicao(Quantidade somando) {
		return Adicao.newAdicao(somando);
	}

	public static Adicao adicao() {
		return Adicao.newAdicao(QuantidadeFactory.INSTANCE.newQuantidade(BigDecimal.ZERO));
	}

	public static Subtracao subtracao(Quantidade minuendo) {
		return Subtracao.newSubtracao(minuendo);
	}

	public static Multiplicacao multiplicacao(Quantidade multiplicando) {
		return Multiplicacao.newMultiplicacao(multiplicando);
	}

	public static Divisao divisao(Quantidade dividendo) {
		return Divisao.newDivisao(dividendo);
	}

}