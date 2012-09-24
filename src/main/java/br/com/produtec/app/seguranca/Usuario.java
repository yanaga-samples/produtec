package br.com.produtec.app.seguranca;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;

@Entity
public class Usuario implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	@NotEmpty
	@Column(length = 30)
	private String login;

	@NotEmpty
	@Column(length = 64)
	private String senha;

	@ManyToMany
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_fk"), inverseJoinColumns = @JoinColumn(name = "perfil_fk"))
	private List<PerfilUsuario> perfis = Lists.newLinkedList();

	Usuario() {
	}

	private Usuario(String login) {
		this.login = login;
	}

	public static Usuario newUsuario() {
		return new Usuario();
	}

	public static Usuario newUsuario(String login) {
		checkArgument(!Strings.isNullOrEmpty(login));
		return new Usuario(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario other = (Usuario) obj;
			return Objects.equal(this.login, other.login);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.login);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("login", login).toString();
	}

	public Usuario addPerfil(PerfilUsuario perfil) {
		checkNotNull(perfil);
		this.perfis.add(perfil);
		return this;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Builder<Permissao> builder = ImmutableSet.builder();
		for (PerfilUsuario perfil : perfis) {
			builder.addAll(perfil.getPermissoes());
		}
		return builder.build();
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}