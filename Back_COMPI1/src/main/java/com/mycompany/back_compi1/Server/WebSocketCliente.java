/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Server;

import jakarta.websocket.*;
import java.net.URI;

/**
 *
 * @author alesso
 */
@ClientEndpoint
public class WebSocketCliente {

    private Session session;

    public WebSocketCliente(String uri) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(uri));
        } catch (Exception e) {
            log("ERROR -> Error al conectar en servidor: " + e.getMessage());
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        log("CONEXION -> Conectado al WebSocket del servidor.");
    }

    @OnMessage
    public void onMessage(String message) {
        log("MENSAJE -> Mensaje del servidor: " + message);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        log("CONEXION -> Conexión cerrada: " + reason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log("ERROR -> Error en WebSocket servidor: " + throwable.getMessage());
    }

    public void enviarMensaje(String message) {
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                log("ERROR -> Error al enviar mensaje: " + e.getMessage());
            }
        } else {
            log("CONEXION -> No hay conexión WebSocket.");
        }
    }

    public void cerrarConexion() {
        try {
            if (session != null && session.isOpen()) {
                session.close();
                log("CONEXION -> WebSocket cerrado.");
            }
        } catch (Exception e) {
            log("ERROR -> Error al cerrar WebSocket: " + e.getMessage());
        }
    }

    private void log(String mensaje) {
        System.out.println(mensaje);
    }

}
