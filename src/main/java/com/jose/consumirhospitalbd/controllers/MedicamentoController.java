/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.consumirhospitalbd.controllers;



import com.jose.clientmedicamento.services.MedicamentoServices;
import com.jose.clientmedicamento.entity.Medicamentos;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Jose Luis
 */
@Named(value = "medicamentoController")
@ViewScoped
public class MedicamentoController implements Serializable {

    
    //<editor-fold defaultstate="collapsed" desc="variables">
    @Inject
            MedicamentoServices medicamentoservices;
    
    String id;
    
    private List<Medicamentos> listamedicamentos;
    Medicamentos medicamentos;
//</editor-fold>
    

    //<editor-fold defaultstate="collapsed" desc="Getter-Setter">
    public List<Medicamentos> getListamedicamentos() {
        this.listamedicamentos  = medicamentoservices.listar(medicamentos);
        return listamedicamentos;
    }
    
    public void setListamedicamentos(List<Medicamentos> listamedicamentos) {
        this.listamedicamentos = listamedicamentos;
    }
    
    public Medicamentos getMedicamentos() {
        return medicamentos;
    }
    
    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }
//</editor-fold>
    
    @PostConstruct
    public void init()
    {
        this.medicamentos=new Medicamentos();
    }
    public void reset() {
        PrimeFaces.current().resetInputs("form:panel");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion","Se Borraron los campos") );
    }
     public String crearMedicamentos()
    {
        if(medicamentoservices.crear(medicamentos))
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
    public String cargaractua(Medicamentos medicamentos)
    { 
        String id=medicamentos.getId().toString();
        System.out.println(id);
        this.medicamentos=medicamentoservices.obtenerporid(id);
        //this.medicamentos=medicamentos;
        return "";
    }
    public String cargaeli(Medicamentos medicamentos)
    { 
        this.medicamentos=medicamentoservices.obtenerporid(id);
        //this.medicamentos=medicamentos;
        return "/faces/eliminar.xhtml";
    }
    public String eliminar(Medicamentos m) throws IOException
    {
        String id=m.getId().toString();
        System.out.println(id);
        if(medicamentoservices.eliminar(id))
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
        context.redirect("index.xhtml");
        return "";
    }
    public String actualizar(Medicamentos m) throws IOException
    {
        //Medicamentos m=getMedicamentos();
        medicamentos.setId(m.getId());
        medicamentos.setNombre(m.getNombre());
        medicamentos.setCantidad(m.getCantidad());
        medicamentos.setDescripcion(m.getDescripcion());
        //System.out.println(m.getDescripcion());
        if(medicamentoservices.actualiza(medicamentos))
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
        context.redirect("index.xhtml");
        return"";
    }
    public void limpiar()
    { 
        this.medicamentos=new Medicamentos();
    }
}