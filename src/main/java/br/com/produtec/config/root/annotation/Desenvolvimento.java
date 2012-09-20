package br.com.produtec.config.root.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

@Profile("desenvolvimento")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desenvolvimento {

}
