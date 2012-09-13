package br.com.produtec.app.estoque;

import static br.com.produtec.app.quantidade.Ops.adicao;
import static br.com.produtec.app.quantidade.Ops.subtracao;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.codec.binary.Hex;

import br.com.produtec.app.Produto;
import br.com.produtec.app.pedido.Faturamento;
import br.com.produtec.app.pedido.PedidoObserver;
import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeFactory;

import com.google.common.base.Objects;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

@Entity
public class ItemEstoque implements Serializable, PedidoObserver {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	@ManyToOne
	@JoinColumn(name = "produto_fk")
	private Produto produto;

	@Column(scale = 2)
	private Quantidade quantidade = QuantidadeFactory.INSTANCE.newQuantidade(BigDecimal.ZERO);

	@Column(length = 32)
	private String md5;

	@Transient
	private boolean alterada;

	ItemEstoque() {
	}

	private ItemEstoque(Produto produto) {
		this.produto = produto;
	}

	public static ItemEstoque newItemEstoque(Produto produto) {
		checkNotNull(produto);
		return new ItemEstoque(produto);
	}

	@PrePersist
	@PreUpdate
	void calcularMd5() {
		this.md5 = md5();
	}

	@PostLoad
	void verificarMd5() {
		this.alterada = !this.md5.equals(md5());
	}

	private String md5() {
		HashCode hashCode = Hashing.md5().newHasher().putString(produto.toString()).putString(quantidade.toString())
				.hash();
		return Hex.encodeHexString(hashCode.asBytes());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ItemEstoque) {
			ItemEstoque other = (ItemEstoque) obj;
			return Objects.equal(this.produto, other.produto) && Objects.equal(this.quantidade, other.quantidade);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.produto, this.quantidade);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("produto", produto).add("quantidade", quantidade).toString();
	}

	public ItemEstoque addQuantidade(Quantidade quantidade) {
		checkNotNull(quantidade);
		this.quantidade = adicao(this.quantidade).somando(quantidade).somar();
		return this;
	}

	public Produto getProduto() {
		return produto;
	}

	public Quantidade getQuantidade() {
		return quantidade;
	}

	@Override
	public void faturado(Faturamento faturamento) {
		Quantidade quantidadeFaturada = faturamento.getQuantidade();
		this.quantidade = subtracao(this.quantidade).subtraendo(quantidadeFaturada).subtrair();
	}

	public boolean isAlterada() {
		return alterada;
	}

}