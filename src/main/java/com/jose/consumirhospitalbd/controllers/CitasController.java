/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumirhospitalbd.controllers;

import com.herrera.clientecitas.entity.Citas;
import com.herrera.clientecitas.services.CitasServices;
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
@Named(value = "citasController")
@ViewScoped
public class CitasController implements Serializable{
    @Inject
    CitasServices citas_servicio;
    
    String id;
    private List<Citas> listacitas;
    Citas citas;

    public CitasServices getCitas_servicio() {
        return citas_servicio;
    }

    public void setCitas_servicio(CitasServices citas_servicio) {
        this.citas_servicio = citas_servicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Citas> getListacitas() {
        this.listacitas  = citas_servicio.listar(citas);
        return listacitas;
    }

    public void setListacitas(List<Citas> listacitas) {
        this.listacitas = listacitas;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }
    @PostConstruct
    public void init()
    {
        this.citas=new Citas();
    }
    public void reset() {
        PrimeFaces.current().resetInputs("form:panel");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion","Se Borraron los campos") );
    }
     public String crearcitas()
    {
        if(citas_servicio.crear(citas))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","Se creo Correctamente") );
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","No creo Correctamente") );
        }
        return "";
    }
    public String cargaractua(Citas citas)
    { 
        String id=citas.getIdcita().toString();
        System.out.println(id);
        this.citas=citas_servicio.citasId(id);
        //this.medicamentos=medicamentos;
        return "";
    }
    public String cargaeli(Citas citas)
    { 
        this.citas=citas_servicio.citasId(id);
        //this.medicamentos=medicamentos;
        return "/faces/eliminar_citas.xhtml";
    }
    public String eliminar(Citas c) throws IOException
    {
        String id=c.getIdcita().toString();
        System.out.println(id);
        if(citas_servicio.eliminar(id))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","No se Elimino") );
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","Eliminado Correctamente") );
        }
        ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("index_citas.xhtml");
        return "";
    }
    public String actualizar(Citas c) throws IOException
    {
        //Medicamentos m=getMedicamentos();
        citas.setIdcita(c.getIdcita());
        citas.setMotivo(c.getMotivo());
        citas.setIdsala(c.getIdsala());
        citas.setCedpaciente(c.getCedpaciente());
        citas.setFecha(c.getFecha());
        //System.out.println(m.getDescripcion());
        if(citas_servicio.actualiza(citas))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","Actualizado") );
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","No se actualizo Correctamente") );
        }
        ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("index_citas.xhtml");
        return"";
    }
    public void limpiar()
    { 
        this.citas=new Citas();
    }
}
