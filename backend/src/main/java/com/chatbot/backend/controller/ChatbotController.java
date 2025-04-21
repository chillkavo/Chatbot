package com.chatbot.backend.controller;

import com.chatbot.backend.dto.MensajeRequest;
import com.chatbot.backend.dto.MensajeResponse;
import com.chatbot.backend.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    private final ChatbotService chatbotService;

    @Autowired
    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping
    public MensajeResponse recibirMensaje(@RequestBody MensajeRequest request) {
        String respuesta = chatbotService.obtenerRespuesta(request.getMensaje());
        chatbotService.registrarConversacion(request.getMensaje(), respuesta);
        return new MensajeResponse(request.getMensaje(), respuesta);
    }

    @PostMapping("/registrar") // Endpoint para registrar nuevas preguntas/respuestas
    public String registrarPreguntaYRespuesta(@RequestBody MensajeRequest request) {
        // Solo si el usuario es admin se permite registrar preguntas
        if (request.isAdmin()) {
            chatbotService.registrarPreguntaYRespuesta(request.getMensaje(), request.getRespuesta());
            return "Pregunta y respuesta registradas exitosamente.";
        } else {
            return "No autorizado para registrar nuevas preguntas.";
        }
    }

    @GetMapping("/logs") // Endpoint para obtener el historial de conversaciones
    public List<MensajeResponse> obtenerLogs() {
        return chatbotService.obtenerConversaciones();
    }
}