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
public class Admin {
    @Id
    private String idAdmin;
    private String usuario;
    private String password;

    public Admin() {
    }

    public Admin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Admin(String idAdmin, String usuario, String password) {
        this.idAdmin = idAdmin;
        this.usuario = usuario;
        this.password = password;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
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
    
}
