package br.com.produtec.app.percentual;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.common.base.Objects;

public class Percentual implements Serializable {

	private static final long serialVersionUID = 1L;

	final BigDecimal valor;

	private Percentual(BigDecimal valor) {
		this.valor = valor;
	}

	public static Percentual newPercentual(BigDecimal valor) {
		checkNotNull(valor, "Valor do percentual não pode ser nulo.");
		checkArgument(valor.compareTo(BigDecimal.ZERO) >= 0, "Valor do percentual não pode ser negativo.");
		return new Percentual(valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Percentual) {
			Percentual other = (Percentual) obj;
			return Objects.equal(this.valor, other.valor);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.valor);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("valor", valor).toString();
	}

}
