package com.chatbot.backend.service;

import com.chatbot.backend.dto.MensajeResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatbotService {

    private final Map<String, String> respuestas;
    private final List<MensajeResponse> historialConversaciones = new ArrayList<>();
    private final Map<String, Set<String>> sinonimos;

    public ChatbotService() {
        respuestas = new HashMap<>();
        sinonimos = new HashMap<>();

        sinonimos.put("hola", Set.of("hola", "buenos dias", "buenas tardes", "buenas noches"));
        sinonimos.put("adios", Set.of("adios", "hasta luego", "chao", "nos vemos"));
        sinonimos.put("nombre", Set.of("¿cual es tu nombre?", "como te llamas"));
        sinonimos.put("terminal", Set.of("¿donde queda el terminal el salitre?", "ubicacion del terminal", "como llegar al terminal"));
        sinonimos.put("¿cuanto cuesta un pasaje a bucaramanga?", Set.of("precio a bucaramanga", "valor pasaje bucaramanga", "tarifa bucaramanga"));

        respuestas.put("¿Cuál es tu nombre?", "Soy un chatbot creado con Spring Boot.");
        respuestas.put("Adiós", "¡Hasta luego!");
        respuestas.put("hasta luego", "¡Hasta luego! que estes bien");
        respuestas.put("chao", "¡Hasta luego!");
        respuestas.put("nos vemos", "¡Hasta luego!");   
        respuestas.put("Hola", "Hola Bienvenido al Terminal de Transporte El Salitre");
        respuestas.put("Buenos dias", "Buenos dias ¿En que puedo ayudarte?");
        respuestas.put("Buenas tardes", "Buenas tardes ¿Como te puedo colaborar?");
        respuestas.put("Buenas noches", "Buenas noches ¿En que puedo asistirte?");
        respuestas.put("¿Donde queda el terminal El Salitre?", "El terminal El Salitre esta ubicado en la Av El Dorado con Carrera 69");
        respuestas.put("¿Como llego al terminal?", "Puedes llegar en TransMilenio bajandote en la estacion El Tiempo – Maloka y caminando unos minutos");
        respuestas.put("¿Esta abierto el terminal?", "Si el terminal El Salitre esta abierto las 24 horas del dia");
        respuestas.put("¿Cual es tu nombre?", "Soy un chatbot del Terminal de Transporte El Salitre listo para ayudarte");
        respuestas.put("¿Que buses van a Medellin?", "Puedes tomar empresas como Expreso Bolivariano Rapido Ochoa o Flota Magdalena");
        respuestas.put("¿Hay buses a Cali?", "Si hay salidas frecuentes a Cali con empresas como Expreso Palmira y Bolivariano");
        respuestas.put("¿Cuanto cuesta un pasaje a Bucaramanga?", "El precio puede variar entre 80000 y 120000 depende de la empresa y el servicio");
        respuestas.put("¿Hay rutas a Villavicencio?", "Si salen buses cada hora aproximadamente hacia Villavicencio");
        respuestas.put("¿Que empresas viajan a Neiva?", "Puedes viajar con Cootranshuila o Coomotor");
        respuestas.put("¿Tienen servicio a Tunja?", "Si hay varias salidas diarias a Tunja");
        respuestas.put("¿Hay buses a Cartagena?", "Si aunque el trayecto es largo hay empresas como Berlinas y Expreso Brasilia");
        respuestas.put("¿Que buses van a Santa Marta?", "Puedes usar Expreso Brasilia o Copetran para ir a Santa Marta");
        respuestas.put("¿Hay servicio a Armenia?", "Si hay multiples salidas diarias hacia Armenia");
        respuestas.put("¿Que buses hay para Pereira?", "Puedes viajar con empresas como Expreso Palmira y Velotax");
        respuestas.put("¿Puedo comprar pasajes aqui?", "No directamente pero puedo decirte como reservar en linea o donde encontrarlos en el terminal");
        respuestas.put("¿Tienen servicio nocturno?", "Si muchas rutas tienen horarios nocturnos especialmente destinos largos");
        respuestas.put("¿Tienen baños?", "Si el terminal cuenta con baños publicos en cada modulo");
        respuestas.put("¿Donde estan los cajeros?", "Hay cajeros automaticos cerca de las entradas principales");
        respuestas.put("¿Tienen parqueadero?", "Si el terminal cuenta con servicio de parqueadero para vehiculos particulares");
        respuestas.put("¿Hay WiFi?", "Si el terminal ofrece servicio de WiFi gratuito en ciertas zonas");
        respuestas.put("¿Donde puedo comer?", "Hay una zona de comidas con varias opciones como restaurantes cafeterias y tiendas");
        respuestas.put("¿Tienen atencion al cliente?", "Si puedes dirigirte a los puntos de informacion en cada modulo");
        respuestas.put("¿Donde queda el modulo 1?", "El modulo 1 esta a la entrada principal cerca del punto de taxis");
        respuestas.put("¿Donde estan los taxis?", "Frente al terminal hay una zona exclusiva de taxis autorizados");
        respuestas.put("¿Donde puedo dejar mi maleta?", "El terminal tiene un servicio de guarda equipaje en el modulo 2");
        respuestas.put("¿Tienen servicio para personas con discapacidad?", "Si hay accesos especiales sillas de ruedas y personal capacitado para ayudar");
        respuestas.put("¿Donde puedo recargar mi celular?", "Hay estaciones de carga en la zona de espera principal");
        respuestas.put("¿Tienen lockers?", "Si puedes alquilar lockers para guardar tus pertenencias temporalmente");
        respuestas.put("¿Puedo cambiar dinero?", "Hay casas de cambio dentro del terminal");
        respuestas.put("¿Hay tiendas?", "Si puedes encontrar tiendas de ropa tecnologia libros y mas");
        respuestas.put("¿Donde esta el punto de informacion?", "El punto de informacion principal esta en la entrada del modulo central");
        respuestas.put("¿Es seguro el terminal?", "Si contamos con vigilancia privada y presencia policial");
        respuestas.put("¿Que hago si pierdo algo?", "Puedes reportarlo en la oficina de objetos perdidos del modulo 1");
        respuestas.put("¿Donde esta la policia?", "Hay un CAI de Policia en la entrada principal del terminal");
        respuestas.put("¿Puedo dejar mi bicicleta?", "Si hay parqueadero para bicicletas con vigilancia");
        respuestas.put("¿Tienen servicio medico?", "Si contamos con un punto de atencion medica basica");
        respuestas.put("¿Donde esta la enfermeria?", "Esta ubicada al lado de la entrada norte cerca del modulo 2");
        respuestas.put("¿Que hago si tengo una emergencia?", "Dirigete al punto de informacion mas cercano o llama al 123");
        respuestas.put("¿Cuantos modulos hay?", "El terminal El Salitre tiene tres modulos principales");
        respuestas.put("¿Que horarios manejan las empresas?", "Depende de cada empresa pero la mayoria trabaja desde las 4am hasta las 11pm");
        respuestas.put("¿Puedo pagar con tarjeta?", "Si la mayoria de empresas aceptan pagos con tarjeta debito y credito");
        respuestas.put("¿Puedo viajar con mi mascota?", "Si pero debe estar en guacal y cumplir las normas de transporte");
        respuestas.put("¿Que necesito para viajar?", "Debes tener tu documento de identidad y el pasaje impreso o digital");
        respuestas.put("¿Venden comida tipica?", "Si en la zona de comidas puedes encontrar empanadas arepas tamales y mas");
        respuestas.put("¿Puedo comprar pasajes online?", "Si puedes hacerlo a traves de las paginas web de las empresas de transporte");
        respuestas.put("¿Hay servicio de encomiendas?", "Si muchas empresas ofrecen envio de paquetes desde el terminal");
        respuestas.put("¿Donde recojo una encomienda?", "Cada empresa tiene su oficina de encomiendas dentro del terminal");
        respuestas.put("¿Se puede fumar en el terminal?", "No esta prohibido fumar dentro de las instalaciones");
        respuestas.put("¿Hay zona para fumadores?", "Si hay zonas designadas en exteriores del terminal");
        respuestas.put("¿Que hago si pierdo mi pasaje?", "Debes comunicarte con la empresa con la que ibas a viajar ellos te daran opciones");
        respuestas.put("¿Que pasa si pierdo el bus?", "Debes hablar con la empresa transportadora para ver si pueden reprogramarte");
        respuestas.put("¿El terminal esta cerca del aeropuerto?", "Si esta a unos 15 a 20 minutos del Aeropuerto El Dorado");
        respuestas.put("¿Que rutas de TransMilenio llegan?", "Las rutas que paran cerca son la K86 M86 entre otras");
        respuestas.put("¿Hay hoteles cerca?", "Si hay varios hoteles economicos y de gama media cerca del terminal");
        respuestas.put("¿Tienen servicio de guias turisticos?", "No directamente pero puedes encontrar empresas de turismo dentro del terminal");
        respuestas.put("¿Donde queda la zona de abordaje?", "Cada empresa te indica en que puerta abordar normalmente esta señalizado");
        respuestas.put("¿Hay servicio para adultos mayores?", "Si hay atencion preferencial y sillas reservadas para ellos");
        respuestas.put("¿Que pasa si el bus se retrasa?", "Cada empresa tiene su politica usualmente te informan y pueden reprogramarte");
        respuestas.put("¿Hay buses electricos?", "Algunas empresas ya estan implementando buses electricos en ciertas rutas");
        respuestas.put("¿Que tan puntual salen los buses?", "Generalmente son puntuales pero pueden haber demoras por trafico");
        respuestas.put("¿Como se a que hora sale mi bus?", "Debes revisar tu pasaje o consultar con la empresa transportadora");
        respuestas.put("¿Donde puedo esperar mi bus?", "Hay salas de espera por modulo y sillas disponibles en la zona de abordaje");
    }

    public String obtenerRespuesta(String mensajeUsuario) {
        String mensajeNormalizado = normalizarTexto(mensajeUsuario);
        
        // 1. Búsqueda exacta
    for (Map.Entry<String, String> entry : respuestas.entrySet()) {
        if (normalizarTexto(entry.getKey()).equals(mensajeNormalizado)) {
            return entry.getValue();
        }
    }

        // 2. Búsqueda por sinónimos
    for (Map.Entry<String, Set<String>> entrada : sinonimos.entrySet()) {
        for (String fraseRelacionada : entrada.getValue()) {
            if (mensajeNormalizado.equals(normalizarTexto(fraseRelacionada))) {
                // Usa como clave la frase principal (normalizada) para buscar respuesta
                String clave = normalizarTexto(entrada.getKey());
                for (Map.Entry<String, String> entry : respuestas.entrySet()) {
                    if (normalizarTexto(entry.getKey()).equals(clave)) {
                        return entry.getValue();
                    }
                }
            }
        }
    }

        // 3. Búsqueda por palabras clave
    for (Map.Entry<String, String> entry : respuestas.entrySet()) {
       String pregunta = normalizarTexto(entry.getKey());
        if (mensajeNormalizado.contains(pregunta) || pregunta.contains(mensajeNormalizado)) {
            return entry.getValue();
        }
    }

    return "Lo siento, no entiendo tu pregunta.";
}

    public void registrarPreguntaYRespuesta(String pregunta, String respuesta) {
        String preguntaNormalizada = normalizarTexto(pregunta);
        respuestas.put(preguntaNormalizada, respuesta);

       // Intento básico de extraer sinónimos por palabras clave
      String[] palabras = preguntaNormalizada.split(" ");
        for (String palabra : palabras) {
           sinonimos.computeIfAbsent(preguntaNormalizada, k -> new HashSet<>()).add(palabra);
        }
    }

    public void registrarConversacion(String pregunta, String respuesta) {
        historialConversaciones.add(new MensajeResponse(pregunta, respuesta));
    }

    public List<MensajeResponse> obtenerConversaciones() {
        return historialConversaciones;
    }

    private String normalizarTexto(String texto) {
        texto = texto.toLowerCase().trim();
        texto = texto.replaceAll("[áàäâ]", "a")
                     .replaceAll("[éèëê]", "e")
                     .replaceAll("[íìïî]", "i")
                     .replaceAll("[óòöô]", "o")
                     .replaceAll("[úùüû]", "u")
                     .replaceAll("[ñ]", "n");
        texto = texto.replaceAll("[^a-z0-9 ]", ""); // elimina signos de puntuación
        return texto;
    }
}