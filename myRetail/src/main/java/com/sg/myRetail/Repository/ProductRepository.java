/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.myRetail.Repository;

import com.sg.myRetail.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Dreamville
 */
public interface ProductRepository extends MongoRepository<Product, String>{
    
}
