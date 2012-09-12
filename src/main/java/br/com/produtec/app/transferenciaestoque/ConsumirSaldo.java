package br.com.produtec.app.transferenciaestoque;

import static com.google.common.base.Preconditions.checkNotNull;

public class ConsumirSaldo implements IntegracaoTerceiro {

	private final IntegracaoTerceiro integracaoTerceiro;

	ConsumirSaldo(IntegracaoTerceiro integracaoTerceiro) {
		checkNotNull(integracaoTerceiro);
		this.integracaoTerceiro = integracaoTerceiro;
	}

	public static ConsumirSaldo newConsumirSaldo(IntegracaoTerceiro integracaoTerceiro) {
		return new ConsumirSaldo(integracaoTerceiro);
	}

	@Override
	public void integrar(TransferenciaEstoque transferenciaEstoque) {
		integracaoTerceiro.integrar(transferenciaEstoque);
		consumir();
	}

	private void consumir() {
		System.out.println("consumindo saldo");
	}

}