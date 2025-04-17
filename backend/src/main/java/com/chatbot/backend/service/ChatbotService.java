package com.chatbot.backend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {

    private final Map<String, String> respuestas;

    public ChatbotService() {
        respuestas = new HashMap<>();
        respuestas.put("Hola", "¡Hola! ¿Cómo estás?");
        respuestas.put("¿Cuál es tu nombre?", "Soy un chatbot creado con Spring Boot.");
        respuestas.put("Adiós", "¡Hasta luego!");
    }

    public String obtenerRespuesta(String mensaje) {
        return respuestas.getOrDefault(mensaje, "Lo siento, no entiendo tu pregunta.");
    }
}
