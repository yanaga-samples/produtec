package br.com.produtec.app.notafiscal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.produtec.app.notafiscal.NotaFiscal;

public interface NotaFiscalRepository extends MongoRepository<NotaFiscal, String> {

}