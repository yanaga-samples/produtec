package br.com.produtec.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan("br.com.produtec")
@Configuration
public class ProdutecConfig {

}