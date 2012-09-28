package br.com.produtec.config.root;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.produtec.app.contato.Contato;
import br.com.produtec.app.notafiscal.NotaFiscal;
import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.produto.Produto;
import br.com.produtec.app.seguranca.Usuario;

@EnableJpaRepositories(basePackageClasses = {Usuario.class, Produto.class, Pedido.class})
@EnableMongoRepositories(basePackageClasses = {NotaFiscal.class, Contato.class})
@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
@ImportResource("classpath*:META-INF/spring/applicationContext-data.xml")
public class RepositoryConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory);
	}

}