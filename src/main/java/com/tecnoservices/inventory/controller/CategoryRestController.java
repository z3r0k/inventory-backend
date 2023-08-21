/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnoservices.inventory.controller;

import com.tecnoservices.inventory.response.CategoryResponseRest;
import com.tecnoservices.inventory.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Janus
 */
@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
    
    @Autowired
    private ICategoryServices service;
    
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }
    
}
