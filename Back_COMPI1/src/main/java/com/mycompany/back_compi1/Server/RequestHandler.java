/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Server;

import com.mycompany.back_compi1.Datos.Response;
import com.mycompany.back_compi1.Datos.SiteManager;
import com.mycompany.back_compi1.Lexer.sHTTP.sHTTPLexer;
import com.mycompany.back_compi1.Parsers.SHTTPRequest;
import com.mycompany.back_compi1.Parsers.sHTTP.Parser;
import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author alesso
 */
public class RequestHandler {

    private SiteManager siteManager;

    public RequestHandler() {
        this.siteManager = new SiteManager();
    }

    public Response processRequest(String message) {
        SHTTPRequest request = null;
        try {
            sHTTPLexer lexer = new sHTTPLexer(new BufferedReader(new StringReader(message)));
            Parser parser = new Parser(lexer);
            Object resultado = parser.parse().value;
            System.out.println("parser result: " + resultado);
            System.out.println("tipo de resultado: " + resultado.getClass().getName());
            if (resultado instanceof SHTTPRequest) {
                request = (SHTTPRequest) resultado;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en el parseo de sHTTP: " + e.getMessage(), e);
        }

        switch (request.getMethod()) {
            case "GET":
                return handleGet(request);
            case "POST":
                return handlePost(request);
            case "DELTE":
                return handleDelete(request);
            case "PATCH":
                return handlePatch(request);
            default:
                return new Response("ERROR -> ", "Metodo desconocido");
        }
    }

    private Response handleGet(SHTTPRequest request) {
        if ("SITIO".equals(request.getTarget())) {
            return new Response("EXITO -> ", siteManager.getSite(request.getInstruction()));
        }
        return new Response("ERROR -> ", "Objetivo desconocido");
    }

    private Response handlePost(SHTTPRequest request) {
        if ("SITIO".equals(request.getTarget())) {
            String crear = siteManager.createSite(request.getInstruction());
            return new Response("RESPUESTA -> ", crear);
        }
        return new Response("ERROR -> ", "Objetivo desconocido");
    }

    private Response handleDelete(SHTTPRequest request) {
        if ("SITIO".equals(request.getTarget())) {
            siteManager.createSite(request.getInstruction());
            return new Response("EXITO -> ", "Sitio creado exitosamente.");
        }
        return new Response("ERROR -> ", "Objetivo desconocido");
    }

    private Response handlePatch(SHTTPRequest request) {
        if ("SITIO".equals(request.getTarget())) {
            siteManager.createSite(request.getInstruction());
            return new Response("EXITO -> ", "Sitio creado exitosamente.");
        }
        return new Response("ERROR -> ", "Objetivo desconocido");
    }
}
