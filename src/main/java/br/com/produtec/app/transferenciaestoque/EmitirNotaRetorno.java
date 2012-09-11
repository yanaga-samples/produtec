package br.com.produtec.app.transferenciaestoque;


public class EmitirNotaRetorno extends EmitirNota {

	EmitirNotaRetorno(Pizza pizza) {
		super(pizza);
	}

	@Override
	protected void obterCelula() {
		System.out.println("obtendo celular de retorno");
	}

	@Override
	protected void obterProduto() {
		System.out.println("obtendo produto de retorno");
	}

}