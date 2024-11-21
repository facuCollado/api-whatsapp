package com.apiwsp.whastapp.model;

public record RequestMessage(
        String messaging_product,
        String to,
        RequestMessageText text
) {
}
