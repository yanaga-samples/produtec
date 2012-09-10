package br.com.produtec.app.notafiscal;

import static org.junit.Assert.*;

import org.junit.Test;

public class NotaFiscalTest {

	@Test
	public void mensagem() {
		NotaFiscal notaFiscal = NotaFiscal.newNotaFiscal(123);
		notaFiscal.estado = EstadoNotaFiscal.FATURADA;
		assertEquals("Faturada", notaFiscal.getMensagem());
		notaFiscal.estado = EstadoNotaFiscal.CANCELADA;
		assertEquals("Cancelada", notaFiscal.getMensagem());
	}

}