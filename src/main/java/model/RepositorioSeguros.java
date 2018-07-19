/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Iván
 */
public interface RepositorioSeguros extends MongoRepository<Seguros, String>{
    
}
