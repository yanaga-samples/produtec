package br.com.produtec.app.transferenciaestoque;

import java.io.Serializable;

public class ProcessoIntegracao implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean integrar;

	private EmissaoNota emissaoNota;

	public Pizza buildPizza() {
		Pizza pizza = EmptyPizza.newEmptyPizza();
		if (integrar) {
			pizza = ConsumirSaldo.newConsumirSaldo(pizza);
			pizza = emissaoNota.buildPizza(pizza);
		}
		return pizza;
	}

	public boolean isIntegrar() {
		return integrar;
	}

	public void setIntegrar(boolean integrar) {
		this.integrar = integrar;
	}

	public EmissaoNota getEmissaoNota() {
		return emissaoNota;
	}

	public void setEmissaoNota(EmissaoNota emissaoNota) {
		this.emissaoNota = emissaoNota;
	}

}