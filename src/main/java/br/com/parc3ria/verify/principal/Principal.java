package br.com.parc3ria.verify.principal;

import br.com.parc3ria.verify.service.Conversor;
import br.com.parc3ria.verify.service.RequestAPI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.*;

public class Principal {
    private RequestAPI requestAPI = new RequestAPI();
    private Conversor conversor = new Conversor();
    private Scanner scanner = new Scanner(System.in);
    private static final String URL_BASE_EMAIL = "http://emailvalidation.abstractapi.com/v1/?";
    private List<String> listaChoice = Arrays.asList("Email");
    private Map<String, String> apiKeys = new HashMap<>();

    public Principal(@NotNull AppConfig appConfig){
        apiKeys.put("apiKeyEmail", appConfig.getApiKeyEmail());
    }

    @Autowired

    public void showMenu(){
        listaChoice.forEach(System.out::println);
        System.out.print("Digite qual opção acima deseja escolher: ");
        var choice = getValidationChoice(scanner.nextLine());
    }

    private String getValidationChoice(String choice){
        return listaChoice.stream()
                .map(String::toLowerCase)
                .filter(f -> f.contains(choice.toLowerCase()))
                .findFirst()
                .orElseGet(() -> listaChoice.get((int) (Math.random() * listaChoice.size())));
    }
}