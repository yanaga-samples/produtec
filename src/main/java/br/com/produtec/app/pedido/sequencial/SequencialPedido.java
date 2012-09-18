package br.com.produtec.app.pedido.sequencial;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SequencialPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id = 1L;

	private Integer sequencial = 0;

	SequencialPedido() {
	}

	public Integer proximoNumeroDoPedido() {
		sequencial = sequencial + 1;
		return sequencial;
	}

}