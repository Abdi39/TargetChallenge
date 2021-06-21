/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.myRetail.Controller;

import com.sg.myRetail.Model.Price;
import com.sg.myRetail.Model.Product;
import com.sg.myRetail.Repository.ProductRepository;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Dreamville
 */
public class ProductControllerTest {
    
    @Autowired
    private ProductRepository productRepository;
    
    MockMvc mock;
    
    @Autowired
    WebApplicationContext webApp;
    
    public ProductControllerTest() {
    }
    
    private Product getProduct() {
        Product p = new Product();
        p.setProductID("13860428");
        p.setProductName("The Big Lebowski (Blu-ray)");
        p.setPrice(new Price(new BigDecimal("14.99"), "USA"));
        return p;
    }

    @BeforeEach
    public void setUp() {
        
        this.mock = MockMvcBuilders.webAppContextSetup(webApp).dispatchOptions(true).build();
        Product product; getProduct();   
    }
    
    @AfterEach
    public void tearDown() {
        for (Product p : productRepository.findAll()) {
            productRepository.delete(p);
        }
    }

    /**
     * Test of getProductById method, of class ProductController.
     */
    @Test
    public void testGetProductById() throws Exception {
        Mockito.doReturn(getProduct()).when(productRepository).findById(Mockito.any());
    }
    
}
