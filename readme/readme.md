#Chatbot para App de Buses en Bogotá

Este proyecto es una **API backend** en Java con Spring Boot para un chatbot que responde preguntas frecuentes sobre rutas de buses en Bogotá. El chatbot se integrará a una app móvil que está siendo desarrollada por otro equipo.

---

## Tecnologías

- Java 17
- Spring Boot
- REST API
- Git + GitHub
- (Próximamente) Base de datos

---

## Equipo de Desarrollo (Backend)

### Parte 1 – Estructura base y recepción de mensajes
> Rama: `feature/api-base`  
Responsable: *[Nombre de la persona]*

- Crear el proyecto Spring Boot
- Configurar controlador REST
- Crear endpoint `/api/chatbot`
- Recibir mensaje JSON y retornar respuesta dummy

### Parte 2 – Lógica de respuesta del chatbot
> Rama: `feature/respuesta-service`  
Responsable: *[Nombre del compañero]*

- Crear servicio que procese preguntas
- Implementar respuestas con lógica básica
- Integrar con el controlador

---

## 🚀 Cómo clonar el proyecto

```bash
git clone https://github.com/chillkavo/Chatbot.git
cd Chatbot
