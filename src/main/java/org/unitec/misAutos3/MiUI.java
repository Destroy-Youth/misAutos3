/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.misAutos3;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dova
 */
@SpringUI
@Theme("valo")
public class MiUI extends UI {

    @Autowired
    RepositorioAdmin repoAdmin;
    
    VerticalLayout layoutVert;
    TabInicio tabInicio = new TabInicio();

    public static Admin admin;
    public static ArrayList<Admin> adminAll;

    @Override
    protected void init(VaadinRequest request) {
        autenticacion();

    }

    public void autenticacion() {

        TabSheet tabs = new TabSheet();
        layoutVert=new VerticalLayout();
        //Creacion de ventana
        Window subWindowAutenticar = new Window("Login");
        subWindowAutenticar.setClosable(false);
        //Formulario de login
        VerticalLayout subLogin = new VerticalLayout();
        subWindowAutenticar.setContent(subLogin);

        subWindowAutenticar.center();
        subWindowAutenticar.setWidth("350px");
        addWindow(subWindowAutenticar);

        //Extracción de usuarios
        adminAll = (ArrayList<Admin>) repoAdmin.findAll();
        ComboBox<Admin> opciones = new ComboBox<>();
        opciones.setPlaceholder("Introduzca su usuario");
        opciones.setItems(adminAll);
        opciones.setWidth("100%");
        //Añadir usuarios a cob¿mbobox
        opciones.setItemCaptionGenerator(Admin::getUsuario);

        final Label labelBienvenida = new Label("Bienvenido");
        subLogin.addComponent(labelBienvenida);
        final PasswordField adminPasswordField = new PasswordField("Introduzca password");

        //Añadir componentes a formulario
        subLogin.addComponent(opciones);
        subLogin.addComponent(adminPasswordField);

        Button botonAutenticar = new Button("Ingresar", FontAwesome.LOCK);
        botonAutenticar.addStyleName(ValoTheme.BUTTON_PRIMARY);
        subLogin.addComponent(botonAutenticar);
        botonAutenticar.addClickListener(ingresar -> {

            admin = new Admin();
            admin=opciones.getValue();
            System.out.println(admin.getUsuario() + adminPasswordField.getValue());
            System.out.println(admin.getPassword().equals(adminPasswordField.getValue())+"tei");
            if (admin.getPassword().equals(adminPasswordField.getValue())) {
            
            //if(true){
                String sesionId = VaadinSession.getCurrent().getSession().getId();
                VaadinSession.getCurrent().setAttribute("idAdmin", admin.getIdAdmin());

                subWindowAutenticar.close();

                //  tabito.addTab(tabInicio,"Inicio",FontAwesome.HOME);
                // Create a sub-window and set the content
                //  tabito.removeComponent(v1);
                tabs.addTab(tabInicio,"Inicio",FontAwesome.BOOK);
            } else {
                labelBienvenida.addStyleName(ValoTheme.LABEL_FAILURE);
                labelBienvenida.setValue("DATOS INCORRECTOS");
            }

        });
    }
    
    public void inicio(){
        
    }
}
