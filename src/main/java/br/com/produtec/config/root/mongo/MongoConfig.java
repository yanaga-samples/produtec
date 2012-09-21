package br.com.produtec.config.root.mongo;

import org.springframework.data.mongodb.MongoDbFactory;

public interface MongoConfig {

	public MongoDbFactory mongoDbFactory() throws Exception;

}