package br.com.produtec.app.transferenciaestoque;

import static com.google.common.base.Preconditions.checkNotNull;

public class ConsumirSaldo implements Pizza {

	private final Pizza pizza;

	ConsumirSaldo(Pizza pizza) {
		checkNotNull(pizza);
		this.pizza = pizza;
	}

	public static ConsumirSaldo newConsumirSaldo(Pizza pizza) {
		return new ConsumirSaldo(pizza);
	}

	@Override
	public void comer(TransferenciaEstoque transferenciaEstoque) {
		pizza.comer(transferenciaEstoque);
		consumir();
	}

	private void consumir() {
		System.out.println("consumindo saldo");
	}

}