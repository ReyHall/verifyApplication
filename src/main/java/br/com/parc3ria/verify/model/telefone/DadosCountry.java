package br.com.parc3ria.verify.model.telefone;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosCountry(@JsonAlias("code") String sigla,
                           @JsonAlias("name") String nome,
                           @JsonAlias("prefix") String prefixo) {
}
