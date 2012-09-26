package br.com.produtec.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import br.com.produtec.app.QProduto;
import br.com.produtec.app.produto.Produto;
import br.com.produtec.app.produto.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository; 

	public List<Produto> autocomplete(String query) {
		return produtoRepository.findAll(QProduto.produto.nome.containsIgnoreCase(query), new PageRequest(0, 5))
				.getContent();
	}

}
