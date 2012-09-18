package br.com.produtec.app.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.repository.JpaQueryDslPredicateExecutor;

public interface PedidoRepository extends JpaRepository<Pedido, Long>, JpaQueryDslPredicateExecutor<Pedido> {

	public List<Pedido> findByNumero(Integer numero);

}