package br.com.produtec.app.pedido.integration;

import static br.com.produtec.app.IntegrationChannels.OUTPUT_PEDIDO_CHANNEL;

import org.springframework.integration.annotation.Gateway;

import br.com.produtec.app.pedido.Pedido;

public interface PedidoGateway {

	@Gateway(requestChannel = OUTPUT_PEDIDO_CHANNEL)
	public void criado(Pedido pedido);

}