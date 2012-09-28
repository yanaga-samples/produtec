package br.com.produtec.app.contato;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Strings;

@Document
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String nome;

	private Contato() {
	}

	@PersistenceConstructor
	private Contato(String nome) {
		this.nome = nome;
	}

	public static Contato newContato() {
		return new Contato();
	}

	public static Contato newContato(String nome) {
		checkArgument(!Strings.isNullOrEmpty(nome));
		return new Contato(nome);
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}