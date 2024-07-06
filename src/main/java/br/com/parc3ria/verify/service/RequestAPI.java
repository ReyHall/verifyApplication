package br.com.parc3ria.verify.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestAPI {
    private HttpClient client = HttpClient.newHttpClient();

    public String get(String url){
        URI endereco = URI.create(url);
        HttpResponse<String> response;

        try{
            HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
