package br.com.produtec.app.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.repository.ListQueryDslPredicateExecutor;

public interface PedidoRepository extends JpaRepository<Pedido, Long>, ListQueryDslPredicateExecutor<Pedido> {

	public List<Pedido> findByNumero(Integer numero);

}