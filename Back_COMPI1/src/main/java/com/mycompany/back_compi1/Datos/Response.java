/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Datos;

/**
 *
 * @author alesso
 */
public class Response {

    private String status; 
    private String body;  

    public Response(String status, String body) {
        this.status = status;
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return status + (body != null ? body : "");
    }
}
