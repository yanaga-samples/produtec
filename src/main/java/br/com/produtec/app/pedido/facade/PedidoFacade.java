package br.com.produtec.app.pedido.facade;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.pedido.integration.PedidoGateway;
import br.com.produtec.app.pedido.repository.PedidoRepository;
import br.com.produtec.app.pedido.sequencial.SequencialPedidoRepository;

@Service
public class PedidoFacade {

	@Autowired
	private SequencialPedidoRepository sequencialPedidoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoGateway pedidoGateway;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Pedido novoPedido() {
		Integer proximoNumeroDoPedido = sequencialPedidoRepository.getSequencialPedido().proximoNumeroDoPedido();
		return Pedido.newPedido(proximoNumeroDoPedido);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer proximoNumeroPedido() {
		return sequencialPedidoRepository.getSequencialPedido().proximoNumeroDoPedido();
	}

	@Transactional
	public Pedido save(Pedido pedido) {
		checkNotNull(pedido);
		Pedido saved = pedidoRepository.save(pedido);
		pedidoGateway.criado(saved);
		return saved;
	}

}