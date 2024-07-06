package br.com.parc3ria.verify.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosEmail(String email,
                         @JsonAlias("deliverability") String entrega,
                         @JsonAlias("quality_score") String qualidade) {
}
