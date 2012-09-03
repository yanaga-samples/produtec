package br.com.produtec;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class Telefone implements Serializable, Formattable {

	private static final long serialVersionUID = 1L;

	private final Integer ddi;

	private final Integer ddd;

	private final String numero;

	private Telefone(Builder builder) {
		this.ddi = builder.ddi;
		this.ddd = builder.ddd;
		this.numero = builder.numero;
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Telefone) {
			Telefone other = (Telefone) obj;
			return Objects.equal(this.ddi, other.ddi) && Objects.equal(this.ddd, other.ddd)
					&& Objects.equal(this.numero, other.numero);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.ddi, this.ddd, this.numero);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("ddi", ddi).add("ddd", ddd).add("numero", numero).omitNullValues()
				.toString();
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		List<String> values = Lists.newLinkedList();
		if (ddi != 0) {
			values.add(String.format("+%d", ddi));
		}
		if (ddd != 0) {
			values.add(String.format("(%d)", ddd));
		}
		values.add(numero);
		formatter.format(Joiner.on(" ").join(values));
	}

	public static class Builder {

		private int ddi = 0;

		private int ddd = 0;

		private String numero;

		private Builder() {
		}

		public Builder withNumero(String numero) {
			checkNotNull(numero, "Número não pode ser nulo.");
			checkArgument(numero.matches("\\d{8}\\d*"), "Número deve conter somente dígitos.");
			this.numero = numero;
			return this;
		}

		public Builder withDdi(int ddi) {
			checkArgument(ddi > 0, "DDI deve ser maior que zero.");
			this.ddi = ddi;
			return this;
		}

		public Builder withDdd(int ddd) {
			checkArgument(ddd > 0, "DDD deve ser maior que zero.");
			this.ddd = ddd;
			return this;
		}

		public Telefone build() {
			checkState(numero != null);
			return new Telefone(this);
		}

	}

}