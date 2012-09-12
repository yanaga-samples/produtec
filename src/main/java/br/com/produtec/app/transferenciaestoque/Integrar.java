package br.com.produtec.app.transferenciaestoque;

public enum Integrar {

	SIM {
		@Override
		public IntegracaoTerceiro decorate(IntegracaoTerceiro integracaoTerceiro, ProcessoIntegracao processoIntegracao) {
			ConsumirSaldo consumirSaldo = ConsumirSaldo.newConsumirSaldo(integracaoTerceiro);
			return processoIntegracao.emissaoNota.buildPizza(consumirSaldo);
		}
	}, NAO {
		@Override
		public IntegracaoTerceiro decorate(IntegracaoTerceiro integracaoTerceiro, ProcessoIntegracao processoIntegracao) {
			return EmptyIntegracaoTerceiro.newEmptyIntegracaoTerceiro();
		}
	};

	public abstract IntegracaoTerceiro decorate(IntegracaoTerceiro integracaoTerceiro, ProcessoIntegracao processoIntegracao);

}