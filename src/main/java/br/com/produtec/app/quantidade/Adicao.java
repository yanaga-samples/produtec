package br.com.produtec.app.quantidade;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

public class Adicao implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Quantidade somando;

	private final List<Quantidade> somandos = Lists.newLinkedList();

	private Adicao(Quantidade somando) {
		this.somando = somando;
	}

	public static Adicao newAdicao(Quantidade somando) {
		checkNotNull(somando);
		return new Adicao(somando);
	}

	public Adicao somando(Quantidade somando) {
		checkNotNull(somando);
		this.somandos.add(somando);
		return this;
	}

	public Quantidade somar() {
		BigDecimal resultado = somando.valor;
		for (Quantidade somando: somandos) {
			resultado = resultado.add(somando.valor);
		}
		return QuantidadeFactory.INSTANCE.newQuantidade(resultado);
	}

}
