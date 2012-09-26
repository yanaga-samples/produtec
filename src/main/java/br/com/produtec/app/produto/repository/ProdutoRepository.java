package br.com.produtec.app.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtec.app.produto.Produto;
import br.com.produtec.app.repository.ListQueryDslPredicateExecutor;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ListQueryDslPredicateExecutor<Produto> {

}
