package br.com.produtec.app.transferenciaestoque;

public enum EmissaoNota {

	REMESSA {
		@Override
		public IntegracaoTerceiro buildPizza(IntegracaoTerceiro integracaoTerceiro) {
			return EmitirNota.newEmitirNotaRemessa(integracaoTerceiro);
		}
	}, RETORNO {
		@Override
		public IntegracaoTerceiro buildPizza(IntegracaoTerceiro integracaoTerceiro) {
			return EmitirNota.newEmitirNotaRetorno(integracaoTerceiro);
		}
	};

	public abstract IntegracaoTerceiro buildPizza(IntegracaoTerceiro integracaoTerceiro);

}