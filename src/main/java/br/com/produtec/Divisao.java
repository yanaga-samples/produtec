package br.com.produtec;

import static br.com.produtec.Quantidade.ARREDONDAMENTO_PADRAO;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

public class Divisao implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Quantidade dividendo;

	private final List<Quantidade> divisores = Lists.newLinkedList();

	private Divisao(Quantidade dividendo) {
		this.dividendo = dividendo;
	}

	public static Divisao newDivisao(Quantidade dividendo) {
		checkNotNull(dividendo, "Dividendo não pode ser nulo.");
		return new Divisao(dividendo);
	}

	public Divisao divisor(Quantidade divisor) {
		checkNotNull(divisor, "Divisor não pode ser nulo.");
		checkArgument(!divisor.isZero(), "Divisor não pode ser zero.");
		divisores.add(divisor);
		return this;
	}

	public Quantidade dividir() {
		BigDecimal resultado = this.dividendo.valor;
		for (Quantidade divisor: divisores) {
			resultado = resultado.divide(divisor.valor, ARREDONDAMENTO_PADRAO);
		}
		return QuantidadeFactory.INSTANCE.newQuantidade(resultado);
	}

}