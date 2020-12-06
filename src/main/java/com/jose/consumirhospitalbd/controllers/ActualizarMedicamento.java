/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumirhospitalbd.controllers;

import com.jose.clientmedicamento.entity.Medicamentos;
import com.jose.clientmedicamento.services.MedicamentoServices;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Jose Luis
 */
@Named(value = "actualizarMedicamento")
@ViewScoped
public class ActualizarMedicamento implements Serializable {
    
    @Inject
    MedicamentoServices medicamentoservices;
    
    Medicamentos medicamentos;

    public Medicamentos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    @PostConstruct
    public void init()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        String id=context.getExternalContext().getRequestParameterMap().get("id");
        medicamentos=medicamentoservices.obtenerporid(id);
    }
    public void reset() {
        PrimeFaces.current().resetInputs("actual");
    }
}
