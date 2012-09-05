package br.com.produtec.app;

import static br.com.produtec.app.quantidade.Ops.adicao;
import static br.com.produtec.app.quantidade.Ops.subtracao;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import br.com.produtec.app.quantidade.Quantidade;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
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

	@ElementCollection
	@MapKeyJoinColumn(name = "produto_fk")
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

	public Pedido addProduto(Produto produto, Quantidade quantidade) {
		checkNotNull(produto);
		checkNotNull(quantidade);
		checkArgument(!quantidade.isNegativa());
		if (!produtos.containsKey(produto)) {
			produtos.put(produto, quantidade);
		}
		else {
			Quantidade quantidadeAtual = produtos.get(produto);
			produtos.put(produto, adicao(quantidadeAtual).somando(quantidade).somar());
		}
		return this;
	}

	public Pedido addCancelamento(Cancelamento cancelamento) {
		checkNotNull(cancelamento, "Cancelamento não pode ser nulo.");
		if (!cancelamentos.contains(cancelamento)) {
			cancelamentos.add(cancelamento);
		}
		return this;
	}

	public Map<Produto, Quantidade> getProdutosNaoCancelados() {
		Map<Produto, Quantidade> copiaProdutos = Maps.newHashMap(produtos);
		for (Cancelamento cancelamento : cancelamentos) {
			Quantidade quantidade = copiaProdutos.get(cancelamento.getProduto());
			quantidade = subtracao(quantidade).subtraendo(cancelamento.getQuantidade()).subtrair();
			copiaProdutos.put(cancelamento.getProduto(), quantidade);
		}
		return ImmutableMap.copyOf(copiaProdutos);
	}

	public Long getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public Map<Produto, Quantidade> getProdutos() {
		return ImmutableMap.copyOf(produtos);
	}

	public List<Cancelamento> getCancelamentos() {
		return ImmutableList.copyOf(cancelamentos);
	}

}