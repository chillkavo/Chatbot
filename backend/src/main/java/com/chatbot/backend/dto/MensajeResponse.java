package com.chatbot.backend.dto;

public class MensajeResponse {
    private String respuesta;

    public MensajeResponse(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
