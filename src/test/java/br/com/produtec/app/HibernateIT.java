package br.com.produtec.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.pedido.QPedido;
import br.com.produtec.app.pessoa.Funcionario;
import br.com.produtec.app.pessoa.Pessoa;
import br.com.produtec.app.pessoa.PessoaFisica;
import br.com.produtec.config.root.ProdutecConfig;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProdutecConfig.class)
@TransactionConfiguration
public class HibernateIT {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Test
	public void pedido() {
		Pedido pedido = Pedido.newPedido(123);
		entityManager.persist(pedido);
		entityManager.flush();

		JPQLQuery query = new JPAQuery(entityManager);
		QPedido qPedido = QPedido.pedido;
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qPedido.numero.eq(123));
		Pedido resultado = query.from(qPedido).uniqueResult(qPedido);
		assertNotNull(resultado);
	}

	@Test
	public void funcionario() {
		PessoaFisica fulano = Pessoa.newPessoaFisica("Fulano");
		Funcionario funcionario = Funcionario.newFuncionario(fulano);
		entityManager.persist(fulano);
		entityManager.persist(funcionario);
		assertNotNull(fulano.getId());
		assertNotNull(funcionario.getId());
		assertEquals(fulano.getId(), funcionario.getId());
	}

}