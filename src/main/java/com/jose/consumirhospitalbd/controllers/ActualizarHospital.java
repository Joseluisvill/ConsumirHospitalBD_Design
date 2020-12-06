/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumirhospitalbd.controllers;

//import com.mycompany.clientehospitall.entity.Hospital;
//import com.mycompany.clientehospitall.service.hospitalService;
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
@Named(value = "actualizarHospital")
@ViewScoped
public class ActualizarHospital implements Serializable {
    /*@Inject
    hospitalService hospitalservice;
    
    Hospital hospital;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    @PostConstruct
    public void init()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        String id=context.getExternalContext().getRequestParameterMap().get("id");
        //hospital=hospitalservice.citasId(id);
    }
    public void reset() {
        PrimeFaces.current().resetInputs("actual");
    }*/
}
