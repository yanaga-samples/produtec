package br.com.produtec.app.transferenciaestoque;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.google.common.collect.Lists;

public class TransferenciaEstoque {

	private List<String> valores = Lists.newLinkedList();

	public void addValor(String valor) {
		checkNotNull(valor);
		valores.add(valor);
	}

}