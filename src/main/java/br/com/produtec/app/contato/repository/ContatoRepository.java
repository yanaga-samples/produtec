package br.com.produtec.app.contato.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.produtec.app.contato.Contato;
import br.com.produtec.app.repository.ListQueryDslPredicateExecutor;

public interface ContatoRepository extends MongoRepository<Contato, String>, ListQueryDslPredicateExecutor<Contato> {

}
