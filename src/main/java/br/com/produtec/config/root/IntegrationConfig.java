package br.com.produtec.config.root;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:META-INF/spring/applicationContext-integration.xml")
@Configuration
public class IntegrationConfig {

}
