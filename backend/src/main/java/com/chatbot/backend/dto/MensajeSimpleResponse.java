// MensajeSimpleResponse.java
package com.chatbot.backend.dto;

public class MensajeSimpleResponse {
    private String respuesta;

    public MensajeSimpleResponse(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
