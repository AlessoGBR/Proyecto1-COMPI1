/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alesso
 */
public class PageManager {

    public static Response createPage(String siteName, String pageName, String body) {
        String filePath = "sites/" + siteName + "/" + pageName + ".mtsx";
        File file = new File(filePath);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(body);
            return new Response("SUCCESS-> ", "Página creada en " + filePath);
        } catch (IOException e) {
            return new Response("ERROR-> ", "No se pudo crear la página");
        }
    }
}
