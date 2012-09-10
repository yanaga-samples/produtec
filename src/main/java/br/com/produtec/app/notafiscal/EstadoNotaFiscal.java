package br.com.produtec.app.notafiscal;

import java.io.Serializable;

interface EstadoNotaFiscal extends Serializable {

	public static final EstadoNotaFiscal FATURADA = EstadoNotaFiscalFaturada.INSTANCE;

	public static final EstadoNotaFiscal CANCELADA = EstadoNotaFiscalCancelada.INSTANCE;

	public <T> T accept(EstadoNotaFiscalVisitor<T> visitor);

}