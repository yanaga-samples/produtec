package br.com.produtec.app.notafiscal;

public class MensagemEstadoNotaFiscalVisitor implements EstadoNotaFiscalVisitor<String> {

	@Override
	public String visit(EstadoNotaFiscalFaturada estadoNotaFiscalFaturada) {
		return "Faturada";
	}

	@Override
	public String visit(EstadoNotaFiscalCancelada estadoNotaFiscalCancelada) {
		return "Cancelada";
	}

}