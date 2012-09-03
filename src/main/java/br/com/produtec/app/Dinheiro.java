package br.com.produtec.app;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Dinheiro implements Serializable {

	private static final long serialVersionUID = 1L;

	private final BigDecimal valor;

	Dinheiro(BigDecimal valor) {
		this.valor = valor;
	}

	public abstract boolean isZero();

	public static Real newReal(BigDecimal valor) {
		checkNotNull(valor);
		return Real.valueOf(valor);
	}

	public static Dolar newDolar(BigDecimal valor) {
		checkNotNull(valor);
		return Dolar.valueOf(valor);
	}

}