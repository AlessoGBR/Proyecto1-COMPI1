/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Server;

import com.mycompany.back_compi1.Datos.Response;
import com.mycompany.back_compi1.Datos.SiteManager;
import com.mycompany.back_compi1.Lexer.sCL.sCLLexer;
import com.mycompany.back_compi1.Lexer.sHTTP.sHTTPLexer;
import com.mycompany.back_compi1.Parsers.SCLRequest;
import com.mycompany.back_compi1.Parsers.SHTTPRequest;
import com.mycompany.back_compi1.Parsers.sCL.ParserScl;
import com.mycompany.back_compi1.Parsers.sHTTP.Parser;
import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author alesso
 */
public class RequestHandler {

    private SiteManager siteManager;
    private SHTTPRequest shttpRequest;
    private SCLRequest sclRequest;

    public RequestHandler() {
        this.siteManager = new SiteManager();
    }

    public Response processRequest(String message) {

        try {
            sHTTPLexer lexer = new sHTTPLexer(new BufferedReader(new StringReader(message)));
            Parser parser = new Parser(lexer);
            shttpRequest = (SHTTPRequest) parser.parse().value;
            sCLLexer sclLexer = new sCLLexer(new BufferedReader(new StringReader(shttpRequest.getInstruction())));
            ParserScl parserScl = new ParserScl(sclLexer);
            sclRequest = (SCLRequest) parserScl.parse().value;

        } catch (Exception e) {
            return new Response("ERROR -> ", "ERROR INESPERADO: " + e);
        }

        switch (shttpRequest.getMethod()) {
            case "GET":
                return handleGet(shttpRequest);
            case "POST":
                return handlePost(shttpRequest);
            case "DELETE":
                return handleDelete(shttpRequest);
            case "PATCH":
                return handlePatch(shttpRequest);
            default:
                return new Response("ERROR -> ", "Objetivo desconocido");
        }
    }

    private Response handleGet(SHTTPRequest request) {
        if ("SITIO".equals(request.getTarget())) {
            return new Response("RESPUESTA -> ", siteManager.getSite(sclRequest));
        } else if ("PAGINA".equals(request.getTarget())) {
            return new Response("RESPUESTA -> ", siteManager.getPagina(sclRequest));
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
            boolean deleted = siteManager.deleteSite(request.getInstruction());
            return deleted
                    ? new Response("EXITO -> ", "Sitio eliminado correctamente.")
                    : new Response("ERROR -> ", "No se encontró el sitio.");
        }
        return new Response("ERROR -> ", "Objetivo desconocido");
    }

    private Response handlePatch(SHTTPRequest request) {
        if ("SITIO".equals(request.getTarget())) {
            boolean updated = siteManager.updateSite(request.getInstruction());
            return updated
                    ? new Response("EXITO -> ", "Sitio actualizado correctamente.")
                    : new Response("ERROR -> ", "No se encontró el sitio.");
        }
        return new Response("ERROR -> ", "Objetivo desconocido");
    }

}
