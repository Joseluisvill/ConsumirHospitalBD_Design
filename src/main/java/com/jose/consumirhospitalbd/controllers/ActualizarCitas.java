/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumirhospitalbd.controllers;

import com.herrera.clientecitas.entity.Citas;
import com.herrera.clientecitas.services.CitasServices;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Jose Luis
 */
@Named(value = "actualizarCitas")
@ViewScoped
public class ActualizarCitas implements Serializable{
    @Inject
    CitasServices citas_servicio;
    
    Citas citas;

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }
    @PostConstruct
    public void init()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        String id=context.getExternalContext().getRequestParameterMap().get("id");
        citas=citas_servicio.citasId(id);
    }
    public void reset() {
        PrimeFaces.current().resetInputs("actual");
    }
}
