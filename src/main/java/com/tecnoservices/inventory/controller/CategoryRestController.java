/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnoservices.inventory.controller;

import com.tecnoservices.inventory.model.Category;
import com.tecnoservices.inventory.response.CategoryResponseRest;
import com.tecnoservices.inventory.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Janus
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
    
    @Autowired
    private ICategoryServices service;
    
    
    /**
     * Get all the categories
     * @return 
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }
    
    
    /**
     * Get categories by id
     * @param id
     * @return 
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    

    }
    
     /**
     * 
     * save categories
     * @param Category
     * @return 
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){
        
        ResponseEntity<CategoryResponseRest> response = service.save(category);
        return response;
        
    }
    
 /**
  * 
  * update categories
  * @param category
  * @param id
  * @return 
  */
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id){
        
        ResponseEntity<CategoryResponseRest> response = service.update(category, id);
        return response;
        
    }
    
/**
 * delete categories
 * @param id
 * @return 
 */
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id){
        
        ResponseEntity<CategoryResponseRest> response = service.deleteById( id);
        return response;
        
    }
        
}
