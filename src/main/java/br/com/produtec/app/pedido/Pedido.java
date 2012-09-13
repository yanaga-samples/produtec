package br.com.produtec.app.pedido;

import static br.com.produtec.app.quantidade.Ops.adicao;
import static br.com.produtec.app.quantidade.Ops.subtracao;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;

import br.com.produtec.app.Produto;
import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeFactory;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

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

	@Type(type = "estadoPedido")
	EstadoPedido estadoPedido = EstadoPedido.ABERTO;

	DateTime data = new DateTime(DateTimeUtils.currentTimeMillis());

	@ElementCollection
	@MapKeyJoinColumn(name = "produto_fk")
	private Map<Produto, Quantidade> produtos = Maps.newHashMap();

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Faturamento> faturamentos = Lists.newLinkedList();

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Cancelamento> cancelamentos = Lists.newLinkedList();

	@Transient
	private Set<PedidoObserver> observadores = Sets.newHashSet();

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

	public void addObservador(PedidoObserver observer) {
		checkNotNull(observer);
		observadores.add(observer);
	}

	public boolean isCancelado() {
		return EstadoPedido.CANCELADO == estadoPedido;
	}

	public boolean isParcialmenteCancelado() {
		return estadoPedido.isParcialmenteCancelado();
	}

	public Quantidade getQuantidade() {
		return estadoPedido.calcularQuantidade(this);
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

	public Pedido addFaturamento(Faturamento faturamento) {
		checkNotNull(faturamento, "Faturamento não pode ser nulo.");
		if (!faturamentos.contains(faturamento)) {
			faturamentos.add(faturamento);
			fireFaturamento(faturamento);
		}
		return this;
	}

	private void fireFaturamento(Faturamento faturamento) {
		for (PedidoObserver observador : observadores) {
			observador.faturado(faturamento);
		}
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
		return new QuantidadeZeroParaNuloMap(ImmutableMap.copyOf(copiaProdutos));
	}

	public Long getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public Map<Produto, Quantidade> getProdutos() {
		return new QuantidadeZeroParaNuloMap(ImmutableMap.copyOf(produtos));
	}

	public List<Cancelamento> getCancelamentos() {
		return ImmutableList.copyOf(cancelamentos);
	}

	public DateTime getData() {
		return data;
	}

	public static class QuantidadeZeroParaNuloMap implements Map<Produto, Quantidade> {

		private Map<Produto, Quantidade> decorado;

		private QuantidadeZeroParaNuloMap(Map<Produto, Quantidade> decorado) {
			this.decorado = decorado;
		}

		public int size() {
			return decorado.size();
		}

		public boolean isEmpty() {
			return decorado.isEmpty();
		}

		public boolean containsKey(Object key) {
			return decorado.containsKey(key);
		}

		public boolean containsValue(Object value) {
			return decorado.containsValue(value);
		}

		public Quantidade get(Object key) {
			Quantidade quantidade = decorado.get(key);
			if (quantidade == null) {
				return QuantidadeFactory.INSTANCE.newQuantidade(BigDecimal.ZERO);
			}
			return quantidade;
		}

		public Quantidade put(Produto key, Quantidade value) {
			return decorado.put(key, value);
		}

		public Quantidade remove(Object key) {
			return decorado.remove(key);
		}

		public void putAll(Map<? extends Produto, ? extends Quantidade> m) {
			decorado.putAll(m);
		}

		public void clear() {
			decorado.clear();
		}

		public Set<Produto> keySet() {
			return decorado.keySet();
		}

		public Collection<Quantidade> values() {
			return decorado.values();
		}

		public Set<java.util.Map.Entry<Produto, Quantidade>> entrySet() {
			return decorado.entrySet();
		}

	}

}