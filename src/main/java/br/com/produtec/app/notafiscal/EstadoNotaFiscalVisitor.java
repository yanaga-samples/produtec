package br.com.produtec.app.notafiscal;

interface EstadoNotaFiscalVisitor<T> {

	public T visit(EstadoNotaFiscalFaturada estadoNotaFiscalFaturada);

	public T visit(EstadoNotaFiscalCancelada estadoNotaFiscalCancelada);

}