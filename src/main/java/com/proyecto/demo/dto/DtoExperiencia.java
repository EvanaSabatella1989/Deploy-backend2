
package com.proyecto.demo.dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    @NotBlank
    private String nombreE;
    private String descripcionE;
    private String imgE;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE, String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }
    
    
    
    
}
