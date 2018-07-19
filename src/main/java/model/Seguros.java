/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Iván
 */
public class Seguros {
    @Id
    private String idSeguros;
    private String tipo;
    private double costo;
    private String caracteristicas;

    public Seguros() {
    }

    public Seguros(String idSeguros) {
        this.idSeguros = idSeguros;
    }

    public Seguros(String tipo, double costo, String caracteristicas) {
        this.tipo = tipo;
        this.costo = costo;
        this.caracteristicas = caracteristicas;
    }

    public Seguros(String idSeguros, String tipo, double costo, String caracteristicas) {
        this.idSeguros = idSeguros;
        this.tipo = tipo;
        this.costo = costo;
        this.caracteristicas = caracteristicas;
    }

    public String getIdSeguros() {
        return idSeguros;
    }

    public void setIdSeguros(String idSeguros) {
        this.idSeguros = idSeguros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
