package org.unitec.misAutos3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import org.springframework.data.annotation.Id;

/**
 *
 * @author Iván
 */
public class Alquileres {
    @Id
    private String idAlquiler;
    private String idUsuario;
    private String idAuto;
    private String idSeguro;
    private Integer duracionDias;
    private double costoTotal;
    private String fechaAlquiler;

    public Alquileres() {
    }

    public Alquileres(String idUsuario, String idAuto, String idSeguro, Integer duracionDias, double costoTotal, String fechaAlquiler) {
        this.idUsuario = idUsuario;
        this.idAuto = idAuto;
        this.idSeguro = idSeguro;
        this.duracionDias = duracionDias;
        this.costoTotal = costoTotal;
        this.fechaAlquiler = fechaAlquiler;
    }

    public Alquileres(String idAlquiler, String idUsuario, String idAuto, String idSeguro, Integer duracionDias, double costoTotal, String fechaAlquiler) {
        this.idAlquiler = idAlquiler;
        this.idUsuario = idUsuario;
        this.idAuto = idAuto;
        this.idSeguro = idSeguro;
        this.duracionDias = duracionDias;
        this.costoTotal = costoTotal;
        this.fechaAlquiler = fechaAlquiler;
    }

    public Alquileres(String idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(String idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto = idAuto;
    }

    public String getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(String idSeguro) {
        this.idSeguro = idSeguro;
    }

    public Integer getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }
    
    
}
