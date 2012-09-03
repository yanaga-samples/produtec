package br.com.produtec.app.quantidade;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

public class Subtracao implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Quantidade minuendo;

	private final List<Quantidade> subtraendos = Lists.newLinkedList();

	private Subtracao(Quantidade minuendo) {
		this.minuendo = minuendo;
	}

	public static Subtracao newSubtracao(Quantidade minuendo) {
		checkNotNull(minuendo, "Minuendo não pode ser nulo.");
		return new Subtracao(minuendo);
	}

	public Subtracao subtraendo(Quantidade subtraendo) {
		checkNotNull(subtraendo, "Subtraendo não pode ser nulo.");
		subtraendos.add(subtraendo);
		return this;
	}

	public Quantidade subtrair() {
		BigDecimal resultado = this.minuendo.valor;
		for (Quantidade subtraendo: subtraendos) {
			resultado = resultado.subtract(subtraendo.valor);
		}
		return QuantidadeFactory.INSTANCE.newQuantidade(resultado);
	}

}
