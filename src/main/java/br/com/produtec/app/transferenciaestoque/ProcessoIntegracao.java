package br.com.produtec.app.transferenciaestoque;

import java.io.Serializable;

public class ProcessoIntegracao implements Serializable {

	private static final long serialVersionUID = 1L;

	Integrar integrar = Integrar.NAO;

	EmissaoNota emissaoNota = EmissaoNota.REMESSA;

	public IntegracaoTerceiro buildIntegracaoTerceiro() {
		return integrar.decorate(EmptyIntegracaoTerceiro.newEmptyIntegracaoTerceiro(), this);
	}

	public Integrar getIntegrar() {
		return integrar;
	}

	public void setIntegrar(Integrar integrar) {
		this.integrar = integrar;
	}

	public EmissaoNota getEmissaoNota() {
		return emissaoNota;
	}

	public void setEmissaoNota(EmissaoNota emissaoNota) {
		this.emissaoNota = emissaoNota;
	}

}