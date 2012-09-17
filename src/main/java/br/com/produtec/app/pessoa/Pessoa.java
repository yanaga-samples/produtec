package br.com.produtec.app.pessoa;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 1, name = "tipo")
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	Pessoa() {
	}

	public static PessoaFisica newPessoaFisica(String nome) {
		return new PessoaFisica(nome);
	}

	public static PessoaJuridica newPessoaJuridica(String razaoSocial) {
		return new PessoaJuridica(razaoSocial);
	}

	public Long getId() {
		return id;
	}

	public abstract String getNomeRazaoSocial();

	public abstract void setNomeRazaoSocial(String nomeRazaoSocial);

}