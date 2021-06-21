/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.myRetail.Controller;

import com.sg.myRetail.Exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.sg.myRetail.Model.Product;
import com.sg.myRetail.Repository.ProductRepository;
import com.sg.myRetail.service.ProductService;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Dreamville
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductService productService;
    
    private static final String TARGET = "https://redsky.target.com/v2/pdp/tcin/";
    
    private static final String DATA = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") String productID) throws ProductNotFoundException{
            
        String productName = getProductNameAPI(productID);
        if(productName == null) {
            
            throw new ProductNotFoundException("The product could not be found");
        }
        
        Product mongodbData = productRepository.findById(productID).orElse(null);
        
        if (mongodbData == null) {
            
            throw new ProductNotFoundException("The product could not be found");
        }
        
        mongodbData.setProductName(productName);
        
        return mongodbData;
    }
    
    
    private String getProductNameAPI(String productID) throws ProductNotFoundException {
      
        String productName = null;
        
        try {
           String rawJSON = TARGET + productID + DATA;
           
           JSONObject root = new JSONObject(rawJSON);
           
           JSONArray products = root.getJSONArray("product");
           
           for(int i = 0; i < products.length(); i++) {
               
             JSONObject jsonProduct = products.getJSONObject(i);
             
             Product p = new Product();
             
             jsonProduct.getString("item");
             jsonProduct.getString("product_description");
             jsonProduct.getString("title");
                  
           }
      
         } catch (Exception e) {
            throw new ProductNotFoundException("product not found");
        }
       
        return productName;
    }

}