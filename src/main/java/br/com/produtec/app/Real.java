package br.com.produtec.app;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Real extends Dinheiro {

	private static final long serialVersionUID = 1L;

	private static Real ZERO_REAIS = new Real(new BigDecimal("0.00"));

	Real(BigDecimal valor) {
		super(valor);
	}

	@Override
	public boolean isZero() {
		return this == ZERO_REAIS;
	}

	static Real valueOf(BigDecimal valor) {
		checkNotNull(valor);
		if (valor.setScale(2, RoundingMode.HALF_EVEN).equals(new BigDecimal("0.00"))) {
			return ZERO_REAIS;
		}
		return new Real(valor);
	}

}
