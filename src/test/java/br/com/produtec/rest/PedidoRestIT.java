package br.com.produtec.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class PedidoRestIT {

	@Test
	public void sequencialPedido() {
		RestTemplate template = new RestTemplate();
		String response = template.getForObject("http://localhost:9090/rest/pedido/numero", String.class);
		assertNotNull(response);
		int primeiroValor = Integer.parseInt(response);
		response = template.getForObject("http://localhost:9090/rest/pedido/numero", String.class);
		int segundoValor = Integer.parseInt(response);
		assertTrue(segundoValor > primeiroValor);
	}

}
