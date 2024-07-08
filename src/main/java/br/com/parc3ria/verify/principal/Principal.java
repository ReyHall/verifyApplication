package br.com.parc3ria.verify.principal;

import br.com.parc3ria.verify.model.email.DadosEmail;
import br.com.parc3ria.verify.model.email.Email;
import br.com.parc3ria.verify.model.telefone.DadosTelefone;
import br.com.parc3ria.verify.model.telefone.Telefone;
import br.com.parc3ria.verify.service.Conversor;
import br.com.parc3ria.verify.service.RequestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.*;

@Component
public class Principal {
    private RequestAPI requestAPI = new RequestAPI();
    private Conversor conversor = new Conversor();
    private Scanner scanner = new Scanner(System.in);
    private static final String URL_BASE_EMAIL = "https://emailvalidation.abstractapi.com/v1/?";
    private static final String URL_BASE_TELEFONE = "https://phonevalidation.abstractapi.com/v1/?";
    private List<String> listaChoice = Arrays.asList("Email", "Telefone");
    private Map<String, String> apiKeys = new HashMap<>();

    public Principal(@NotNull AppConfig appConfig){
        apiKeys.put("apiKeyEmail", appConfig.getApiKeyEmail());
        apiKeys.put("apiKeyTelefone", appConfig.getApiKeyTelefone());
    }

    @Autowired

    public void showMenu(){
        listaChoice.forEach(System.out::println);
        System.out.print("Digite qual opção acima deseja escolher: ");
        var choice = getValidationChoice(scanner.nextLine());
        getDados(choice);
        System.exit(0);
    }

    private String getValidationChoice(String choice){
        return listaChoice.stream()
                .map(String::toLowerCase)
                .filter(f -> f.contains(choice.toLowerCase()))
                .findFirst()
                .orElseGet(() -> listaChoice.get((int) (Math.random() * listaChoice.size())));
    }

    private void getDados(String choice){
        String json;
        String campo;
        String key;

        switch (choice){
            case "email":
                key = apiKeys.get("apiKeyEmail");
                System.out.print("Digite um email para verificar se e valido: ");
                campo = scanner.next().toLowerCase();
                scanner.nextLine();

                json = requestAPI.get(URL_BASE_EMAIL + key + "&email=" + campo);
                DadosEmail dadosEmail = conversor.obterDados(json, DadosEmail.class);
                Email emailDados = new Email(dadosEmail);
                printDados(emailDados);
                break;

            case "telefone":
                key = apiKeys.get("apiKeyTelefone");
                System.out.print("Digite um numero de telefone para verificar se e valido (Inclua Prefixo e DD): ");
                campo = scanner.nextLine();
                campo = campo.replaceAll("\\s+", "");
                json = requestAPI.get(URL_BASE_TELEFONE + key + "&phone=" + campo);
                DadosTelefone dadosTelefone = conversor.obterDados(json, DadosTelefone.class);
                Telefone telefone = new Telefone(dadosTelefone);
                printDados(telefone);

            default:
                break;
        }
    }

    private <T> void printDados(T dados){
        if(dados instanceof Email){
            System.out.print(
                    "\nEmail: " + ((Email) dados).getEmail() +
                            "\nQualidade: " + ((Email) dados).getQualidade() +
                            "\nEmail valido: " + ((Email) dados).getEmailValido() +
                            "\nEmail gratis: " + ((Email) dados).getEmailGratis() +
                            "\nEntrega: " + ((Email) dados).getEntrega()
            );
        } else if(dados instanceof Telefone){
            System.out.print(
                    "\nTelefone: " + ((Telefone) dados).getTelefone() +
                            "\nValido: " + ((Telefone) dados).getValido() +
                            "\nInternacional: " + ((Telefone) dados).getInternacional() +
                            "\nLocal: " + ((Telefone) dados).getLocal() +
                            "\nPais: " + ((Telefone) dados).getNome() +
                            "\nPrefixo: " + ((Telefone) dados).getPrefixo() +
                            "\nLocalização: " + ((Telefone) dados).getLocalizacao()
            );
        }
    }
}