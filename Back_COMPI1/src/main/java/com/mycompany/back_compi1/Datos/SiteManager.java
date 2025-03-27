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
import java.util.List;
import java.util.ArrayList;

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

    public String createSite(SCLRequest request) {
        if (request.getParams().isEmpty()) {
            return ERROR + " Se necesita al menos el nombre del sitio.";
        }

        String siteName = request.getParams().get(0);

        if (siteExists(siteName)) {
            System.out.println("El sitio ya existe en el archivo.");
            return ERROR + " El sitio ya existe.";
        }

        String newEntry = "\n[" + siteName + "]\n" + "nombre = \"" + siteName + "\"\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile, true))) {
            writer.write(newEntry);
            System.out.println("Sitio agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo TOML.");
            return ERROR + " Error al escribir en el archivo TOML.";
        }

        return SUCCESS + " Sitio agregado correctamente";
    }

    public String createPage(SCLRequest request) {
        if (request.getParams().size() < 2) {
            return ERROR + ": se requiere el nombre del sitio y de la pagina";
        }

        String siteName = request.getParams().get(0);
        String pageName = request.getParams().get(1);
        String fullSection = "\n[" + siteName + "." + pageName + "]\n";

        if (!siteExists(siteName)) {
            return ERROR + ": el sitio " + siteName + " no existe";
        }

        try {
            String content = Files.readString(configFile.toPath());
            if (content.contains(fullSection)) {
                return ERROR + "La pagina " + pageName + " ya existe en el sitio " + siteName;
            }
        } catch (IOException e) {
            return ERROR + ": error al leer el archivo.";
        }

        String newEntry = fullSection + "\n nombre = \"" + pageName + "\"\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile, true))) {
            writer.write(newEntry);
            System.out.println("Página agregada correctamente.");
        } catch (IOException e) {
            return ERROR + ": error al escribir en el archivo TOML.";
        }

        return SUCCESS + " Pagina " + pageName + " agregada correctamente al sitio " + siteName;
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

            return inSection ? response.toString() : NOT_FOUND + ": Página no encontrada";
        } catch (IOException e) {
            return ERROR + ": " + e.getMessage();
        }
    }

    public String processRequest(SCLRequest request) {
        switch (request.getAccion()) {
            case "obtener":
                if ("sitio".equals(request.getObjetivo())) {
                    return getSite(request);
                }
                if ("pagina".equals(request.getObjetivo())) {
                    return getPagina(request);
                }
                return ERROR + ": Objetivo no reconocido: " + request.getObjetivo();

            case "crear":
            //return createSite(request.getParamStrings());

            case "eliminar":
                return deleteSite(request.getParamStrings())
                        ? SUCCESS + ": Sitio eliminado"
                        : NOT_FOUND + ": Sitio no encontrado";

            default:
                return ERROR + ": Acción no soportada: " + request.getAccion();
        }
    }

    public boolean deleteSite(String siteName) {
        try {
            List<String> lines = Files.readAllLines(configFile.toPath());
            List<String> newLines = new ArrayList<>();
            boolean found = false;
            boolean inSection = false;

            for (String line : lines) {
                if (line.trim().equals("[" + siteName + "]")) {
                    found = true;
                    inSection = true;
                    continue;
                }
                if (inSection && line.trim().startsWith("[")) {
                    inSection = false;
                }
                if (!inSection) {
                    newLines.add(line);
                }
            }

            if (found) {
                Files.write(configFile.toPath(), newLines);
            }
            return found;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean deletePage(String siteName, String pageName) {
        String fullSection = "[" + siteName + "." + pageName + "]";
        try {
            List<String> lines = Files.readAllLines(configFile.toPath());
            List<String> newLines = new ArrayList<>();
            boolean found = false;
            boolean inSection = false;

            for (String line : lines) {
                if (line.trim().equals(fullSection)) {
                    found = true;
                    inSection = true;
                    continue;
                }
                if (inSection && line.trim().startsWith("[") && line.trim().endsWith("]")) {
                    inSection = false;
                }
                if (!inSection) {
                    newLines.add(line);
                }
            }

            if (found) {
                Files.write(configFile.toPath(), newLines);
            }
            return found;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean updateSite(String siteName) {
        try {
            List<String> lines = Files.readAllLines(configFile.toPath());
            List<String> newLines = new ArrayList<>();
            boolean found = false;

            for (String line : lines) {
                if (line.trim().equals("[" + siteName + "]")) {
                    found = true;
                    newLines.add(line);
                    newLines.add("modificado = \"true\"");
                    continue;
                }
                newLines.add(line);
            }

            if (found) {
                Files.write(configFile.toPath(), newLines);
            }
            return found;
        } catch (IOException e) {
            return false;
        }
    }

}
