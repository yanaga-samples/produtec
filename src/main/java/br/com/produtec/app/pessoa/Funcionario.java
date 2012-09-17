package br.com.produtec.app.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.google.common.base.Objects;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@OneToOne
	@MapsId
	private PessoaFisica pessoaFisica;

	Funcionario() {
	}

	private Funcionario(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public static Funcionario newFuncionario(PessoaFisica pessoaFisica) {
		return new Funcionario(pessoaFisica);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Funcionario) {
			Funcionario other = (Funcionario) obj;
			return Objects.equal(this.pessoaFisica, other.pessoaFisica);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(pessoaFisica);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("pessoaFisica", pessoaFisica).toString();
	}

	public Long getId() {
		return id;
	}

}