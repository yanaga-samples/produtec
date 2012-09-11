package br.com.produtec.app.transferenciaestoque;

public enum EmissaoNota {

	REMESSA {
		@Override
		public Pizza buildPizza(Pizza pizza) {
			return EmitirNota.newEmitirNotaRemessa(pizza);
		}
	}, RETORNO {
		@Override
		public Pizza buildPizza(Pizza pizza) {
			return EmitirNota.newEmitirNotaRetorno(pizza);
		}
	};

	public abstract Pizza buildPizza(Pizza pizza);

}