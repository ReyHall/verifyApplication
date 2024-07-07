package br.com.parc3ria.verify.model.email;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEmail(String email,
                         @JsonAlias("deliverability") String entrega,
                         @JsonAlias("quality_score") String qualidade,
                         @JsonAlias("is_valid_format") IsEmail isValidoFormato,
                         @JsonAlias("is_free_email") IsEmail isEmailGratis) {
}
