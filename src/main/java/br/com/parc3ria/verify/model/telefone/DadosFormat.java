package br.com.parc3ria.verify.model.telefone;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFormat(@JsonAlias("international") String internacional,
                          String local) {
}
