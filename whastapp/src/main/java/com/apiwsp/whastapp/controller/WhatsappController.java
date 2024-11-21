package com.apiwsp.whastapp.controller;

import com.apiwsp.whastapp.dto.MessageBodyDTO;
import com.apiwsp.whastapp.model.ResponseWhastapp;
import com.apiwsp.whastapp.service.ApiWhatsappService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/whatsapp") //asignar solicitudes a métodos de controladores.
public class WhatsappController {


    private final ApiWhatsappService apiWhatsappService;
    public WhatsappController(ApiWhatsappService apiWhatsappService) {
        this.apiWhatsappService = apiWhatsappService;
    }
    @PostMapping("/send") //para que este expuesto el metodo
    ResponseWhastapp send(@RequestBody MessageBodyDTO payload){ //@REQUESTBODY Asigna el cuerpo de HttpRequest a unDTO , lo que permite la deserialización automática del cuerpo.

        return apiWhatsappService.sendMessage(payload);
    }
}
