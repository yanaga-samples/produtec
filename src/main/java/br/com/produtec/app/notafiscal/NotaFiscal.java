package br.com.produtec.app.notafiscal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.produtec.app.contato.Contato;
import br.com.produtec.app.pedido.Faturamento;
import br.com.produtec.app.pedido.PedidoObserver;
import br.com.produtec.app.service.WebServiceReceita;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

@Document
public class NotaFiscal implements Serializable, PedidoObserver {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@NotNull
	private Integer numero;

	private List<Item> itens = Lists.newLinkedList();

	private Contato contato;

	NotaFiscal() {
	}

	private NotaFiscal(Integer numero) {
		this.numero = numero;
	}

	public static NotaFiscal newNotaFiscal(Integer numero) {
		checkNotNull(numero);
		checkArgument(numero > 0);
		return new NotaFiscal(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NotaFiscal) {
			NotaFiscal other = (NotaFiscal) obj;
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

	public NotaFiscal addItem(Item item) {
		checkNotNull(item, "Item não pode ser nulo.");
		if (!itens.contains(item)) {
			itens.add(item);
		}
		return this;
	}

	public NotaFiscal removeItem(Item item) {
		checkNotNull(item, "Item não pode ser nulo.");
		if (itens.contains(item)) {
			itens.remove(item);
		}
		return this;
	}

	public void enviar(WebServiceReceita webServiceReceita) {
		// codigo encapsulado
		// Tell, don't ask

		// Mande, não pergunte
	}

	@Override
	public void faturado(Faturamento faturamento) {
		System.out.println("Nota Fiscal Faturada");
	}

	public String getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Item> getItens() {
		return ImmutableList.copyOf(itens);
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}