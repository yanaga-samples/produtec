package br.com.produtec.config.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.produtec.rest", scopedProxy = ScopedProxyMode.TARGET_CLASS, useDefaultFilters = false, includeFilters = {
		@Filter(Controller.class), @Filter(Configuration.class) })
public class RestServletConfig extends WebMvcConfigurerAdapter {

}