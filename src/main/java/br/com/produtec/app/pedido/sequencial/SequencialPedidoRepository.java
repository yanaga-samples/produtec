package br.com.produtec.app.pedido.sequencial;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class SequencialPedidoRepository implements ApplicationListener<ContextRefreshedEvent> {

	@PersistenceContext
	private EntityManager entityManager;

	public SequencialPedido getSequencialPedido() {
		return entityManager.find(SequencialPedido.class, 1L, LockModeType.PESSIMISTIC_WRITE);
	}

	@Transactional
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		SequencialPedido sequencialPedido = getSequencialPedido();
		if (sequencialPedido == null) {
			entityManager.persist(new SequencialPedido());
		}
	}

}