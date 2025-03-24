/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author alesso
 */
public class SiteManager {

    private File configFile;

    public SiteManager() {
        String projectDir = System.getProperty("user.dir");
        this.configFile = new File(projectDir, "sites.toml");

        if (!configFile.exists()) {
            try {
                boolean created = configFile.createNewFile();
                if (created) {
                    System.out.println("Archivo creado en: " + configFile.getAbsolutePath());
                }
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el archivo TOML.", e);
            }
        } else {
            System.out.println("El archivo sites.toml ya existe en: " + configFile.getAbsolutePath());
        }
    }

    public String getFilePath() {
        return configFile.getAbsolutePath();
    }

    public void createSite(String siteName) {
        if (siteExists(siteName)) {
            System.out.println("El sitio ya existe en el archivo.");
            return;
        }

        String newEntry = "\n[" + siteName + "]\n" + "nombre = \"" + siteName + "\"\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile, true))) {
            writer.write(newEntry);
            System.out.println("Sitio agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo TOML.");
        }
    }

    public boolean siteExists(String siteName) {
        try {
            String content = Files.readString(configFile.toPath());
            return content.contains("[" + siteName + "]");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            return false;
        }
    }

    public String getSite(String siteName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            String line;
            boolean found = false;
            StringBuilder siteInfo = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[" + siteName + "]")) {
                    found = true;
                    siteInfo.append(line).append("\n");
                } else if (found && line.startsWith("[")) {
                    break; 
                } else if (found) {
                    siteInfo.append(line).append("\n");
                }
            }

            return found ? siteInfo.toString() : "Sitio no encontrado.";
        } catch (IOException e) {
            return "Error al leer el archivo.";
        }
    }
}
