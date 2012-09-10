package br.com.produtec.app.notafiscal;

public enum EstadoNotaFiscalFaturada implements EstadoNotaFiscal {

	INSTANCE;

	@Override
	public <T> T accept(EstadoNotaFiscalVisitor<T> visitor) {
		return visitor.visit(this);
	}

}