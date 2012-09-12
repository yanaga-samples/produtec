package br.com.produtec.app.transferenciaestoque;

import org.junit.Test;

public class ProcessoIntegracaoTest {

	@Test
	public void buildIntegracaoTerceiro() {
		ProcessoIntegracao processoIntegracao = new ProcessoIntegracao();
		processoIntegracao.setIntegrar(Integrar.NAO);
		processoIntegracao.buildIntegracaoTerceiro().integrar(new TransferenciaEstoque());

		processoIntegracao.setIntegrar(Integrar.SIM);
		processoIntegracao.buildIntegracaoTerceiro().integrar(new TransferenciaEstoque());

		processoIntegracao.setIntegrar(Integrar.SIM);
		processoIntegracao.setEmissaoNota(EmissaoNota.RETORNO);
		processoIntegracao.buildIntegracaoTerceiro().integrar(new TransferenciaEstoque());
	}

}
