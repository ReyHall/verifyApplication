package br.com.parc3ria.verify.model.email;

import com.fasterxml.jackson.annotation.JsonAlias;

public record IsEmail(@JsonAlias("value") Boolean valor,
                      @JsonAlias("text") String texto) {
}
