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
 * @author dova
 */
@RestController
@RequestMapping("/api")      //Identifica la clase para mapeo para servicio web, es un URI.
@CrossOrigin //Permite el paso de información nentre servidores

public class ControladorAlquileres {
    @Autowired RepositorioAlquileres repoAlquileres;
    //A continuación van las 5 operaciones básicas con la entidad del mensaje
    
    
    //Metodo GET buscar todos
    @CrossOrigin
    @RequestMapping(value="/alquileres", //Se indica que se hará la uri con el id
            method = RequestMethod.GET, //Request
            headers = {"Accept=application/json"}) //Se da ebncabezado tipo json
    public ArrayList<Alquileres> obtenerToddos()throws Exception{ //se da el id al uri (path) el mismo
        return (ArrayList<Alquileres>)repoAlquileres.findAll(); //al regresar el valor, el controlador transforma el objeto java a json-
    }
    
    //Metodo GET buscar por ID
    @CrossOrigin
    @RequestMapping(value="/alquileres/{idAlquiler}",  //construccion de uri con variable de ruta {}
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    public Alquileres obtenerPorId(@PathVariable String idAlquiler) throws Exception{
            return repoAlquileres.findById(idAlquiler).get();
        }
    
    
    //Metodo POST guardar version para clientes variables (web y desktop) (antigua)
    @CrossOrigin
    @RequestMapping(value = "/alquileres/"
            + "{idUsuario}/"
            + "{idAuto}/"
            + "{idSeguro}/"
            + "{duracionDias}/"
            + "{costoTotal}/"
            + "{fechaAlquiler}", 
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarAlquileres(
            @PathVariable String idUsuario,
            @PathVariable String idAuto,
            @PathVariable String idSeguro,
            @PathVariable Integer duracionDias,
            @PathVariable Double costoTotal,
            @PathVariable String fechaAlquiler)
            throws Exception{
        repoAlquileres.save(new Alquileres(idUsuario, idAuto, idSeguro, duracionDias, costoTotal, fechaAlquiler));
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        return estatus;
    }
    
    //Metodo POST guardar pero es una version mas pura y efectiva (moderni)
    @CrossOrigin
    @RequestMapping(value = "/alquileres",
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarAlquileresMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Alquileres mensa = mapper.readValue(json, Alquileres.class); //mapear json a Alquileres
        repoAlquileres.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    //Metodo PUT actualizar
    @CrossOrigin
     @RequestMapping(value = "/alquileres",
            method = RequestMethod.PUT,
            headers = {"Accept=application/json"})
    public Estatus actualizarAlquileresMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Alquileres mensa = mapper.readValue(json, Alquileres.class); //mapear json a Alquileres
        repoAlquileres.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
   //Metodo DELETE 
    @CrossOrigin
    @RequestMapping(value = "/alquileres/{idAlquiler}",
            method = RequestMethod.DELETE,
            headers = {"Accept=application/json"})
    public Estatus borrarAlquileresMejorado(@PathVariable String idAlquiler)
            throws Exception{
        //Transformar el json a java 
        repoAlquileres.delete(new Alquileres(idAlquiler));
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es; 
    }
    
    
}
