package br.com.parc3ria.verify.principal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import javax.validation.constraints.NotNull;

@Configuration
public class AppConfig {
    @Value("${spring.apikey.verify.email.application}")
    private String apiKeyEmail;

    @NotNull
    public String getApiKeyEmail(){
        return apiKeyEmail;
    }
}
