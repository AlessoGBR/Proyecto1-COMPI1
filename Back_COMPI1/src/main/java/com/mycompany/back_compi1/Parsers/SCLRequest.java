package com.mycompany.back_compi1.Parsers;

import java.util.ArrayList;
import java.util.List;

public class SCLRequest {

    private String accion;
    private String objetivo;
    private List<String> params;

    public SCLRequest(String accion, String objetivo, List<String> params) {
        this.accion = accion;
        this.objetivo = objetivo;
        this.params = params != null ? params : new ArrayList<>();
    }

    public String getAccion() {
        return accion;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public List<String> getParams() {
        return params;
    }

    public String getParamStrings() {
        return String.join(" ", params);
    }
}
