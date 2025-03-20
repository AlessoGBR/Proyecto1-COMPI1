/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.front.compi1.Conexion;

import jakarta.websocket.*;
import java.net.URI;

/**
 *
 * @author alesso
 */
public class WebSocket {

    private Session session;

    public WebSocket() {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI("ws://localhost:8080/Back_COMPI1/websocket"));
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar al servidor WebSocket", e);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conectado al servidor WebSocket");
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Mensaje recibido del servidor: " + message);
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar mensaje al servidor WebSocket", e);
        }
    }
}
