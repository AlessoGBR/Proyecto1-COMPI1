package com.mycompany.back_compi1.Server;

import com.mycompany.back_compi1.Datos.Response;
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

    private RequestHandler requestHandler;
    private static final CopyOnWriteArraySet<Session> sesiones = new CopyOnWriteArraySet<>();
    
    @OnOpen
    public void onOpen(Session session) {
        sesiones.add(session);
        log("CONEXION SERVIDOR -> Nueva conexión: " + session.getId());
        requestHandler = new RequestHandler();
        enviarMensaje(session, "SERVIDOR -> Conexion establecida con el servidor.");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log("MENSAJE SERVIDOR -> Mensaje recibido de " + session.getId() + ": " + message);    
        Response response = requestHandler.processRequest(message);
        enviarMensaje(session, response.toString());
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        log("CONEXION -> Conexión cerrada: " + session.getId() + " Motivo: " + reason.getReasonPhrase());
        sesiones.remove(session);        
        enviarMensaje(session, "SERVIDOR -> Conexion cerrada.");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log("ERROR -> Error en la sesión BK " + session.getId() + ": " + throwable.getMessage());
        enviarMensaje(session, "SERVIDOR -> Error en el servidor.");
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
