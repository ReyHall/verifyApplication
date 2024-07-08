package br.com.parc3ria.verify.principal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Configuration
public class AppConfig {
    @Value("${spring.apikey.verify.email.application}")
    private String apiKeyEmail;

    @Value("${spring.apikey.verify.telefone.application}")
    private String apiKeyTelefone;

    @NotNull
    public String getApiKeyEmail() { return apiKeyEmail; }
    @NotNull
    public String getApiKeyTelefone() { return apiKeyTelefone; }
}
