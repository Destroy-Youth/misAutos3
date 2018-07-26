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

public class ControladorSeguros {
    @Autowired RepositorioSeguros repoSeguros;
    //A continuación van las 5 operaciones básicas con la entidad del mensaje
    
    
    //Metodo GET buscar todos
    @CrossOrigin
    @RequestMapping(value="/seguros", //Se indica que se hará la uri con el id
            method = RequestMethod.GET, //Request
            headers = {"Accept=application/json"}) //Se da ebncabezado tipo json
    public ArrayList<Seguros> obtenerToddos()throws Exception{ //se da el id al uri (path) el mismo
        return (ArrayList<Seguros>)repoSeguros.findAll(); //al regresar el valor, el controlador transforma el objeto java a json-
    }
    
    //Metodo GET buscar por ID
    @CrossOrigin
    @RequestMapping(value="/seguros/{idSeguros}",  //construccion de uri con variable de ruta {}
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    public Seguros obtenerPorId(@PathVariable String idSeguros) throws Exception{
            return repoSeguros.findById(idSeguros).get();
        }
    
    
    //Metodo POST guardar version para clientes variables (web y desktop) (antigua)
    @CrossOrigin
    @RequestMapping(value = "/seguros/"
            + "{tipo}/"
            + "{costo}/"
            + "{caracteristicas}", 
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarSeguros(
            @PathVariable String tipo,
            @PathVariable double costo,
            @PathVariable String caracteristicas)
            throws Exception{
        repoSeguros.save(new Seguros(tipo, costo, caracteristicas));
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        return estatus;
    }
    
    //Metodo POST guardar pero es una version mas pura y efectiva (moderni)
    @CrossOrigin
    @RequestMapping(value = "/seguros",
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarSegurosMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Seguros mensa = mapper.readValue(json, Seguros.class); //mapear json a Seguros
        repoSeguros.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    //Metodo PUT actualizar
    @CrossOrigin
     @RequestMapping(value = "/seguros",
            method = RequestMethod.PUT,
            headers = {"Accept=application/json"})
    public Estatus actualizarSegurosMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Seguros mensa = mapper.readValue(json, Seguros.class); //mapear json a Seguros
        repoSeguros.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
   //Metodo DELETE 
    @CrossOrigin
    @RequestMapping(value = "/seguros/{idSeguros}",
            method = RequestMethod.DELETE,
            headers = {"Accept=application/json"})
    public Estatus borrarSegurosMejorado(@PathVariable String idSeguros)
            throws Exception{
        //Transformar el json a java 
        repoSeguros.delete(new Seguros(idSeguros));
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
    
}
