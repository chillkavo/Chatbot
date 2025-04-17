package com.chatbot.backend.controller;

import com.chatbot.backend.dto.MensajeRequest;
import com.chatbot.backend.dto.MensajeResponse;
import com.chatbot.backend.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return new MensajeResponse(respuesta);
    }
}
