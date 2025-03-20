/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.front.compi1.Conexion;

import jakarta.websocket.*;
import java.io.IOException;
import java.net.URI;
import javax.swing.*;
import org.glassfish.tyrus.client.ClientManager;
/**
 *
 * @author alesso
 */
@ClientEndpoint
public class WebSocketCliente {

    private Session session;
    private JTextArea txtConsola;

    public WebSocketCliente(String uri, JTextArea txtConsola) {
        this.txtConsola = txtConsola;
        try {
            ClientManager client = ClientManager.createClient();
            client.connectToServer(this, new URI(uri));
        } catch (Exception e) {
            log("ERROR-> No se pudo conectar al servidor: " + e.getMessage());
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        log("CONEXION -> Conectado al servidor WebSocket.");
    }

    @OnMessage
    public void onMessage(String message) {
        log(message);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        log("CONEXION -> Conexión cerrada");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log("ERROR -> Error en WebSocket: " + throwable.getMessage());
    }

    public void sendMessage(String message) {
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log("ERROR DE ENVIO -> Error al enviar mensaje: " + e.getMessage());
            }
        } else {
            log("CONEXION -> No hay conexión WebSocket.");
        }
    }

    public boolean isOpen() {
        return session != null && session.isOpen();
    }

    public void close() {
        try {
            if (session != null && session.isOpen()) {
                session.close();                
            }
        } catch (IOException e) {
            log("CONEXION -> Error al cerrar WebSocket: " + e.getMessage());
        }
    }

    private void log(String message) {
       txtConsola.append(message + "\n");
    }
}
