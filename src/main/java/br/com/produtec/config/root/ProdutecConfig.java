package br.com.produtec.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"br.com.produtec.app", "br.com.produtec.config.root"}, scopedProxy = ScopedProxyMode.TARGET_CLASS, excludeFilters = @Filter(Controller.class))
public class ProdutecConfig {

}