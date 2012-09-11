package br.com.produtec.app.transferenciaestoque;


public class EmitirNotaRemessa extends EmitirNota {

	EmitirNotaRemessa(Pizza pizza) {
		super(pizza);
	}

	@Override
	protected void obterCelula() {
		System.out.println("obtendo celular de remessa");
	}

	@Override
	protected void obterProduto() {
		System.out.println("obtendo produto de remessa");
	}

}