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
@RequestMapping("/api")            //Identifica la clase para mapeo para servicio web, es un URI.
@CrossOrigin //Permite el paso de información nentre servidores

public class ControladorUsuario {
    @Autowired RepositorioUsuario repoUsuario;
    //A continuación van las 5 operaciones básicas con la entidad del mensaje
    
    
    //Metodo GET buscar todos
    @CrossOrigin
    @RequestMapping(value="/usuario", //Se indica que se hará la uri con el id
            method = RequestMethod.GET, //Request
            headers = {"Accept=application/json"}) //Se da ebncabezado tipo json
    public ArrayList<Usuario> obtenerToddos()throws Exception{ //se da el id al uri (path) el mismo
        return (ArrayList<Usuario>)repoUsuario.findAll(); //al regresar el valor, el controlador transforma el objeto java a json-
    }
    
    //Metodo GET buscar por ID
    @CrossOrigin
    @RequestMapping(value="/usuario/{idUsuario}",  //construccion de uri con variable de ruta {}
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    public Usuario obtenerPorId(@PathVariable String idUsuario) throws Exception{
            return repoUsuario.findById(idUsuario).get();
        }
    
    
    //Metodo POST guardar version para clientes variables (web y desktop) (antigua)
    @CrossOrigin
    @RequestMapping(value = "/usuario/"
            + "{usuario}/"
            + "{password}/"
            + "{edad}/"
            + "{correo}/"
            + "{direccion}/"
            + "{tarjetaCredito}/"
            + "{nombre}/"
            + "{aPaterno}/"
            + "{aMaterno}/"
            + "{telefono}", 
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarUsuario(
            @PathVariable String usuario,
            @PathVariable String password,
            @PathVariable Integer edad,
            @PathVariable String correo,
            @PathVariable String direccion,
            @PathVariable String tarjetaCredito,
            @PathVariable String nombre,
            @PathVariable String aPaterno,
            @PathVariable String aMaterno,
            @PathVariable String telefono)
            throws Exception{
        repoUsuario.save(new Usuario(usuario, password, edad, correo, direccion, tarjetaCredito, nombre, aPaterno, aMaterno, telefono));
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        return estatus;
    }
    
    //Metodo POST guardar pero es una version mas pura y efectiva (moderni)
    @CrossOrigin
    @RequestMapping(value = "/usuario",
            method = RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarUsuarioMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Usuario mensa = mapper.readValue(json, Usuario.class); //mapear json a Usuario
        repoUsuario.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    //Metodo PUT actualizar
    @CrossOrigin
     @RequestMapping(value = "/usuario",
            method = RequestMethod.PUT,
            headers = {"Accept=application/json"})
    public Estatus actualizarUsuarioMejorado(@RequestBody String json)
            throws Exception{
        //Transformar el json a java
        ObjectMapper mapper=new ObjectMapper();
        Usuario mensa = mapper.readValue(json, Usuario.class); //mapear json a Usuario
        repoUsuario.save(mensa);
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
   //Metodo DELETE 
    @CrossOrigin
    @RequestMapping(value = "/usuario/{idUsuario}",
            method = RequestMethod.DELETE,
            headers = {"Accept=application/json"})
    public Estatus borrarUsuarioMejorado(@PathVariable String idUsuario)
            throws Exception{
        //Transformar el json a java 
        repoUsuario.delete(new Usuario(idUsuario));
        Estatus es= new Estatus();
        es.setSuccess(true);
        return es;
    }
    
    
}
