package br.com.produtec.app.transferenciaestoque;


public class EmitirNotaRetorno extends EmitirNota {

	EmitirNotaRetorno(IntegracaoTerceiro integracaoTerceiro) {
		super(integracaoTerceiro);
	}

	@Override
	protected void obterCelula() {
		System.out.println("obtendo celula de retorno");
	}

	@Override
	protected void obterProduto() {
		System.out.println("obtendo produto de retorno");
	}

}