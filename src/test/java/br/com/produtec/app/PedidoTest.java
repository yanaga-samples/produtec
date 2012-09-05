package br.com.produtec.app;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import br.com.produtec.app.Cancelamento;
import br.com.produtec.app.Pedido;
import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeFactory;

public class PedidoTest {

	@Test
	public void equals() {
		Pedido pedido1 = Pedido.newPedido(123);
		Pedido pedido2 = Pedido.newPedido(123);
		Pedido pedido3 = Pedido.newPedido(321);
		assertEquals(pedido1, pedido2);
		assertFalse(pedido1.equals(pedido3));
		assertFalse(pedido2.equals(321));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void cancelamentosImutavel() {
		Pedido pedido = Pedido.newPedido(123);
		List<Cancelamento> cancelamentos = pedido.getCancelamentos();
		cancelamentos.add(Cancelamento.newCancelamento(pedido));
	}

	@Test
	public void addProduto() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		Produto calca = Produto.newProduto("Calça");
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.201")));
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.403")));
		pedido.addProduto(calca, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.157")));
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("3.333")));
		Quantidade quantidadeCamisas = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("3.937"));
		Quantidade quantidadeCalcas = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.157"));
		assertEquals(quantidadeCamisas, pedido.getProdutos().get(camisa));
		assertEquals(quantidadeCalcas, pedido.getProdutos().get(calca));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void produtosImutavel() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		Quantidade quantidadeCamisas = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.157"));
		pedido.getProdutos().put(camisa, quantidadeCamisas);
	}

}