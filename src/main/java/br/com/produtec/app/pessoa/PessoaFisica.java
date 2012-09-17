package br.com.produtec.app.pessoa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.google.common.base.Objects;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(name = "nomeRazaoSocial", length = 60)
	private String nome;

	PessoaFisica() {
	}

	PessoaFisica(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PessoaFisica) {
			PessoaFisica other = (PessoaFisica) obj;
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

	@Override
	public String getNomeRazaoSocial() {
		return this.nome;
	}

	@Override
	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nome = nomeRazaoSocial;
	}
}