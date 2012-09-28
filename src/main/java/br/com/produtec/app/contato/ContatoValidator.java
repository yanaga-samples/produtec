package br.com.produtec.app.contato;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class ContatoValidator {

	public boolean validate(Contato contato, MessageContext messages) {
		if (contato.getNome().startsWith("a")) {
			messages.addMessage(new MessageBuilder().error().source("contatoForm:nome").defaultText("Nome não pode começar com 'a'")
					.build());
			messages.addMessage(new MessageBuilder().error().source("contatoForm:nome").defaultText("Nome feio")
					.build());
			messages.addMessage(new MessageBuilder().error().defaultText("Você errou!")
					.build());
			messages.addMessage(new MessageBuilder().info().defaultText("Bobão!")
					.build());
			return false;
		}
		return true;
	}

}