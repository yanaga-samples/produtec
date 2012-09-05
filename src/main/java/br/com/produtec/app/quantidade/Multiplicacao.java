package br.com.produtec.app.quantidade;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

public class Multiplicacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Quantidade multiplicando;

	private final List<Quantidade> multiplicadores = Lists.newLinkedList();

	private Multiplicacao(Quantidade multiplicando) {
		this.multiplicando = multiplicando;
	}

	public static Multiplicacao newMultiplicacao(Quantidade multiplicando) {
		checkNotNull(multiplicando, "Multiplicando não pode ser nulo.");
		return new Multiplicacao(multiplicando);
	}

	public Multiplicacao multiplicando(Quantidade multiplicando) {
		checkNotNull(multiplicando, "Multiplicando não pode ser nulo.");
		multiplicadores.add(multiplicando);
		return this;
	}

	public Quantidade multiplicar() {
		BigDecimal resultado = this.multiplicando.valor;
		for (Quantidade multiplicador: multiplicadores) {
			resultado = resultado.multiply(multiplicador.valor);
		}
		return QuantidadeFactory.INSTANCE.newQuantidade(resultado);
	}

}