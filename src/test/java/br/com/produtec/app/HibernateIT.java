package br.com.produtec.app;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.produtec.config.ProdutecConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProdutecConfig.class)
@TransactionConfiguration
public class HibernateIT {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void save() {
		Pedido pedido = Pedido.newPedido(123);
		entityManager.persist(pedido);
	}

}