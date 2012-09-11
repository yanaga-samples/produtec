package br.com.produtec.app.transferenciaestoque;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class EmitirNota implements Pizza {

	private Pizza pizza;

	EmitirNota(Pizza pizza) {
		checkNotNull(pizza);
		this.pizza = pizza;
	}

	public static EmitirNotaRetorno newEmitirNotaRetorno(Pizza pizza) {
		return new EmitirNotaRetorno(pizza);
	}

	public static EmitirNotaRemessa newEmitirNotaRemessa(Pizza pizza) {
		return new EmitirNotaRemessa(pizza);
	}

	@Override
	public void comer(TransferenciaEstoque transferenciaEstoque) {
		pizza.comer(transferenciaEstoque);
		obterCelula();
		obterProduto();
		preencherIntegracao();
	}

	protected abstract void obterCelula();

	protected abstract void obterProduto();

	private void preencherIntegracao() {
		System.out.println("preechendo integracao");
	}

}