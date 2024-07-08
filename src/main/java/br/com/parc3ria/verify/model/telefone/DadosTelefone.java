package br.com.parc3ria.verify.model.telefone;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTelefone(@JsonAlias("phone") String telefone,
                            @JsonAlias("valid") Boolean valido,
                            @JsonAlias("format") DadosFormat dadosFormat,
                            @JsonAlias("country") DadosCountry dadosCountry,
                            @JsonAlias("location") String localizacao) {
}
