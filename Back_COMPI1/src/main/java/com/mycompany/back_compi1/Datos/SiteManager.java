/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Datos;

import com.mycompany.back_compi1.Parsers.SCLRequest;
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
    private static final String SUCCESS = "SUCCES";
    private static final String NOT_FOUND = "NOT_FOUND";
    private static final String ERROR = "INTERNARL_SERVER_ERROR";

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

    public String createSite(String siteName) {
        if (siteExists(siteName)) {
            System.out.println("El sitio ya existe en el archivo.");
            return "El sitio ya existe.";
        }

        String newEntry = "\n[" + siteName + "]\n" + "nombre = \"" + siteName + "\"\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile, true))) {
            writer.write(newEntry);
            System.out.println("Sitio agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo TOML.");
            return "Error al escribir en el archivo TOML.";
        }

        return "Sitio agregado correctamente";
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

    public String getSite(SCLRequest request) {
        if (request.getParams().size() < 1) {
            return ERROR + ": se necesita el nombre de un sitio";
        }

        String siteName = request.getParams().get(0);
        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            StringBuilder response = new StringBuilder();
            boolean inSection = false;
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("[" + siteName + "]")) {
                    inSection = true;
                    response.append(SUCCESS + ": ");
                    continue;
                }

                if (inSection) {
                    if (line.trim().startsWith("[")) {
                        break;
                    }
                    if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
                        response.append(line);
                    }
                }
            }

            return inSection ? response.toString() : NOT_FOUND + ": ";
        } catch (IOException e) {
            return ERROR + ": " + e.getMessage();
        }
    }

    public String getPagina(SCLRequest request) {
        if (request.getParams().size() < 2) {
            return ERROR + ": Se requiere nombre del sitio y página";
        }

        String siteName = request.getParams().get(0);
        String pageName = request.getParams().get(1);
        String fullSection = "[" + siteName + "." + pageName + "]";

        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            StringBuilder response = new StringBuilder();
            boolean inSection = false;
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(fullSection)) {
                    inSection = true;
                    response.append(SUCCESS);
                    continue;
                }

                if (inSection) {
                    if (line.trim().startsWith("[")) {
                        break;
                    }
                    if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
                        response.append(line);
                    }
                }
            }

            return inSection ? response.toString() : SUCCESS + ": ";
        } catch (IOException e) {
            return ERROR + ": " + e.getMessage();
        }
    }

    public String processRequest(SCLRequest request) {
        switch (request.getAccion()) {
            case "obtener":
                break;
            case "abrir":
                switch (request.getObjetivo()) {
                    case "sitio":
                        return getSite(request);
                    case "pagina":
                        return getPagina(request);
                    default:
                        return ERROR + ": Objetivo no reconocido: " + request.getObjetivo();
                }
            default:
                return ERROR + ": Acción no soportada: " + request.getAccion();
        }
        return "";
    }

}
