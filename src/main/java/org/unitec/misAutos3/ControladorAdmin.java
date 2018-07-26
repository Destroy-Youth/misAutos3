/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.misAutos3;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Iván
 */
@RestController
@RequestMapping("/api")             //("/mensajito") //Identifica la clase para mapeo para servicio web, es un URI.
@CrossOrigin //Permite el paso de información nentre servidores

public class ControladorAdmin {
    
    @Autowired RepositorioAdmin repoAdmin;
    //A continuación van las 5 operaciones básicas con la entidad del mensaje
    
    
    //Metodo GET buscar todos
    @CrossOrigin
    @RequestMapping(value="/admin", //Se indica que se hará la uri con el id
            method = RequestMethod.GET, //Request
            headers = {"Accept=application/json"}) //Se da ebncabezado tipo json
    public ArrayList<Admin> obtenerToddos()throws Exception{ //se da el id al uri (path) el mismo
        return (ArrayList<Admin>)repoAdmin.findAll(); //al regresar el valor, el controlador transforma el objeto java a json-
    }
    
    //Metodo GET buscar por ID
    @CrossOrigin
    @RequestMapping(value="/admin/{idAdmin}",  //construccion de uri con variable de ruta {}
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    public Admin obtenerPorId(@PathVariable String idAdmin) throws Exception{
            return repoAdmin.findById(idAdmin).get();
        }
    
    
    //Metodo POST guardar version para clientes variables (web y desktop) (antigua)
    @CrossOrigin
    @RequestMapping(value = "/admin/{usuario}/{password}", 
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarAdmin(@PathVariable String usuario,
            @PathVariable String password)throws Exception{
        repoAdmin.save(new Admin(usuario, password));
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        return estatus;
    }
    
    //Metodo POST guardar pero es una version mas pura y efectiva (moderni)
    @CrossOrigin
    @RequestMapping(value = "/admin",
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarAdminMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Admin mensa = mapper.readValue(json, Admin.class); //mapear json a Admin
        repoAdmin.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    //Metodo PUT actualizar
    @CrossOrigin
     @RequestMapping(value = "/admin",
            method = RequestMethod.PUT,
            headers = {"Accept=application/json"})
    public Estatus actualizarAdminMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Admin mensa = mapper.readValue(json, Admin.class); //mapear json a Admin
        repoAdmin.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
   //Metodo DELETE 
    @CrossOrigin
    @RequestMapping(value = "/admin/{idAdmin}",
            method = RequestMethod.DELETE,
            headers = {"Accept=application/json"})
    public Estatus borrarAdminMejorado(@PathVariable String idAdmin)
            throws Exception{
        //Transformar el json a java 
        repoAdmin.delete(new Admin(idAdmin));
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
    
}
