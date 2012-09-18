package br.com.produtec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:META-INF/spring/applicationContext-jpa.xml")
public class RepositoryConfig {

}