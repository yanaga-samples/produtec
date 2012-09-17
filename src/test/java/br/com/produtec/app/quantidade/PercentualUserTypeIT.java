package br.com.produtec.app.quantidade;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.produtec.app.pessoa.Pessoa;
import br.com.produtec.app.pessoa.PessoaFisica;
import br.com.produtec.app.pessoa.Vendedor;
import br.com.produtec.config.ProdutecConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProdutecConfig.class)
@TransactionConfiguration
public class PercentualUserTypeIT {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void save() {
		PessoaFisica pessoaFisica = Pessoa.newPessoaFisica("Fulano");
		Vendedor vendedor = Vendedor.newVendedor(pessoaFisica);
		entityManager.persist(pessoaFisica);
		entityManager.persist(vendedor);
		assertEquals(pessoaFisica.getId(), vendedor.getId());
	}

}
