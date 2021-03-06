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
public class ControladorAutos {
    @Autowired RepositorioAutos repoAutos;
    //A continuación van las 5 operaciones básicas con la entidad del mensaje
    
    
    //Metodo GET buscar todos
    @CrossOrigin
    @RequestMapping(value="/autos", //Se indica que se hará la uri con el id
            method = RequestMethod.GET, //Request
            headers = {"Accept=application/json"}) //Se da ebncabezado tipo json
    public ArrayList<Autos> obtenerToddos()throws Exception{ //se da el id al uri (path) el mismo
        return (ArrayList<Autos>)repoAutos.findAll(); //al regresar el valor, el controlador transforma el objeto java a json-
    }
    
    //Metodo GET buscar por ID
    @CrossOrigin
    @RequestMapping(value="/autos/{idAuto}",  //construccion de uri con variable de ruta {}
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    public Autos obtenerPorId(@PathVariable String idAuto) throws Exception{
            return repoAutos.findById(idAuto).get();
        }
    
    
    //Metodo POST guardar version para clientes variables (web y desktop) (antigua)
    @CrossOrigin
    @RequestMapping(value = "/autos/"
            + "{placas}/"
            + "{noMotor}/"
            + "{vin}/"
            + "{tipo}/"
            + "{marca}/"
            + "{modelo}/"
            + "{color}/"
            + "{ano}/"
            + "{puertas}/"
            + "{registro}/"
            + "{estatus}", 
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarAutos(
            @PathVariable String placas,
            @PathVariable String noMotor,
            @PathVariable String vin,
            @PathVariable String tipo,
            @PathVariable String marca,
            @PathVariable String modelo,
            @PathVariable String color,
            @PathVariable Integer ano,
            @PathVariable Integer puertas,
            @PathVariable String registro,
            @PathVariable String estatus
            )throws Exception{
        repoAutos.save(new Autos(placas, noMotor, vin, tipo, marca, modelo, color, ano, puertas, registro, estatus));
        Estatus sestatus = new Estatus();
        sestatus.setSuccess(true);
        return sestatus;
    }
    
    //Metodo POST guardar pero es una version mas pura y efectiva (moderni)
    @CrossOrigin
    @RequestMapping(value = "/autos",
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarAutosMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Autos mensa = mapper.readValue(json, Autos.class); //mapear json a Autos
        repoAutos.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    //Metodo PUT actualizar
    @CrossOrigin
     @RequestMapping(value = "/autos",
            method = RequestMethod.PUT,
            headers = {"Accept=application/json"})
    public Estatus actualizarAutosMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Autos mensa = mapper.readValue(json, Autos.class); //mapear json a Autos
        repoAutos.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
   //Metodo DELETE 
    @CrossOrigin
    @RequestMapping(value = "/autos/{idAuto}",
            method = RequestMethod.DELETE,
            headers = {"Accept=application/json"})
    public Estatus borrarAutosMejorado(@PathVariable String idAuto)
            throws Exception{
        //Transformar el json a java 
        repoAutos.delete(new Autos(idAuto));
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
    
    
    
    
    
}
