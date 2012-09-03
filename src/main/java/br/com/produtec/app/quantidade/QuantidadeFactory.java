package br.com.produtec.app.quantidade;

import static br.com.produtec.app.quantidade.Quantidade.ARREDONDAMENTO_PADRAO;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

public enum QuantidadeFactory {

	INSTANCE;

	private int casasDecimais;

	public Quantidade newQuantidade(BigDecimal valor) {
		checkNotNull(valor, "Valor da quantidade não pode ser nulo");
		BigDecimal valorArredondado = valor.setScale(casasDecimais, ARREDONDAMENTO_PADRAO);
		return new Quantidade(valorArredondado);
	}

	/**
	 * Deve ser invocado somente na inicialização do sistema. Não é thread-safe.
	 * @param casasDecimais
	 */
	public void setCasasDecimais(int casasDecimais) {
		checkArgument(casasDecimais >= 0, "Quantidade de casas decimais dever ser maior ou igual a zero.");
		this.casasDecimais = casasDecimais;
	}

}