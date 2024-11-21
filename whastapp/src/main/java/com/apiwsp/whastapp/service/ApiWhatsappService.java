package com.apiwsp.whastapp.service;

import com.apiwsp.whastapp.constants.Constants;
import com.apiwsp.whastapp.dto.MessageBodyDTO;
import com.apiwsp.whastapp.model.RequestMessage;
import com.apiwsp.whastapp.model.RequestMessageText;
import com.apiwsp.whastapp.model.ResponseWhastapp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

@Service
public class ApiWhatsappService {

    private final RestClient restClient;

    public ApiWhatsappService() {
        restClient = RestClient.builder()
                .baseUrl(Constants.BASE_URL)
                .defaultHeader(Constants.HEADER, Constants.TOKEN)
                .build();
    }

    public ResponseWhastapp sendMessage(MessageBodyDTO payload){
        RequestMessage requestMessage = new RequestMessage(Constants.MESSAGIN_PRODUCT, payload.number(), new RequestMessageText(payload.message()));
        try{
            String response = restClient.post()
                    .uri("")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestMessage)
                    .retrieve()
                    .body(String.class);

            ObjectMapper obj = new ObjectMapper(); //convertir el string a un JSON
            return obj.readValue(response, ResponseWhastapp.class);

        } catch (RestClientException e) {
            throw new RestClientResponseException("Error to send message", 400, "Error to send message", null, null, null);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
