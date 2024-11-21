package com.apiwsp.whastapp.model;

import java.util.List;

public record ResponseWhastapp(
        String messaging_product,
        List<ResponseWhatsappContact> contacts,
        List<ResponseWhatsappMessages> messages
) {
}
