package com.chatbot.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.dto.MensajeRequest;
import com.chatbot.backend.dto.MensajeResponse;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @PostMapping
    public MensajeResponse responderPregunta(@RequestBody MensajeRequest request) {
        String mensaje = request.getMensaje();
        
        // Aquí puedes conectar luego con lógica más compleja
        String respuesta = "Respuesta a tu mensaje: " + mensaje;

        return new MensajeResponse(respuesta);
    }
}
