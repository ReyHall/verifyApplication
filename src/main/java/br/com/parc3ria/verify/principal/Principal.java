package br.com.parc3ria.verify.principal;

import br.com.parc3ria.verify.service.Conversor;
import br.com.parc3ria.verify.service.RequestAPI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {
    private RequestAPI requestAPI = new RequestAPI();
    private Conversor conversor = new Conversor();
    private static final String URL_BASE_EMAIL = "http://emailvalidation.abstractapi.com/v1/?";
    private List<String> listaChoice = Arrays.asList("Email");
    private Map<String, String> apiKeys = new HashMap<>();

    public Principal(@NotNull AppConfig appConfig){
        apiKeys.put("apiKeyEmail", appConfig.getApiKeyEmail());
    }

    @Autowired

    public void showMenu(){

    }
}
