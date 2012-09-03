package br.com.produtec;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	@Column(length = 60)
	private String nome;

	Produto() {
	}

	private Produto(String nome) {
		this.nome = nome;
	}

	public static Produto newProduto() {
		return new Produto();
	}

	public static Produto newProduto(String nome) {
		checkArgument(!Strings.isNullOrEmpty(nome));
		return new Produto(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Produto) {
			Produto other = (Produto) obj;
			return Objects.equal(this.nome, other.nome);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.nome);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("nome", nome).toString();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}