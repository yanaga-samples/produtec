package br.com.produtec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.produtec.Telefone.Builder;

public class TelefoneTest {

	@Test
	public void testBuild() {
		Builder builder = Telefone.builder();
		builder.withNumero("30333000");
		assertNotNull(builder.build());
		assertNotNull(builder.withDdd(44).build());
		assertNotNull(builder.withDdi(55).build());
		assertNotNull(Telefone.builder().withDdi(1).withDdd(12).withNumero("12345678").build());
	}

	@Test(expected = IllegalStateException.class)
	public void telefoneSemNumero() {
		Telefone.builder().withDdd(44).build();
	}

	@Test
	public void telefoneFormatado() {
		Telefone telefone = Telefone.builder().withDdi(55).withDdd(44).withNumero("30333000").build();
		assertEquals("+55 (44) 30333000", String.format("%s", telefone));
		telefone = Telefone.builder().withDdd(44).withNumero("30333000").build();
		assertEquals("(44) 30333000", String.format("%s", telefone));
		telefone = Telefone.builder().withNumero("08001230011").build();
		assertEquals("08001230011", String.format("%s", telefone));
	}

	@Test
	public void string() {
		Telefone telefone = Telefone.builder().withDdi(55).withDdd(44).withNumero("30333000").build();
		assertEquals("Telefone{ddi=55, ddd=44, numero=30333000}", telefone.toString());
	}

}