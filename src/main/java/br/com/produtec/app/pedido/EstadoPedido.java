package br.com.produtec.app.pedido;

import static br.com.produtec.app.quantidade.Ops.adicao;
import static br.com.produtec.app.quantidade.Ops.multiplicacao;

import java.math.BigDecimal;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Days;

import br.com.produtec.app.produto.Produto;
import br.com.produtec.app.quantidade.Adicao;
import br.com.produtec.app.quantidade.Quantidade;
import br.com.produtec.app.quantidade.QuantidadeFactory;

public enum EstadoPedido {

	ABERTO {
		@Override
		public Quantidade calcularQuantidade(Pedido pedido) {
			Quantidade quantidadeNormal = super.calcularQuantidade(pedido);
			DateTime hoje = new DateTime(DateTimeUtils.currentTimeMillis());
			if (Days.daysBetween(pedido.data, hoje).getDays() > 10) {
				Quantidade desconto = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.90"));
				return multiplicacao(quantidadeNormal).multiplicando(desconto).multiplicar();
			}
			return super.calcularQuantidade(pedido);
		}
	}
	, CANCELADO, PARCIALMENTE_CANCELADO {
		@Override
		boolean isParcialmenteCancelado() {
			return true;
		}
	}, FATURADO, PARCIALMENTE_FATURADO;

	boolean isParcialmenteCancelado() {
		return false;
	}

	public Quantidade calcularQuantidade(Pedido pedido) {
		Map<Produto, Quantidade> produtosNaoCancelados = pedido.getProdutosNaoCancelados();
		Adicao adicao = adicao();
		for (Produto produto: produtosNaoCancelados.keySet()) {
			adicao.somando(produtosNaoCancelados.get(produto));
		}
		return adicao.somar();
	}

}