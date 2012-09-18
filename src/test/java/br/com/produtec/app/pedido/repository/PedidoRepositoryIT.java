package br.com.produtec.app.pedido.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.pedido.QPedido;
import br.com.produtec.config.ProdutecConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProdutecConfig.class)
@TransactionConfiguration
public class PedidoRepositoryIT {

	@Inject
	private PedidoRepository pedidoRepository;

	@Transactional
	@Test
	public void save() {
		Pedido pedido = Pedido.newPedido(123);
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		assertNotNull(pedidoSalvo.getId());
		assertNotNull(pedidoRepository.findOne(pedidoSalvo.getId()));
		assertEquals(pedidoSalvo, pedidoRepository.findByNumero(123).get(0));
		assertEquals(pedidoSalvo, pedidoRepository.findOne(QPedido.pedido.numero.eq(123)));
	}

}
