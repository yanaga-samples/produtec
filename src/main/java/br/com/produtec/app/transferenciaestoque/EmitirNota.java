package br.com.produtec.app.transferenciaestoque;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class EmitirNota implements IntegracaoTerceiro {

	private IntegracaoTerceiro integracaoTerceiro;

	EmitirNota(IntegracaoTerceiro integracaoTerceiro) {
		checkNotNull(integracaoTerceiro);
		this.integracaoTerceiro = integracaoTerceiro;
	}

	public static EmitirNotaRetorno newEmitirNotaRetorno(IntegracaoTerceiro integracaoTerceiro) {
		return new EmitirNotaRetorno(integracaoTerceiro);
	}

	public static EmitirNotaRemessa newEmitirNotaRemessa(IntegracaoTerceiro integracaoTerceiro) {
		return new EmitirNotaRemessa(integracaoTerceiro);
	}

	@Override
	public void integrar(TransferenciaEstoque transferenciaEstoque) {
		integracaoTerceiro.integrar(transferenciaEstoque);
		obterCelula();
		obterProduto();
		preencherIntegracao();
	}

	protected abstract void obterCelula();

	protected abstract void obterProduto();

	private void preencherIntegracao() {
		System.out.println("preechendo integracao");
	}

}