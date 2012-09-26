package br.com.produtec.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.produtec.app.notafiscal.Item;
import br.com.produtec.app.notafiscal.NotaFiscal;
import br.com.produtec.app.notafiscal.repository.NotaFiscalRepository;

@Controller
public class NotaFiscalController {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	public NotaFiscal novo() {
		return NotaFiscal.newNotaFiscal(123);
	}

	public Item novoItem() {
		return Item.newItem();
	}

	public FiltroNotaFiscal getFiltro() {
		return new FiltroNotaFiscal();
	}

	public List<NotaFiscal> filtrar(FiltroNotaFiscal filtro) {
		return notaFiscalRepository.findAll();
	}

}