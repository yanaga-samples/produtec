package br.com.produtec.app.transferenciaestoque;

public class EmptyPizza implements Pizza {

	private EmptyPizza() {
	}

	public static EmptyPizza newEmptyPizza() {
		return new EmptyPizza();
	}

	@Override
	public void comer(TransferenciaEstoque transferenciaEstoque) {
	}

}