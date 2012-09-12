package br.com.produtec.app.transferenciaestoque;


public class EmitirNotaRemessa extends EmitirNota {

	EmitirNotaRemessa(IntegracaoTerceiro integracaoTerceiro) {
		super(integracaoTerceiro);
	}

	@Override
	protected void obterCelula() {
		System.out.println("obtendo celula de remessa");
	}

	@Override
	protected void obterProduto() {
		System.out.println("obtendo produto de remessa");
	}

}