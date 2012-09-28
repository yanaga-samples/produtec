package br.com.produtec.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.produtec.app.contato.Contato;
import br.com.produtec.app.contato.repository.ContatoRepository;

@Controller
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;

	public Contato novo() {
		return Contato.newContato();
	}

	public List<Contato> filtrar() {
		return contatoRepository.findAll();
	}

}