package com.chatbot.backend.dto;

import java.time.LocalDateTime;

public class MensajeResponse {
    private String preguntaOriginal;
    private String respuesta;
    private LocalDateTime timestamp;

    public MensajeResponse(String preguntaOriginal, String respuesta) {
        this.preguntaOriginal = preguntaOriginal;
        this.respuesta = respuesta;
        this.timestamp = LocalDateTime.now();
    }

    public String getPreguntaOriginal() {
        return preguntaOriginal;
    }

    public void setPreguntaOriginal(String preguntaOriginal) {
        this.preguntaOriginal = preguntaOriginal;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}