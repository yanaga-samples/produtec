package br.com.produtec.app;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.DateTime;

public class Picanha implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal peso;

	private String nomeDoBoi;

	private DateTime validade;

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getNomeDoBoi() {
		return nomeDoBoi;
	}

	public void setNomeDoBoi(String nomeDoBoi) {
		this.nomeDoBoi = nomeDoBoi;
	}

	public DateTime getValidade() {
		return validade;
	}

	public void setValidade(DateTime validade) {
		this.validade = validade;
	}

}