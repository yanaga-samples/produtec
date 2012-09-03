package br.com.produtec;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dolar extends Dinheiro {

	private static final long serialVersionUID = 1L;

	private static Dolar ZERO_DOLARES = new Dolar(new BigDecimal("0.00"));

	Dolar(BigDecimal valor) {
		super(valor);
	}

	@Override
	public boolean isZero() {
		return this == ZERO_DOLARES;
	}

	static Dolar valueOf(BigDecimal valor) {
		checkNotNull(valor);
		if (valor.setScale(2, RoundingMode.HALF_EVEN).equals(new BigDecimal("0.00"))) {
			return ZERO_DOLARES;
		}
		return new Dolar(valor);
	}

}