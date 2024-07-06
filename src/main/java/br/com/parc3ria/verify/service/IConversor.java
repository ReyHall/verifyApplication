package br.com.parc3ria.verify.service;

public interface IConversor {
    <T> T obterDados(String json, Class<T> classe);
}
