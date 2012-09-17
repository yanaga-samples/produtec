package br.com.produtec.app.pessoa;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import br.com.produtec.app.percentual.Percentual;

@Entity
public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Version
	Integer version;

	@OneToOne
	@MapsId
	private PessoaFisica pessoaFisica;

	private Percentual comissao = Percentual.newPercentual(BigDecimal.ZERO);

	Vendedor() {
	}

	private Vendedor(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public static Vendedor newVendedor(PessoaFisica pessoaFisica) {
		checkNotNull(pessoaFisica);
		return new Vendedor(pessoaFisica);
	}

	public Long getId() {
		return id;
	}

	public Percentual getComissao() {
		return comissao;
	}

	public void setComissao(Percentual comissao) {
		this.comissao = comissao;
	}

}