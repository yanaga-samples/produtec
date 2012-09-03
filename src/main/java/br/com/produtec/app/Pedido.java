package br.com.produtec.app;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import br.com.produtec.app.quantidade.Quantidade;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	@NotNull
	private Integer numero;

	@ManyToMany
	private Map<Produto, Quantidade> produtos = Maps.newHashMap();

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Cancelamento> cancelamentos = Lists.newLinkedList();

	Pedido() {
	}

	private Pedido(Integer numero) {
		this.numero = numero;
	}

	public static Pedido newPedido(Integer numero) {
		checkNotNull(numero, "Número do pedido não pode ser nulo");
		checkArgument(numero > 0, "Número do pedido deve ser maior que zero.");
		return new Pedido(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pedido) {
			Pedido other = (Pedido) obj;
			return Objects.equal(this.numero, other.numero);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.numero);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("numero", numero).toString();
	}

	public Pedido addCancelamento(Cancelamento cancelamento) {
		checkNotNull(cancelamento, "Cancelamento não pode ser nulo.");
		if (!cancelamentos.contains(cancelamento)) {
			cancelamentos.add(cancelamento);
		}
		return this;
	}

	public Long getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public List<Cancelamento> getCancelamentos() {
		return ImmutableList.copyOf(cancelamentos);
	}

}