/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumirhospitalbd.controllers;

//import com.mycompany.clientehospitall.entity.Hospital;
//import com.mycompany.clientehospitall.service.hospitalService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Jose Luis
 */
@Named(value = "hospitalController")
@ViewScoped
public class HospitalController implements Serializable{
//    @Inject
//    hospitalService hospitalservice;
//    
//    Hospital hospital;
//    
//    String id;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//    private List<Hospital> listahospital;
//
//    public List<Hospital> getListahospital() {
//        this.listahospital  = hospitalservice.listar(hospital) ;
//        return listahospital;
//    }
//
//    public void setListahospital(List<Hospital> listahospital) {
//        this.listahospital = listahospital;
//    }
//
//    public Hospital getHospital() {
//        return hospital;
//    }
//
//    public void setHospital(Hospital hospital) {
//        this.hospital = hospital;
//    }
//    @PostConstruct
//    public void init()
//    {
//        this.hospital=new Hospital();
//    }
//    public void reset() {
//        PrimeFaces.current().resetInputs("form:panel");
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage("Informacion","Se Borraron los campos") );
//    }
//    public String crearHospital()
//    {
//        if(hospitalservice.crear(hospital))
//        {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("Informacion","Se creo Correctamente") );
//        }
//        else
//        {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("Informacion","No creo Correctamente") );
//        }
//        return "";
//    }
//    public String cargaractua(Hospital h)
//    { 
//        String id=h.getId().toString();
//        System.out.println(id);
//        //this.hospital=hospitalservice.;
//        //this.medicamentos=medicamentos;
//        return "";
//    }
//    public String cargaeli(Hospital h)
//    { 
//        //this.hospital=hospitalservice.citasId(id);
//        //this.medicamentos=medicamentos;
//        return "/faces/eliminar_citas.xhtml";
//    }
//    public String eliminar(Hospital h) throws IOException
//    {
//        String id=h.getId().toString();
//        if(hospitalservice.eliminar(id))
//        {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("Informacion","No se Elimino") );
//        }
//        else
//        {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("Informacion","Eliminado Correctamente") );
//        }
//        ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect("index_citas.xhtml");
//        return "";
//    }
//    public String actualizar(Hospital h) throws IOException
//    {
//        hospital.setId(h.getId());
//        hospital.setNombre(h.getNombre());
//        hospital.setProvincia(h.getProvincia());
//        hospital.setDistrito(h.getDistrito());
//        hospital.setCorregimiento(h.getCorregimiento());
//        if(hospitalservice.actualiza(hospital))
//        {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("Informacion","Actualizado") );
//        }
//        else
//        {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("Informacion","No se actualizo Correctamente") );
//        }
//        ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect("index_citas.xhtml");
//        return"";
//    }
//    public void limpiar()
//    { 
//        this.hospital=new Hospital();
//    }
}
