package br.com.produtec.app;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.produtec.app.Produto;

public class ProdutoTest {

	@Test
	public void equals() {
		Produto produto1 = Produto.newProduto("Camisa");
		Produto produto2 = Produto.newProduto("Camisa");
		assertEquals(produto1, produto2);
		assertFalse(produto1.equals(123));
	}

}