/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.myRetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.sg.myRetail.Model.Product;
import com.sg.myRetail.Repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author Dreamville
 */
@Service
public class ProductServiceImpl implements ProductService{
   
     
   
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    
    
}
