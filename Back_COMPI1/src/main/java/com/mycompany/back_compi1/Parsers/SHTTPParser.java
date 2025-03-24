/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.back_compi1.Parsers;

/**
 *
 * @author alesso
 */
public class SHTTPParser {

    public SHTTPRequest parse(String message) {
        String[] lines = message.split("\n");
        String[] firstLine = lines[0].split(" ");

        String method = firstLine[0]; 
        String target = firstLine[1];  
        String instruction = lines[1];
        String body = lines.length > 2 ? lines[2] : null;

        return new SHTTPRequest(method, target, instruction, body);
    }
}
