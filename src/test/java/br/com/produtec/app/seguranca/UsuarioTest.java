package br.com.produtec.app.seguranca;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;

public class UsuarioTest {

	@Test
	public void authorities() {
		Usuario usuario = Usuario.newUsuario("Fulano");
		PerfilUsuario perfilA = PerfilUsuario.newPerfilUsuario("a");
		perfilA.addPermissao(Permissao.ROLE_USER);
		PerfilUsuario perfilB = PerfilUsuario.newPerfilUsuario("b");
		perfilB.addPermissao(Permissao.ROLE_USER);
		perfilB.addPermissao(Permissao.ROLE_EDITAR_PEDIDO);
		usuario.addPerfil(perfilA);
		usuario.addPerfil(perfilB);
		Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();
		assertTrue(authorities.contains(Permissao.ROLE_USER));
		assertTrue(authorities.contains(Permissao.ROLE_EDITAR_PEDIDO));
	}

}