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
public class Usuario {
    @Id
    private String idUsuario;
    private String usuario;
    private String password;
    private Integer edad;
    private String correo;
    private String direccion;
    private String tarjetaCredito;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String telefono;

    public Usuario() {
    }

    public Usuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String usuario, String password, Integer edad, String correo, String direccion, String tarjetaCredito, String nombre, String aPaterno, String aMaterno, String telefono) {
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.telefono = telefono;
    }

    public Usuario(String idUsuario, String usuario, String password, Integer edad, String correo, String direccion, String tarjetaCredito, String nombre, String aPaterno, String aMaterno, String telefono) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.telefono = telefono;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
