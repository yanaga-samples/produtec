package br.com.produtec.app.notafiscal.service;

import static br.com.produtec.app.IntegrationChannels.INPUT_PEDIDO_CHANNEL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import br.com.produtec.app.notafiscal.NotaFiscal;
import br.com.produtec.app.notafiscal.repository.NotaFiscalRepository;
import br.com.produtec.app.pedido.Pedido;

@Service
public class NotaFiscalFacade {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	@ServiceActivator(inputChannel = INPUT_PEDIDO_CHANNEL)
	public void pedidoCriado(Pedido pedido) {
		NotaFiscal notaFiscal = NotaFiscal.newNotaFiscal(pedido);
		notaFiscalRepository.save(notaFiscal);
	}

}