package org.unitec.misAutos3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Iván
 */
public class Autos {
    @Id
    private String idAuto;
    private String placas;
    private String noMotor;
    private String vin;
    private String tipo;
    private String marca;
    private String modelo;
    private String color;
    private Integer ano;
    private Integer puertas;
    private Date registro;
    private String estatus;

    public Autos() {
    }

    public Autos(String placas, String noMotor, String vin, String tipo, String marca, String modelo, String color, Integer ano, Integer puertas, Date registro, String estatus) {
        this.placas = placas;
        this.noMotor = noMotor;
        this.vin = vin;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ano = ano;
        this.puertas = puertas;
        this.registro = registro;
        this.estatus = estatus;
    }

    public Autos(String idAuto, String placas, String noMotor, String vin, String tipo, String marca, String modelo, String color, Integer ano, Integer puertas, Date registro, String estatus) {
        this.idAuto = idAuto;
        this.placas = placas;
        this.noMotor = noMotor;
        this.vin = vin;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ano = ano;
        this.puertas = puertas;
        this.registro = registro;
        this.estatus = estatus;
    }

    public String getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto = idAuto;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getNoMotor() {
        return noMotor;
    }

    public void setNoMotor(String noMotor) {
        this.noMotor = noMotor;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getPuertas() {
        return puertas;
    }

    public void setPuertas(Integer puertas) {
        this.puertas = puertas;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
