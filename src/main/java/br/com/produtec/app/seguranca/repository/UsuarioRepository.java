package br.com.produtec.app.seguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtec.app.repository.ListQueryDslPredicateExecutor;
import br.com.produtec.app.seguranca.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, ListQueryDslPredicateExecutor<Usuario> {

}