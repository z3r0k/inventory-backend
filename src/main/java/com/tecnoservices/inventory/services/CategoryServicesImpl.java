/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnoservices.inventory.services;

import com.tecnoservices.inventory.dao.ICategoryDao;
import com.tecnoservices.inventory.model.Category;
import com.tecnoservices.inventory.response.CategoryResponseRest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Janus
 */
@Service
public class CategoryServicesImpl implements  ICategoryServices {
    
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
       
        CategoryResponseRest response = new  CategoryResponseRest();
        
        try {
            
            List<Category> category = (List<Category>) categoryDao.findAll();
            
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta Ok", "00", "Respuesta Exitosa");
            
        } catch (Exception e) {
            
            
         response.setMetadata("Respuesta Error", "-1", "Error al consultar");
         e.getStackTrace();
           return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
          
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }   
}
