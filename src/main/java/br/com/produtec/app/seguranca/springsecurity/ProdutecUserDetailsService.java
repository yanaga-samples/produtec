package br.com.produtec.app.seguranca.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.produtec.app.seguranca.QUsuario;
import br.com.produtec.app.seguranca.Usuario;
import br.com.produtec.app.seguranca.repository.UsuarioRepository;

@Service
public class ProdutecUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findOne(QUsuario.usuario.login.eq(username));
		if (usuario != null) {
			usuario.getAuthorities();
		}
		return usuario;
	}

}