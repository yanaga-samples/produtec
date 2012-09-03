package br.com.produtec.app.quantidade;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Quantidade implements Serializable {

	private static final long serialVersionUID = 1L;

	static final RoundingMode ARREDONDAMENTO_PADRAO = RoundingMode.HALF_EVEN;

	final BigDecimal valor;

	Quantidade(BigDecimal valor) {
		checkNotNull(valor, "Valor da quantidade não pode ser nulo.");
		this.valor = valor;
	}

	public Quantidade multiplicar(Quantidade quantidade, Quantidade... demaisQuantidades) {
		checkNotNull(quantidade, "Quantidade a multiplicar não pode ser nula.");
		BigDecimal resultado = this.valor.multiply(quantidade.valor);
		for (Quantidade outra: demaisQuantidades) {
			resultado = resultado.multiply(outra.valor);
		}
		return QuantidadeFactory.INSTANCE.newQuantidade(resultado);
	}

	public boolean isZero() {
		return BigDecimal.ZERO.setScale(valor.scale(), ARREDONDAMENTO_PADRAO).equals(valor);
	}

}