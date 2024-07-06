package br.com.parc3ria.verify.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conversor implements IConversor {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try{
            var dados = mapper.readValue(json, classe);
            return dados;
        } catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
