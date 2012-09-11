package br.com.produtec.app.service;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.produtec.app.notafiscal.NotaFiscal;

@Service
public class NotaFiscalService {

	@Inject
	WebServiceReceita webServiceReceita;

	@Transactional
	public void enviarParaReceita(NotaFiscal notaFiscal) {
		checkNotNull(notaFiscal);
		notaFiscal.enviar(webServiceReceita);
	}

}