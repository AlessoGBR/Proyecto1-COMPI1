/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Server;

import com.mycompany.back_compi1.Datos.PageManager;
import com.mycompany.back_compi1.Datos.Response;

/**
 *
 * @author alesso
 */
public class SCLProcessor {
    
    public static Response executeCommand(String command, String body) {
        String[] parts = command.split(" ");
        String action = parts[0];
        String target = parts[1];

        switch (action) {
            case "crear":
                if ("pagina".equals(target)) {
                    String siteName = parts[2];
                    String pageName = parts[3];
                    return PageManager.createPage(siteName, pageName, body);
                }
                break;
            case "eliminar":
                
                break;
        }
        return new Response("ERROR -> ", "Comando no reconocido");
    }
}
