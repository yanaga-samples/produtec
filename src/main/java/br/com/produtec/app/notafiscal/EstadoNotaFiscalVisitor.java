package br.com.produtec.app.notafiscal;

public interface EstadoNotaFiscalVisitor<T> {

	public T visit(EstadoNotaFiscalFaturada estadoNotaFiscalFaturada);

	public T visit(EstadoNotaFiscalCancelada estadoNotaFiscalCancelada);

}