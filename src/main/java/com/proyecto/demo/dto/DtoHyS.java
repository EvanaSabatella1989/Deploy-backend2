
package com.proyecto.demo.dto;

import javax.validation.constraints.NotBlank;

public class DtoHyS {
    @NotBlank
    private String nombre;
    private int porcentaje;

    public DtoHyS() {
    }

    public DtoHyS(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
