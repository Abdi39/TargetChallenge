/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.myRetail.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *
 * @author Dreamville
 */
@Document(collection = "products")
public class Product {
    
    @Id
    @JsonProperty("id")
    private String productID;
    
    @JsonProperty("name")
    private String productName;
    
    @JsonProperty("current_price")
    private Price price;
    
    
    public Product() {
        
    }

    
    
    public Product(String productID, String productName, Price price ) {
        
        this.productID = productID;
        
        this.productName = productName;
        
        this.price = price;
        
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
    
    

  
    
    
}
