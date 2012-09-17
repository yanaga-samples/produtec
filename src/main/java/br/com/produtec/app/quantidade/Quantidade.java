package br.com.produtec.app.quantidade;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.google.common.base.Objects;

public class Quantidade implements Serializable {

	private static final long serialVersionUID = 1L;

	static final RoundingMode ARREDONDAMENTO_PADRAO = RoundingMode.HALF_EVEN;

	final BigDecimal valor;

	Quantidade(BigDecimal valor) {
		checkNotNull(valor, "Valor da quantidade não pode ser nulo.");
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Quantidade) {
			Quantidade other = (Quantidade) obj;
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

	public boolean isZero() {
		return BigDecimal.ZERO.setScale(valor.scale(), ARREDONDAMENTO_PADRAO).equals(valor);
	}

	public boolean isNegativa() {
		return this.valor.compareTo(BigDecimal.ZERO) < 0;
	}

	public Quantidade percentual(Percentual percentual) {
		BigDecimal resultado = valor.multiply(percentual.valor)
				.divide(new BigDecimal("100"), ARREDONDAMENTO_PADRAO);
		return QuantidadeFactory.INSTANCE.newQuantidade(resultado);
	}

}