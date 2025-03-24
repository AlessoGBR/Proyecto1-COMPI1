/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Parsers;

/**
 *
 * @author alesso
 */
public class SHTTPRequest {

    private String metodo;
    private String target;
    private String instruccion;
    private String body;

    public SHTTPRequest(String method, String target, String instruction, String body) {
        this.metodo = method;
        this.target = target;
        this.instruccion = instruction;
        this.body = body;
    }

    public String getMethod() {
        return metodo;
    }

    public String getTarget() {
        return target;
    }

    public String getInstruction() {
        return instruccion;
    }

    public String getBody() {
        return body;
    }
}
