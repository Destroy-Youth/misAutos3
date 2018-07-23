package org.unitec.misAutos3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Iván
 */
public interface RepositorioAdmin extends MongoRepository<Admin,String>{
    
}
