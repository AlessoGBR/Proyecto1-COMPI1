package com.mycompany.back_compi1;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author alesso
 */
@ServerEndpoint("/websocket")
public class WebSocketServidor {

    private static final CopyOnWriteArraySet<Session> sesiones = new CopyOnWriteArraySet<>();

     @OnOpen
    public void onOpen(Session session) {
        sesiones.add(session);
        log("CONEXION SERVIDOR -> Nueva conexión: " + session.getId());
        enviarMensaje(session, "SERVIDOR -> Conexion establecida con el servidor.");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log("MENSAJE SERVIDOR -> Mensaje recibido de " + session.getId() + ": " + message);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        sesiones.remove(session);
        log("CONEXION -> Conexión cerrada: " + session.getId() + " Motivo: " + reason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log("ERROR -> Error en la sesión BK " + session.getId() + ": " + throwable.getMessage());
    }

    public void enviarMensaje(Session session, String mensaje) {
        try {
            session.getBasicRemote().sendText(mensaje);
        } catch (IOException e) {
            log("ERROR EN MENSAJE DE SERVIDOR -> Error al enviar mensaje: " + e.getMessage());
        }
    }

    private void log(String mensaje) {
        System.out.println(mensaje);
    }
}
